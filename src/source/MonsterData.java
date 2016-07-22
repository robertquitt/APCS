package source;

public class MonsterData {
	/**
	 * snake is basic grunt type monster	
	 */
	static Monster snake = new Monster ("Snake",2,1,10,6,1.0,1), 
	/**
	*  wolf is upgraded slime in some ways
	*/	
	wolf = new Monster("Wolf",3,2,11,15,1.6,1),
	/**
	 * wraith has high accuracy but low strength 
	 */
	wraith = new Monster("Wraith",5,2,11,20,1.8,1),
	
	/**
	 * barbarian has high attack but low finesse and accuracy
	*/	
	barbarian = new Monster ("Barbarian",2,9,14,55,5.0,3),
	/**
	 * bandit is hard to hit, fast
	 */
	bandit = new Monster ("Bandit",5,3,14,25,2.0, 2),
	/**
	 * dragon is OP but inaccurate
	 */
	dragon = new Monster ("Dragon",3,20,15,90,7.5,3),
	/**
	 * dwarves are hardhitting but inaccurate
	 */
	dwarf = new Monster("Dwarf",3,5,16,40,3.0,2),
	/**
	 * golems--hard hitting 
	 */
	golem = new Monster("Golem",3,10,18,30,2.0,2),
	/**
	 * brown golems are upgraded golems
	 */
	browngolem = new Monster("Brown Golem",2, 12, 16, 35, 2.5, 2),
	/**
	 * ogres be hardcore damage dealers
	 */
	ogre = new Monster ("Ogre",3, 10, 13, 40, 2.7, 3),
	/**
	 * ogreLords be upgraded ogres
	 */
	ogreLord = new Monster("Ogre Lord",4, 12, 15, 45, 3.0, 3),
	/**
	 * gryphons are highly accurate and damage dealing
	 */
	gryphon = new Monster("Gryphon",5,14, 17, 50, 3.0, 3),
	/**
	 * fighters are well-rounded enemies
	 */
	fighter = new Monster ("Fighter",3,13,13, 25, 2.2, 2),
	/**
	 * black fighter is upgraded fighter
	 */
	blackFighter = new Monster("Black Fighter",4,14,14,30,2.5,2),
	/**
	 * mage physically frail 
	 */
	mage = new Monster("Mage",2,11,10,20,1.3,1),
	/**
	 * elf--frail, but accurate
	 */
	elf = new Monster("Elf",5,10,10,25, 1.5,1);
	
	
	

}
