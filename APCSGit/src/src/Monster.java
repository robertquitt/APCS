package src;

public class Monster extends Character{
	int xp;
	int cr;
	Inventory stuff;
	boolean detectChar;
	
	public void attack(){
		
	}
	public void move(){
		
	}
	
	public int getMove() {
		if (detectChar==true){
			return 0;
		}
		else {
			return (int) (Math.random()*8);
		}
	}
}
