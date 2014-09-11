package ca.twining.rpg.game.level;

import java.util.ArrayList;
import java.util.Random;

import ca.twining.rpg.game.entity.Entity;

public class RandomLevel extends Level{
	
	private static final Random random = new Random();
	
	public RandomLevel(int width, int height) {
		super(width, height);
		tiles = new int[width * height];
		entities = new ArrayList<Entity>();
	}
	
	public void createLevel(){
		
	}
	
	protected void generateLevel(){
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				tiles[x + y * width] = random.nextInt(8);
			}
		}
	}

}
