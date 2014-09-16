package ca.twining.rpg.game;

import ca.twining.rpg.game.entity.mob.Player;
import ca.twining.rpg.game.graphics.Image;
import ca.twining.rpg.game.graphics.Sprite;
import ca.twining.rpg.game.level.Level;
import ca.twining.rpg.game.level.tile.Tile;

public class Screen {
	public int width;
	public int height;

	public static int xOffset;
	public static int yOffset;

	public int[] pixels;

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;

		pixels = new int[width * height];
	}

	public void clear() {
		// clear the screen
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}
	
	public void drawMiniMap(int xp, int yp, int w, int h, Level level, Player player){
		for(int y = yp; y < (yp + h); y++){
			for(int x = xp; x < (xp + w); x++){
				Tile tile = level.getTile((((player.x - (w * 16)) + (x))), -((player.y - (h * 16) + (y))));
				System.out.println();
				if(tile == Tile.voidTile) pixels[x + y * width] = 0xff000000;
				else if(tile == Tile.grassTile)pixels[x + y * width] = 0xff007f0e;
				else if(tile == Tile.rockTile)pixels[x + y * width] = 0xff4c4c4c;
				else if(tile == Tile.longGrassTile)pixels[x + y * width] = 0xff8cff99;
				else if(tile == Tile.dirtTile)pixels[x + y * width] = 0xff695200;
				else if(tile == Tile.sandTile)pixels[x + y * width] = 0xffffefa3;
				else if(tile == Tile.lavaTile)pixels[x + y * width] = 0xffff8426;
				else if(tile == Tile.redBrickWallTile)pixels[x + y * width] = 0xffff2014;
				else if(tile == Tile.blackBrickWallTile)pixels[x + y * width] = 0xff111111;
				else pixels[x + y * width] = 0xffff00ff;
			}
		}
	}
	
	public void drawHUD(Image image){
		for(int y = 0; y < image.HEIGHT; y++){
			for(int x = 0; x < image.WIDTH; x++){
				if (x < -image.WIDTH || x >= width || y < 0 || y >= height) break;
				if (x < 0) x = 0;
				int col = image.pixels[x + y * image.WIDTH];
				if (col != 0xffff00ff) pixels[x + y * width] = col;
			}
		}
	}

	public void drawHealthHUD(int xp, int yp, Player player, Sprite sprite1, Sprite sprite2) {
		xp -= xOffset;
		yp -= yOffset;
		
		if(player.health % 2 == 0){
			for(int i = 0; i < (player.health / 2); i++){
				xp = xp + 8;
				for(int y = 0; y < sprite1.SIZE; y++){
					int ya = y + yp;
					for(int x = 0; x < sprite1.SIZE; x++){
						int xa = x + xp;
						if (xa < -sprite1.SIZE || xa >= width || ya < 0 || ya >= height) break;
						if (xa < 0) xa = 0;
						int col = sprite1.pixels[x + y * sprite1.SIZE];
						if (col != 0xffff00ff) pixels[xa + ya * width] = col;
					}
				}
			}
		}else{
			for(int j = 0; j < ((player.health - 1) / 2); j++){
				xp = xp + 8;
				for(int y = 0; y < sprite1.SIZE; y++){
					int ya = y + yp;
					for(int x = 0; x < sprite1.SIZE; x++){
						int xa = x + xp;
						if (xa < -sprite1.SIZE || xa >= width || ya < 0 || ya >= height) break;
						if (xa < 0) xa = 0;
						int col = sprite1.pixels[x + y * sprite1.SIZE];
						if (col != 0xffff00ff) pixels[xa + ya * width] = col;
					}
				}
			}
			xp = xp + 8;
			for(int y = 0; y < sprite2.SIZE; y++){
				int ya = y + yp;
				for(int x = 0; x < sprite2.SIZE; x++){
					int xa = x + xp;
					if (xa < -sprite2.SIZE || xa >= width || ya < 0 || ya >= height) break;
					if (xa < 0) xa = 0;
					int col = sprite2.pixels[x + y * sprite2.SIZE];
					if (col != 0xffff00ff) pixels[xa + ya * width] = col;
				}
			}
		}
	}
	
	public void drawArmourHUD(int xp, int yp, Player player, Sprite sprite1, Sprite sprite2){
		xp -= xOffset;
		yp -= yOffset;
		
		if(player.armourRating % 2 == 0){
			for(int i = 0; i < (player.armourRating / 2); i++){
				xp = xp + 8;
				for(int y = 0; y < sprite1.SIZE; y++){
					int ya = y + yp;
					for(int x = 0; x < sprite1.SIZE; x++){
						int xa = x + xp;
						if (xa < -sprite1.SIZE || xa >= width || ya < 0 || ya >= height) break;
						if (xa < 0) xa = 0;
						int col = sprite1.pixels[x + y * sprite1.SIZE];
						if (col != 0xffff00ff) pixels[xa + ya * width] = col;
					}
				}
			}
		}else{
			for(int j = 0; j < ((player.armourRating - 1) / 2); j++){
				xp = xp + 8;
				for(int y = 0; y < sprite1.SIZE; y++){
					int ya = y + yp;
					for(int x = 0; x < sprite1.SIZE; x++){
						int xa = x + xp;
						if (xa < -sprite1.SIZE || xa >= width || ya < 0 || ya >= height) break;
						if (xa < 0) xa = 0;
						int col = sprite1.pixels[x + y * sprite1.SIZE];
						if (col != 0xffff00ff) pixels[xa + ya * width] = col;
					}
				}
			}
			xp = xp + 8;
			for(int y = 0; y < sprite2.SIZE; y++){
				int ya = y + yp;
				for(int x = 0; x < sprite2.SIZE; x++){
					int xa = x + xp;
					if (xa < -sprite2.SIZE || xa >= width || ya < 0 || ya >= height) break;
					if (xa < 0) xa = 0;
					int col = sprite2.pixels[x + y * sprite2.SIZE];
					if (col != 0xffff00ff) pixels[xa + ya * width] = col;
				}
			}
		}
	}

	public void drawTile(int xp, int yp, Tile tile) {
		xp -= xOffset;
		yp -= yOffset;

		for (int y = 0; y < tile.sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < tile.sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
			}
		}
	}

	public void drawPlayer(int xp, int yp, Sprite sprite, boolean xFlip, boolean yFlip) {
		xp -= xOffset;
		yp -= yOffset;

		for (int y = 0; y < sprite.SIZE; y++) {
			int ya = y + yp;
			int ys = y;
			if (yFlip) {
				ys = (sprite.SIZE - 1) - y;
			}
			for (int x = 0; x < sprite.SIZE; x++) {
				int xa = x + xp;
				int xs = x;
				if (xFlip) {
					xs = (sprite.SIZE - 1) - x;
				}
				if (xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int col = sprite.pixels[xs + ys * sprite.SIZE];
				if (col != 0xffff00ff) pixels[xa + ya * width] = col;
			}
		}
	}
	
	public void drawEnemy(int xp, int yp, Sprite sprite, boolean xFlip, boolean yFlip) {
		xp -= xOffset;
		yp -= yOffset;

		for (int y = 0; y < sprite.SIZE; y++) {
			int ya = y + yp;
			int ys = y;
			if (yFlip) {
				ys = (sprite.SIZE - 1) - y;
			}
			for (int x = 0; x < sprite.SIZE; x++) {
				int xa = x + xp;
				int xs = x;
				if (xFlip) {
					xs = (sprite.SIZE - 1) - x;
				}
				if (xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int col = sprite.pixels[xs + ys * sprite.SIZE];
				if (col != 0xffff00ff) pixels[xa + ya * width] = col;
			}
		}
	}
	
	public void fillRect(int x, int y, int w, int h, int color){
		for(int y1 = y; y1 < h; y1++){
			for(int x1 = x; x1 < w; x1++){
				pixels[x1 + y1 * width] = color;
			}
		}
	}
	
	public void drawLine(int xp1, int yp1, int xp2, int yp2, int color){
		double angle = Math.atan2((double)(yp2 - yp1), (double)(xp2 - xp1));
		for (int x = xp1; x < xp2; x++) {
			int y = yp1 + (int) (Math.cos(angle) * x);
			pixels[x + y * width] = color;
		}
	}

	public void drawEntity(int xp, int yp, Sprite sprite) {
		xp -= xOffset;
		yp -= yOffset;

		for (int y = 0; y < sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int col = sprite.pixels[x + y * sprite.SIZE];
				if (col != 0xffff00ff) pixels[xa + ya * width] = col;
			}
		}
	}

	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

}