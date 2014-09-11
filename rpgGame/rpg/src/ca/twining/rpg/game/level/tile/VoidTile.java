package ca.twining.rpg.game.level.tile;

import java.awt.Rectangle;

import ca.twining.rpg.game.Screen;
import ca.twining.rpg.game.graphics.Sprite;

public class VoidTile extends Tile {

	public VoidTile(Sprite sprite) {
		super(sprite);
	}
	
	public void draw(int x, int y, Screen screen){
		screen.drawTile(x << 4, y << 4, this);
	}
	
	public Rectangle collisionBounds(){
		return new Rectangle(x, y, sprite.SIZE, sprite.SIZE);
	}
	
	public boolean solid(){
		return true;
	}

}
