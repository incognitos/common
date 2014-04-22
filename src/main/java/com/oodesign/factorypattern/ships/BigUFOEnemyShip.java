package com.oodesign.factorypattern.ships;

import com.oodesign.factorypattern.EnemyShipFactory;

public class BigUFOEnemyShip extends UFOEnemyShip {
	
	static
	{
		EnemyShipFactory.getInstance().registerEnemyShipType("B", new BigUFOEnemyShip());
	}
	
	
	public BigUFOEnemyShip(){
		
		setName("Big UFO Enemy Ship");
		
		setDamage(40.0);
		
	}
	
	@Override
	public EnemyShip createEnemyShip() {
		// TODO Auto-generated method stub
		return new BigUFOEnemyShip();
	}
	
}
