package ca.twining.rpg.game.graphics;

public class Sprite {
	
	public final int SIZE;
	private int x, y;
	
	public int[] pixels;
	private SpriteSheet sheet;
	
	//tiles
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite rock= new Sprite(16, 0, 1, SpriteSheet.tiles);
	public static Sprite longGrass= new Sprite(16, 0, 2, SpriteSheet.tiles);
	public static Sprite sand = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite dirt = new Sprite(16, 1, 1, SpriteSheet.tiles);
	public static Sprite lava = new Sprite(16, 1, 2, SpriteSheet.tiles);
	public static Sprite redBrickWall = new Sprite(16, 0, 3, SpriteSheet.tiles);
	public static Sprite blackBrickWall = new Sprite(16, 1, 3, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 0x15E7EB);
	
	//HUD
	public static Sprite fullHeart = new Sprite(8, 0, 0, SpriteSheet.HUD);
	public static Sprite halfHeart = new Sprite(8, 1, 0, SpriteSheet.HUD);
	public static Sprite fullShield = new Sprite(8, 0, 1, SpriteSheet.HUD);
	public static Sprite halfShield = new Sprite(8, 1, 1, SpriteSheet.HUD);
	
	//player back
	public static Sprite player_back_standing = new Sprite(16, 0, 0, SpriteSheet.entities);
	public static Sprite player_back_walking1 = new Sprite(16, 1, 0, SpriteSheet.entities);
	public static Sprite player_back_walking2 = new Sprite(16, 2, 0, SpriteSheet.entities);
	
	//player front
	public static Sprite player_forward_standing = new Sprite(16, 0, 1, SpriteSheet.entities);
	public static Sprite player_forward_walking1 = new Sprite(16, 1, 1, SpriteSheet.entities);
	public static Sprite player_forward_walking2 = new Sprite(16, 2, 1, SpriteSheet.entities);
	
	//player side
	public static Sprite player_side_standing = new Sprite(16, 0, 2, SpriteSheet.entities);
	public static Sprite player_side_walking1 = new Sprite(16, 1, 2, SpriteSheet.entities);
	public static Sprite player_side_walking2 = new Sprite(16, 2, 2, SpriteSheet.entities);
	
	//pirate enemy
	public static Sprite pirate_enemy_back_standing = new Sprite(16, 3, 0, SpriteSheet.entities);
	public static Sprite pirate_enemy_back_walking1 = new Sprite(16, 4, 0, SpriteSheet.entities);
	public static Sprite pirate_enemy_back_walking2 = new Sprite(16, 5, 0, SpriteSheet.entities);
	
	public static Sprite pirate_enemy_forward_standing = new Sprite(16, 3, 1, SpriteSheet.entities);
	public static Sprite pirate_enemy_forward_walking1 = new Sprite(16, 4, 1, SpriteSheet.entities);
	public static Sprite pirate_enemy_forward_walking2 = new Sprite(16, 5, 1, SpriteSheet.entities);
	
	public static Sprite pirate_enemy_side_standing = new Sprite(16, 3, 2, SpriteSheet.entities);
	public static Sprite pirate_enemy_side_walking1 = new Sprite(16, 4, 2, SpriteSheet.entities);
	public static Sprite pirate_enemy_side_walking2 = new Sprite(16, 5, 2, SpriteSheet.entities);
	
	public Sprite(int size, int x, int y, SpriteSheet sheet){
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}
	
	public Sprite(int size, int color){
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColor(color);
	}
	
	private void setColor(int color) {
		for(int i = 0; i < SIZE * SIZE; i++){
			pixels[i] = color;
		}
	}

	private void load(){
		for(int y = 0; y < SIZE; y++){
			for(int x = 0; x < SIZE; x++){
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}

}
