package ca.twining.rpg.game.entity.projectile;

import ca.twining.rpg.game.Screen;

public class FireProjectile extends Projectile{

	public FireProjectile(int x, int y, double dir) {
		super(x, y, dir);
		range = 300;
		speed = 4;
		damage = 5;
		rateOfFire = 15;
		
		dx = speed * Math.cos(angle);
		dy = speed * Math.sin(angle);
		
	}
	
	public void update(){
		move();
	}
	
	protected void move(){
		x += dx;
		y += dy;
	}
	
	public void draw(Screen screen){
		
	}

}
