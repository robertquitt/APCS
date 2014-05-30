package source;

public class Monster extends Character{
	int xp;
	int cr;
	int attack;
	int damage;
	Inventory stuff;
	boolean detectChar;
	

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
	
	public boolean attack(Character foe) {
	if (attack>=foe.getAc()){
		foe.setHp(foe.getHp()-(int)(Math.random()*damage));
		return true;
	}
	else
		return false;
}
}
