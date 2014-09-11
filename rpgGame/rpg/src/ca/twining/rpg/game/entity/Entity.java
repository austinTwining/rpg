package ca.twining.rpg.game.entity;

import java.awt.Rectangle;

import ca.twining.rpg.game.Screen;
import ca.twining.rpg.game.graphics.Sprite;
import ca.twining.rpg.game.level.Level;

public abstract class Entity {
	
	public  int x;
	public  int y;
	private boolean removed = false;
	
	
	public EntityId id;
	
	public Sprite sprite;
	
	public Level level;
	
	public void update(){
		if(removed){
			level.removeEntity(this);
		}
	}
	
	public void init(Level level){
		this.level = level;
	}
	
	public void draw(Screen screen){
	}
	
	public Rectangle collisionBounds(){
		return new Rectangle(x, y, sprite.SIZE, sprite.SIZE);
	}
	
	public void onCollisionEntity(Entity entity, Level level){
	}
	
	public void onCollisionTile(int tile){
	}
	
	public EntityId getId(){
		return id;
	}

	public void remove(){
		removed = true;
	}
	
	public boolean isRemoved(){
		return removed;
	}

}
