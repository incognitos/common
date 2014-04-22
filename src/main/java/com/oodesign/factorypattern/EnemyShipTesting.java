package com.oodesign.factorypattern;

import java.util.Scanner;

import com.oodesign.factorypattern.ships.EnemyShip;
import com.oodesign.factorypattern.EnemyShipFactory;

public class EnemyShipTesting {
	
	static
	{
		try
		{
			Class.forName("com.oodesign.factorypattern.ships.EnemyShip");
			Class.forName("com.oodesign.factorypattern.ships.RocketEnemyShip");
			Class.forName("com.oodesign.factorypattern.ships.BigUFOEnemyShip");
		}
		catch (ClassNotFoundException any)
		{
			any.printStackTrace();
		}
	}

	public static void main(String[] args){
		
		// Create the factory object
		//EnemyShipFactory shipFactory = new EnemyShipFactory();
		
		// Enemy ship object
		
		EnemyShip theEnemy = null;
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("What type of ship? (U / R / B)");
		
		if (userInput.hasNextLine()){
			
			String typeOfShip = userInput.nextLine();
			
			theEnemy = EnemyShipFactory.getInstance().createEnemyShip(typeOfShip);
			
			if(theEnemy != null){
				
				doStuffEnemy(theEnemy);
				
			} else System.out.print("Please enter U, R, or B next time");
		
		}
		
		/*
		EnemyShip theEnemy = null;
		
		// Old way of creating objects
		// When we use new we are not being dynamic
		
		EnemyShip ufoShip = new UFOEnemyShip();
		
		doStuffEnemy(ufoShip);
		
		System.out.print("\n");
		
		// -----------------------------------------
		
		// This allows me to make the program more dynamic
		// It doesn't close the code from being modified
		// and that is bad!
		
		// Defines an input stream to watch: keyboard
		Scanner userInput = new Scanner(System.in);
		
		String enemyShipOption = "";
		
		System.out.print("What type of ship? (U or R)");
		
		if (userInput.hasNextLine()){
			
			enemyShipOption = userInput.nextLine();
			
		}
		
		if (enemyShipOption == "U"){
			
			theEnemy = new UFOEnemyShip();

			
		} else 
		
		if (enemyShipOption == "R"){
			
			theEnemy = new RocketEnemyShip();
			
		} else {
			
			theEnemy = new BigUFOEnemyShip();
			
		}
		
		doStuffEnemy(theEnemy);
		
		// --------------------------------------------
		*/
		
	}
	
	// Executes methods of the super class
	
	public static void doStuffEnemy(EnemyShip anEnemyShip){
		
		anEnemyShip.displayEnemyShip();
		
		anEnemyShip.followHeroShip();
		
		anEnemyShip.enemyShipShoots();
		
	}
	
}

