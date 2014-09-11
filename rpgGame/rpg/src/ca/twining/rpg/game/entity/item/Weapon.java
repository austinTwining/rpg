package ca.twining.rpg.game.entity.item;

public abstract class Weapon extends Item{
	
	public int damage;
	public int tier;
	public int durability;
	
	public String name = " ";
	
	public boolean usesProjectiles;
	
	public void attack(){
		
	}
	
	public void setTier(int tier){
		this.tier = tier;
	}
	
	public int getTier(){
		return tier;
	}

}
