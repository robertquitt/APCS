package source;
/**
 * A type of item which can be equiped by Player
 * It cannot stack
 * @author Robert Q
 */
public abstract class ItemEquipable extends Items {
	public EquipSlot slot; 
	public ItemEquipable(String name,EquipSlot slot) {
		super(name,1,1);
		this.slot = slot;
	}
	
	public abstract int getDefense();
	public abstract int getAttack();
	
	public static class Helm extends ItemEquipable
	{
		public Helm (String name)
			super(name, EquipSlot.HEAD);
	}
	
	
	public static class oneHandWeapon extends ItemEquipable{public oneHandWeapon(){super("One-handed Weapon",EquipSlot.PRIMARY);}}
	
}
