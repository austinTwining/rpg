package ca.twining.rpg.game.entity.item;

import ca.twining.rpg.game.entity.item.projectile.Projectile;

public class FireStaff extends Weapon{
	
	public FireStaff(){
		this.tier = 1;
		this.damage = tier;
		this.usesProjectiles = true;
		this.name = "Fire Staff";
	}
	
	public void attack(){
		level.spawnEntity(new Projectile(2, damage, null));
	}
	
	public void setName(String name){
		this.name = name;
	}

}
