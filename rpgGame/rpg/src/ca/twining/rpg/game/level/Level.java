package ca.twining.rpg.game.level;

import java.util.ArrayList;

import ca.twining.rpg.game.Screen;
import ca.twining.rpg.game.entity.Entity;
import ca.twining.rpg.game.level.tile.Tile;

public abstract class Level {
	
	public int width;
	public int height;
	
	public ArrayList<Entity> entities;
	
	public int[] tiles;
	
	public Level(int width, int height){
		this.width = width;
		this.height = height;
		
		tiles = new int[width * height];
		generateLevel();
	}
	
	public Level(String path){
		loadLevel(path);
		generateLevel();
	}

	protected void loadLevel(String path) {
	}

	protected void generateLevel() {
	}
	
	public void update(){
	}
	
	@SuppressWarnings("unused")
	private void time(){
		//day night cycle
	}
	
	public void spawnEntity(Entity entity){
		entities.add(entity);
	}
	
	public void removeEntity(Entity entity){
		entities.remove(entity);
	}
	
	public Tile getTile(int x, int y){
		if(x < 0 || y < 0 || x >= width || y >= width) return Tile.voidTile;
		if(tiles[x + y * width] == 0) return Tile.grassTile;
		if(tiles[x + y * width] == 1) return Tile.rockTile;
		if(tiles[x + y * width] == 2) return Tile.longGrassTile;
		if(tiles[x + y * width] == 3) return Tile.dirtTile;
		if(tiles[x + y * width] == 4) return Tile.sandTile;
		if(tiles[x + y * width] == 5) return Tile.lavaTile;
		if(tiles[x + y * width] == 6) return Tile.redBrickWallTile;
		if(tiles[x + y * width] == 7) return Tile.blackBrickWallTile;
		else return Tile.voidTile;
	}
	
	public void draw(int xScroll, int yScroll, Screen screen){	
		screen.setOffset(xScroll, yScroll);
		
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4; 
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;
		
		for(int y = y0; y < y1; y++){
			for(int x = x0; x < x1; x++){
				if((x + y * width) < tiles.length && (x + y * width) >= 0){
					getTile(x, y).draw(x, y, screen);
				}else{
					continue;
				}
			}
		}
	}

}
