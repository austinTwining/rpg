package ca.twining.rpg.game.entity.item.projectile;

import java.awt.Rectangle;

import ca.twining.rpg.game.Screen;
import ca.twining.rpg.game.entity.Entity;
import ca.twining.rpg.game.graphics.Sprite;

public class Projectile extends Entity{
	
	public int speed;
	public Sprite sprite;
	
	public int damage;
	
	public Projectile(int speed, int damage, Sprite sprite){
		this.speed = speed;
		this.damage = damage;
		this.sprite = sprite;
	}
	
	public void update(){
		
	}
	
	public void draw(Screen screen){
		
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, sprite.SIZE, sprite.SIZE);
	}

}
