package ca.twining.rpg.game.entity.mob;

import java.awt.Rectangle;

import ca.twining.rpg.game.Game;
import ca.twining.rpg.game.Screen;
import ca.twining.rpg.game.entity.Entity;
import ca.twining.rpg.game.entity.EntityId;
import ca.twining.rpg.game.entity.item.Item;
import ca.twining.rpg.game.entity.item.Weapon;
import ca.twining.rpg.game.graphics.Sprite;
import ca.twining.rpg.game.input.Keyboard;
import ca.twining.rpg.game.input.Mouse;
import ca.twining.rpg.game.level.Level;
import ca.twining.rpg.game.level.tile.Tile;

public class Player extends Mob{
	
	private Keyboard input;
	private Sprite sprite;
	private int animation = 0;
	
	public int health = 16;
	public int armourRating = 8;
	public int regenSpeed = 4;
	
	int speed = 1;
	
	public boolean isDead = false;
	public boolean takingDamage = false;
	
	private int maxHealth = 16;
	private int maxArmourRating = 8;
	
	public int inventorySize = 6 * 3;
	public int pocketSize = 3 * 3;
	
	public Item[] pocket;
	public Item[] inventory;
	
	public Weapon equipedWeapon;
	
	private int width;
	private int height;
	
	public Player(Keyboard input){
		this.input = input;
		this.sprite = Sprite.player_forward_standing;
		this.width = sprite.SIZE;
		this.height = sprite.SIZE;
		pocket = new Item[pocketSize];
		inventory = new Item[inventorySize];
	}
	
	public Player(int x, int y, Keyboard input){
		this.x = x;
		this.y = y;
		this.input = input;
		this.sprite = Sprite.player_forward_standing;
		this.width = sprite.SIZE;
		this.height = sprite.SIZE;
		pocket = new Item[pocketSize];
		inventory = new Item[inventorySize];
	}
	
	long lastTime = System.currentTimeMillis();
	public void update(){
		int xa = 0, ya = 0;
		
		if(animation < 1000) animation++;
		else animation = 0;
		if(input.up) ya-=speed;
		if(input.down) ya+=speed;
		if(input.left) xa-=speed;
		if(input.right) xa+=speed;
		
		//shooting
		if(Mouse.getButton() == 1){
			double angle = Math.atan2((double)Mouse.getY() - ((y - Screen.yOffset) + 8) * Game.SCALE, (double)Math.abs(Mouse.getX()) - ((x - Screen.xOffset) + 8) * Game.SCALE);
			//shoot(x, y, angle);
		}
		//////////////////
		
		if(input.shift)speed = 2;
		else speed = 1;
		
		if(xa != 0 || ya != 0){
			move(xa, ya);
			walking = true;
		}else{
			walking = false;
		}
		
		for(int c = 0; c < 4; c++){
			int xt = ((x) + c % 2 * 8 + 4) / 16;
			int yt = ((y) + c / 2 * 16 + 1) / 16;
			if(level.getTile(xt, yt) == Tile.lavaTile) onCollisionTile(5);
		}
		
		if(this.health <= 0){
			isDead = true;
			this.health = 0;
		}
		if(this.health > maxHealth) this.health = maxHealth;
		if(armourRating > maxArmourRating) armourRating = maxArmourRating;
		
		if(!isDead){
			long now = System.currentTimeMillis();
			if((now - lastTime) >= (regenSpeed * 1000)){
				if(this.health < 8 && this.health > 0){
					this.health += 1;
					lastTime = now;
				}else{
					lastTime = now;
				}
			}
		}
	}

	public Rectangle collisionBounds(){
		return new Rectangle(x, y, width, height);
	}
	
	public void onCollisionEntity(Entity entity, Level level){
		if(entity.getId() == EntityId.Pirate){
			level.removeEntity(entity);
			this.health -= 1;
		}
	}
	
	long lastTime_lava = System.currentTimeMillis();
	public void onCollisionTile(int tile){
		long now = System.currentTimeMillis();
		//LAVA
		if(tile == 5){
			if((now - lastTime_lava) > 300){
				if(!isDead){
					this.health -= 1;
					takingDamage();
				}
				lastTime_lava = now;
			}
		}
	}
	
	//long lastTime_damage = System.currentTimeMillis();
	public void takingDamage(){
		takingDamage = true;
	}
	
	public void draw(Screen screen){	
		//player drawing
		boolean flip = false;
		if(direction == 0){
			sprite = Sprite.player_back_standing;
			if(walking){
				if(animation % 20 > 10){
					sprite = Sprite.player_back_walking1;
				}else{
					sprite = Sprite.player_back_walking2;
				}
			}
		}
		if(direction == 1){
			sprite = Sprite.player_side_standing;
			if(walking){
				if(animation % 20 > 10){
					sprite = Sprite.player_side_walking1;
				}else{
					sprite = Sprite.player_side_walking2;
				}
			}
		}
		if(direction == 2) {
			sprite = Sprite.player_forward_standing;
			if(walking){
				if(animation % 20 > 10){
					sprite = Sprite.player_forward_walking1;
				}else{
					sprite = Sprite.player_forward_walking2;
				}
			}
		}
		if(direction == 3){
			flip = true;
			sprite = Sprite.player_side_standing;
			if(walking){
				if(animation % 20 > 10){
					sprite = Sprite.player_side_walking1;
				}else{
					sprite = Sprite.player_side_walking2;
				}
			}
		}
		
		screen.drawPlayer(x, y, sprite, flip, false);
	}

}
