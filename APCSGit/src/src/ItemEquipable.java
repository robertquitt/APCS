package src;
/**
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
	public static class Helm extends ItemEquipable{public Helm(){super("Helmet",EquipSlot.HEAD);}}
}
