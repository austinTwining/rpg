package ca.twining.rpg.game.entity.mob;

import ca.twining.rpg.game.Screen;
import ca.twining.rpg.game.entity.EntityId;
import ca.twining.rpg.game.graphics.Sprite;

public class PirateEnemy extends Mob{
	
	private int animation = 0;
	private boolean walking = false;
	
	private boolean isMovingForward = false;
	private boolean isMovingBackward = false;
	private boolean isMovingLeft = false;
	private boolean isMovingRight = false;
	
	public PirateEnemy(int x, int y){
		this.x = x;
		this.y = y;
		this.sprite = Sprite.pirate_enemy_forward_standing;
		this.health = 5;
		this.id = EntityId.Pirate;
	}
	
	public void update(){
		int xa = 0, ya = 0;
		if(animation < 1000) animation++;
		else animation = 0;
		
		//AI code goes here//
		if(isMovingForward){
			ya--;
		}else if(isMovingBackward){
			ya++;
		}else if(isMovingLeft){
			xa--;
		}else if(isMovingRight){
			xa++;
		}
		/////////////////////
		
		if(xa != 0 || ya != 0){
			move(xa, ya);
			walking = true;
		}else{
			walking = false;
		}
	}
	
	public void draw(Screen screen){
		boolean flip = false;
		if(direction == 0){
			sprite = Sprite.pirate_enemy_back_standing;
			if(walking){
				if(animation % 20 > 10){
					//sprite = Sprite.player_back_walking1;
				}else{
					//sprite = Sprite.player_back_walking2;
				}
			}
		}
		if(direction == 1){
			sprite = Sprite.pirate_enemy_side_standing;
			if(walking){
				if(animation % 20 > 10){
					//sprite = Sprite.player_side_walking1;
				}else{
					//sprite = Sprite.player_side_walking2;
				}
			}
		}
		if(direction == 2) {
			sprite = Sprite.pirate_enemy_forward_standing;
			if(walking){
				if(animation % 20 > 10){
					//sprite = Sprite.player_forward_walking1;
				}else{
					//sprite = Sprite.player_forward_walking2;
				}
			}
		}
		if(direction == 3){
			flip = true;
			sprite = Sprite.pirate_enemy_side_standing;
			if(walking){
				if(animation % 20 > 10){
					//sprite = Sprite.player_side_walking1;
				}else{
					//sprite = Sprite.player_side_walking2;
				}
			}
		}
		
		screen.drawEnemy(x, y, sprite, flip, false);
	}

}
