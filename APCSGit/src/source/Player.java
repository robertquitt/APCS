package source;

public class Player extends Character{
	private int myClass;
	private int str;
	private int dex;
	private int con;
	private int intel;
	private int wis;
	private int cha;
	private int level;
	private int xp;
	private int turns;

	Player(String name, int cChoice){
		myName = name;
		myClass = cChoice;
		bag = new Inventory();
		turns = 0;
		xp = 0;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}

	public int getMyClass() {
		return myClass;
	}


	public void setMyClass(int myClass) {
		this.myClass = myClass;
	}

	public int getStr() {
		return str;
	}

	public void setStr(int str) {
		this.str = str;
	}

	public int getDex() {
		return dex;
	}

	public void setDex(int dex) {
		this.dex = dex;
	}

	public int getCon() {
		return con;
	}

	public void setCon(int con) {
		this.con = con;
	}

	public int getIntel() {
		return intel;
	}

	public void setIntel(int intel) {
		this.intel = intel;
	}

	public int getWis() {
		return wis;
	}

	public void setWis(int wis) {
		this.wis = wis;
	}

	public int getCha() {
		return cha;
	}

	public void setCha(int cha) {
		this.cha = cha;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getXp() {
		return xp;
	}

	public void addXp(int xp) {
		this.xp += xp;
		if (xp>=(level)*1000){
			level++;
			xp=0;
		}
	}

	public String toString(){
		return (myName + " the level " + level + " " + myClass + " /n" + "HP AC STR DEX CON INT WIS CHA TURNS /n" + hp + " "+ ac + " "+ str + " "+ dex + " "+ con + " "+ intel + " "+ wis + " "+ cha + " "+ turns);
	}

	public Dungeon getGrid(){
		return dungeon;
	}
	public void move(int dir) {
		Location toLoc = loc.getAdjacentLocation(dir);
		if (dungeon.isValid(toLoc)){
			if (dungeon.getCharacter(toLoc) instanceof Monster){
				attack(dungeon.getCharacter(toLoc));
			} else if (dungeon.getFeature(toLoc)==null||dungeon.getFeature(toLoc).isTraversable()){
				moveTo(toLoc);
				if (!dungeon.getSquare(toLoc).getInv().isEmpty()) {
					for (Items i:dungeon.getSquare(toLoc).getInv()) {
						bag.add(i);
					}
				}
			}
		}
	}
	
	public boolean attack(Monster foe) {
		int attack = (dex-10)/2 + (int) Math.random()*20;
		if (attack-ac>=0) {
			foe.setHp(foe.getHp()-(int)(Math.random()*( bag.getPrimary()).getAttack())+(str-10)/2);
			GUI.print("Your " + bag.getPrimary().getName() + "strikes the " + foe.getName());
			if (foe.getHp()<1){
				GUI.print("The " + foe.getName() + " is killed");
				addXP(foe.getCR()*2-level);
			}
			return true;
		}
		else 
			GUI.print("Your " + bag.getPrimary().getName() + "misses");
			return false;
	}

	public void drop(int selection) {
		bag.remove(selection);
	}
	
	@Override
	public String getName() {
		return "player";
	}
	
	public int getAc() {
		return bag.getArmor().getDefense()+bag.getSecondary().getDefense() + (dex-10)/2;
	}
}
