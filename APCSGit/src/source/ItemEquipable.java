package source;
/*
 * A type of item which can be equiped by Player
 * It cannot stack
 * @author Robert Q
 */


public class ItemEquipable extends Items {
	public EquipSlot slot; 
	public ItemEquipable(String name,EquipSlot slot) {
		super(name,1,1);
		this.slot = slot;
	}

	public EquipSlot getType()
	{
		return slot;
	}
	
	public int getAttack(){
		return 0;
	}
	public int getDefense() {
		return 0;
	}
	
	public static class Helm extends ItemEquipable
	{
		private int specDef;
		public Helm (String name, int def)
		{
			super(name, EquipSlot.HEAD);
			specDef=def;
		}
			
		public int getDefense()
		{
			return specDef;
		}
		public int getAttack()
		{
			return -1;
		}
		
	}
	Helm clothhelm = new Helm("cloth",3);
	
	public static class Armor extends ItemEquipable
	{
		private int specDef;
		public Armor (String name, int def)
		{
			super(name, EquipSlot.CHEST);
			specDef=def;
		}
			
		public int getDefense()
		{
			return specDef;
		}
		public int getAttack()
		{
			return -1;
		}
	}
	
	public static class Leggings extends ItemEquipable
	{
		private int specDef;
		public Leggings (String name, int def)
		{
			super(name, EquipSlot.LEGS);
			specDef=def;
		}
			
		public int getDefense()
		{
			return specDef;
		}
		public int getAttack()
		{
			return -1;
		}
	}
	public static class oneHandWeapon extends ItemEquipable
	{
		private int specAtt;
		public oneHandWeapon (String name, int att)
		{
			super(name, EquipSlot.PRIMARY);
			specAtt=att;
		}
			
		public int getDefense()
		{
			return -1;
		}
		public int getAttack()
		{
			return specAtt;
		}
	}
	
	public static class twoHandWeapon extends ItemEquipable 
	{
		private int specAtt;
		public twoHandWeapon (String name, int att)
		{
			super(name, EquipSlot.PRIMARY);
			specAtt=att;
		}
			
		public int getDefense()
		{
			return 0;
		}
		public int getAttack()
		{
			return specAtt;
		}
	}
	public static class shield extends ItemEquipable
	{
		private int specDef;
		public shield (String name, int def)
		{
			super(name, EquipSlot.SECONDARY);
			specDef=def;
		}
			
		public int getDefense()
		{
			return specDef;
		}
		public int getAttack()
		{
			return -1;
		}
	}
	
	
	

}
