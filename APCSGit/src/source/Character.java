package source;



public abstract class Character implements Named{
	protected Dungeon dungeon;
	protected String myName;
	protected char ID = '@';
	protected int maxHp;
	protected int hp;
	protected Location loc;
	protected Inventory bag;
	protected int ac;
	
	public void putSelfInDungeon(Dungeon gr, Location loc)
    {
        if (dungeon != null)
            throw new IllegalStateException(
                    "This actor is already contained in a grid.");

        gr.setCharacter(this, loc);
        dungeon = gr;
        this.loc = loc;
    }
	public void moveTo(Location newLocation)
    {
        if (dungeon == null)
            throw new IllegalStateException("This character is not in a dungeon.");
        if (dungeon.getCharacter(loc) != this)
            throw new IllegalStateException(
                    "The dungeon contains a different character at location "
                            + loc + ".");
        if (!dungeon.isValid(newLocation))
            throw new IllegalArgumentException("Location " + newLocation
                    + " is not valid.");

        if (newLocation.equals(loc))
            return;
        dungeon.setCharacter(null,loc);
        loc = newLocation;
        dungeon.setCharacter(this, loc);
    }
	
	
	//Setters and Getters
	public char getDisplayChar() {
		return ID;
	}
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
		this.maxHp = max;
	}
	public int getAc() {
		return ac;
	}

	public void setAc(int ac) {
		this.ac = ac;
	}
	
}
