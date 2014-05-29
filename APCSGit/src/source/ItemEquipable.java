/*
 * A type of item which can be equiped by Player
 * It cannot stack
 * @author Robert Q
 */
package source;

public abstract class ItemEquipable extends Items {
	public EquipSlot slot; 
	public ItemEquipable(String name,EquipSlot slot) {
		super(name,1,1);
		this.slot = slot;
	}

	
	public abstract int getDefense();
	public abstract int getAttack();
	public EquipSlot getType()
	{
		return slot;
	}

	
	public class Helm extends ItemEquipable
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
	
	public class Armor extends ItemEquipable
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
	
	public class Leggings extends ItemEquipable
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
	public class oneHandWeapon extends ItemEquipable
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
	
	public class twoHandWeapon extends ItemEquipable
	{
		private int specAtt;
		public twoHandWeapon (String name, int att)
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
	public class shield extends ItemEquipable
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
