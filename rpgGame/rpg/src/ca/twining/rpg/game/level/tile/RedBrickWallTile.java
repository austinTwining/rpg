package ca.twining.rpg.game.level.tile;

import java.awt.Rectangle;

import ca.twining.rpg.game.Screen;
import ca.twining.rpg.game.graphics.Sprite;

public class RedBrickWallTile extends Tile{

	public RedBrickWallTile(Sprite sprite) {
		super(sprite);
	}
	
	public void draw(int x, int y, Screen screen){
		screen.drawTile(x << 4, y << 4, this);
	}
	
	public Rectangle collisionBounds(){
		return new Rectangle(x, y, sprite.SIZE, sprite.SIZE);
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public boolean solid(){
		return true;
	}

}
