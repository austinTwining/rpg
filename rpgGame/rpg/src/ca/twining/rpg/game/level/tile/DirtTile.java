package ca.twining.rpg.game.level.tile;

import ca.twining.rpg.game.Screen;
import ca.twining.rpg.game.graphics.Sprite;

public class DirtTile extends Tile {

	public DirtTile(Sprite sprite) {
		super(sprite);
	}
	
	public void draw(int x, int y, Screen screen){
		screen.drawTile(x << 4, y << 4, this);
	}

}
