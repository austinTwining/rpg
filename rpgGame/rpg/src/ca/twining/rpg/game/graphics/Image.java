package ca.twining.rpg.game.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image {
	
	private String path;
	public final int WIDTH;
	public final int HEIGHT;
	
	public int[] pixels;
	
	public static Image HUD = new Image("/textures/HUD.png", 320, 234);

	public Image(String path, int width, int height){
		this.path = path;
		this.WIDTH = width;
		this.HEIGHT = height;
		
		pixels = new int[WIDTH * HEIGHT];
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
