package guiDemos;

public class Character {
	protected String myName;
	protected char ID = '@';
	protected int maxHp;
	protected int hp;
	protected Location loc;
	protected Inventory bag;
	protected int ac;
	
	public String getMyName() {
		return myName;
	}
	
	public Inventory getMyInv() {
		return bag;
	}
	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMaxHp(){
		return maxHp;
	}
	
	public void setMaxHp(int max){
		this.maxHp=max;
	}
	public int getAc() {
		return ac;
	}

	public void setAc(int ac) {
		this.ac = ac;
	}
}
