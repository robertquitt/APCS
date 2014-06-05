package source;

public class Monster extends Character{
	int xp;
	int cr;
	int attack;
	int damage;
	static final int BASE_XP = 500;
	Inventory stuff;
	boolean detectChar;
	public Monster(String name, int newAttack, int newDamage, int newAc, int newHp, double newXp, int newCr) {
		myName = name;
		xp= (int)( BASE_XP*newXp);
		cr=newCr;
		ac=newAc;
		hp=newHp;
		attack=newAttack;
		damage=newDamage;
	}
	
	public Monster (Monster monster)
	{
		this(monster.myName,monster.attack, monster.damage, monster.ac, monster.hp, monster.xp, monster.cr);
	}
	
	public void move(){
		Location mLoc = getMove();
		for (int tries=0;tries<5;tries++){
			if (dungeon.getFeature(mLoc) instanceof Wall || dungeon.getFeature(mLoc) instanceof Door){
				mLoc = getMove();
			}
			else if(mLoc.equals(dungeon.getPlayer().getLocation())); {
				attack(dungeon.getPlayer());
			} 
			else {
				moveTo(mLoc);
			}
		}
	}
	
	public Location getMove() {
		if (detectChar==true){
			return loc.getAdjacentLocation(loc.getDirectionToward(dungeon.getPlayer().getLocation()));
		}
		else {
			return loc.getAdjacentLocation((int) (Math.random()*8)*45);
		}
	}
	
	public int getCR(){
		return cr;
	}
	
	public boolean attack(Character foe) {
	if (attack>=foe.getAc()){
		foe.setHp(foe.getHp()-(int)(Math.random()*damage));
		GUI.print("The "+ myName +" hits");
		if (foe.getHp()<0){
			//terminate game
		}
		return true;
	}
	else
		GUI.print("The "+ myName +" misses");
		return false;
	}
	
	@Override
	public String getName() {
		return myName;
	}
}
