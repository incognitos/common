package com.oodesign.factorypattern.ships;

import com.oodesign.factorypattern.EnemyShipFactory;

public class UFOEnemyShip extends EnemyShip {
	
	static
	{
		EnemyShipFactory.getInstance().registerEnemyShipType("U", new UFOEnemyShip());
	}
	
	public UFOEnemyShip(){
		
		setName("UFO Enemy Ship");
		setDamage(20.0);
		
	}

	@Override
	public EnemyShip createEnemyShip() {
		// TODO Auto-generated method stub
		return new UFOEnemyShip();
	}
	
}
