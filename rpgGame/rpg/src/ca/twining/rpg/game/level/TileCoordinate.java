package ca.twining.rpg.game.level;

public class TileCoordinate {

	private int x, y;
	private final int TILE_SIZE = 16;
	
	public TileCoordinate(int x, int y){
		this.x = x * TILE_SIZE;
		this.y = y * TILE_SIZE;
	}
	
	public int [] xy(){
		int[] r = new int [2];
		r[0] = x;
		r[1] = y;
		return r;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
}
