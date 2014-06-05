package source;

public class MonsterData {
	/**
	 * slime is basic grunt type monster	
	 */
	static Monster slime = new Monster ("Slime",2,1,10,6,1.0,1), 
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
	barbarian = new Monster ("Barbarian",2,9,14,55,5.0,3);
	
	
	

}
