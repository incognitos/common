package com.oodesign.factorypattern;

import java.util.HashMap;

//import com.oodesign.factorypattern.ships.BigUFOEnemyShip;
import com.oodesign.factorypattern.ships.EnemyShip;
//import com.oodesign.factorypattern.ships.RocketEnemyShip;
//import com.oodesign.factorypattern.ships.UFOEnemyShip;

public class EnemyShipFactory {
	
	
	//codes from http://howtodoinjava.com/2012/10/22/singleton-design-pattern-in-java/
	private EnemyShipFactory() {
		
	}
	
	private static class LazyHolder {
		private static final EnemyShipFactory INSTANCE = new EnemyShipFactory();
	}
	
	private HashMap<String, EnemyShip> m_RegisteredProducts = new HashMap<String, EnemyShip>();
	

	
//	public EnemyShip makeEnemyShip(String newShipType){
//
//		EnemyShip newShip = null;
//		if (newShipType.equals("U")){
//			
//			return new UFOEnemyShip();
//			
//		} else 
//		
//		if (newShipType.equals("R")){
//			
//			return new RocketEnemyShip();
//			
//		} else 
//		
//		if (newShipType.equals("B")){
//			
//			return new BigUFOEnemyShip();
//			
//		} else return null;
//		
//	}
	
	public void registerEnemyShipType(String enemyShipType, EnemyShip enemyShip)    {
		m_RegisteredProducts.put(enemyShipType, enemyShip);
	}

	public EnemyShip createEnemyShip(String enemyShip){
		return ((EnemyShip)m_RegisteredProducts.get(enemyShip)).createEnemyShip();
	}

	public static EnemyShipFactory getInstance() {
		return LazyHolder.INSTANCE;
	}
}
