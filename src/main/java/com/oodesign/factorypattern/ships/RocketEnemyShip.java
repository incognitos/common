package com.oodesign.factorypattern.ships;

import com.oodesign.factorypattern.EnemyShipFactory;

public class RocketEnemyShip extends EnemyShip {
	
	static
	{
		EnemyShipFactory.getInstance().registerEnemyShipType("R", new RocketEnemyShip());
	}
	
	public RocketEnemyShip(){
		setName("Rocket Enemy Ship");
		setDamage(10.0);
	}

	
	@Override
	public EnemyShip createEnemyShip() {
		// TODO Auto-generated method stub
		return new RocketEnemyShip();
	}
	
}