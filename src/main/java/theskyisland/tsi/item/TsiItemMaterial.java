package theskyisland.tsi.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TsiItemMaterial extends Item
{
    public static enum ToolEdgeMaterial
    {
        SYN_DIA(10, -1, 5, 10, 100);
        private final int harvestLevel;
        /** The number of uses this material allows. (wood = 59, stone = 131, iron = 250, diamond = 1561, gold = 32) */
        private final int maxUses;
        /** The strength of this tool material against blocks which it is effective against. */
        private final float efficiency;
        /** Damage versus entities. */
        private final float attackDamage;
        /** Defines the natural enchantability factor of the material. */
        private final int enchantability;
        //Added by forge for custom Tool materials.
        private ItemStack repairMaterial = ItemStack.EMPTY;
        private ToolEdgeMaterial(int harvestLevel, int maxUses, float efficiency, float damageVsEntity, int enchantability)
        {
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = damageVsEntity;
            this.enchantability = enchantability;
        }
    }
}
