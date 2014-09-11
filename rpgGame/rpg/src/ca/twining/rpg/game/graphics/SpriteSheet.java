package ca.twining.rpg.game.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	
	private String path;
	public final int SIZE;
	
	public int[] pixels;
	
	public static SpriteSheet tiles = new SpriteSheet("/textures/SpriteSheet_tiles.png", 256);
    public static SpriteSheet entities = new SpriteSheet("/textures/SpriteSheet_entities.png", 256);
    public static SpriteSheet HUD = new SpriteSheet("/textures/SpriteSheet_HUD.png", 256);
    public static SpriteSheet items = new SpriteSheet("/textures/SpriteSheet_items.png", 256);
	
	public SpriteSheet(String path, int size){
		this.path = path;
		this.SIZE = size;
		
		pixels = new int[SIZE * SIZE];
		load();
	}
	
	private void load(){
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResourceAsStream(path));
			int w = image.getWidth();
			int h =  image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
