package ca.twining.rpg.game.level;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import ca.twining.rpg.game.entity.Entity;
import ca.twining.rpg.game.entity.mob.PirateEnemy;

public class SpawnLevel extends Level {
	
	private int[] levelPixels;
	
	public SpawnLevel(String path){
		super(path);
		entities = new ArrayList<Entity>();
		
		for(int i = 1; i <= 10; i++){
			Entity tempEntity = new PirateEnemy(i * 30, i * 30);
			tempEntity.level = this;
			
			spawnEntity(tempEntity);
		}
	}
	
	public void update(){
		for(int i = 0; i < entities.size(); i++){
			entities.get(i).update();
		}
	}
	
	// grass = 0x007F0E
	// sand = 0xFFEFA3
	// rock = 0x4C4C4C
	// dirt = 0x695200
	// longgrass = 0x8CFF99
	// lava = 0xFF8426
	protected void generateLevel(){
		
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				if(levelPixels[x + y * width] == 0xff007F0E){
					tiles[x + y * width] = 0;//grass
				}
				else if(levelPixels[x + y * width] == 0xff4C4C4C){ 
					tiles[x + y * width] = 1;//rock
				}
				else if(levelPixels[x + y * width] == 0xff8CFF99){ 
					tiles[x + y * width] = 2;//longgrass
				}
				else if(levelPixels[x + y * width] == 0xff695200){
					tiles[x + y * width] = 3;//dirt
				}
				else if(levelPixels[x + y * width] == 0xffFFEFA3){
					tiles[x + y * width] = 4;//sand
				}
				else if(levelPixels[x + y * width] == 0xffFF8426){
					tiles[x + y * width] = 5;//lava
				}
				else if(levelPixels[x + y * width] == 0xffFF2014){
					tiles[x + y * width] = 6;//redbrickwall
				}
				else if(levelPixels[x + y * width] == 0xff111111){
					tiles[x + y * width] = 7;//blackbrickwall
				}
			}
		}
	}
	
	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			width = image.getWidth();
			height = image.getHeight();
			tiles = new int[width * height];
			levelPixels = new int[width * height];
			image.getRGB(0, 0, width, height, levelPixels, 0, width);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
