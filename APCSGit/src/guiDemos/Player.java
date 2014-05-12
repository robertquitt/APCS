package guiDemos;

public class Player extends Character{
	int myClass;
	int str;
	int dex;
	int con;
	int intel;
	int wis;
	int cha;
	int level;
	int xp;
	int turns;
	
	Player(String name, int cChoice){
		myName = name;
		myClass = cChoice;
		bag = new Inventory();
		
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

	public void setXp(int xp) {
		this.xp = xp;
	}
	
	public String toString(){
		return (myName + " the level " + level + " " + myClass + " /n" + "HP AC STR DEX CON INT WIS CHA TURNS /n" + hp + " "+ ac + " "+ str + " "+ dex + " "+ con + " "+ intel + " "+ wis + " "+ cha + " "+ turns);
				
	}
	
	public void move() {
		
	}
	
	public void drop(int selection) {
		bag.remove(selection);
	}
}
