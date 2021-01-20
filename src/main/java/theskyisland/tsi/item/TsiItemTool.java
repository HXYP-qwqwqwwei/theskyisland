package theskyisland.tsi.item;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;

import javax.annotation.Nullable;
import java.util.Set;

public class TsiItemTool extends ItemTool
{
    public static enum ToolEdgeMaterial
    {
        SYN_DIA(3, 10, 10);
        /** The level of material this tool can harvest */
        private final int harvestLevel;
        /** The number of uses this material allows. */
        private final int maxUses;
        /** Damage versus entities. */
        private final float attackDamage;
        //Added by forge for custom Tool materials.
        private ItemStack repairMaterial = ItemStack.EMPTY;
        private ToolEdgeMaterial(int harvestLevel, int maxUses, float damageVsEntity)
        {
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.attackDamage = damageVsEntity;
        }

        public float getAttackDamage() { return attackDamage; }
        public int getHarvestLevel()
        {
            return harvestLevel;
        }
        public int getMaxUses() { return maxUses; }
    }
    public static enum ToolCoreMaterial
    {
        IRIDIUM(22.56F, 10),
        Nickel(8.902F, 10);
        /** The strength of this tool material against blocks which it is effective against. */
        private final float efficiency;
        /** Damage versus entities. */
        private final float attackDamagePower;
        /** Defines the natural enchantability factor of the material. */
        private final int enchantability;
        //Added by forge for custom Tool materials.
        private ItemStack repairMaterial = ItemStack.EMPTY;

        private ToolCoreMaterial(float weight, int enchantability)
        {
            this.efficiency = weight;
            this.attackDamagePower = weight;
            this.enchantability = enchantability;
        }

        public float getEfficiency() { return this.efficiency; }
        public float getAttackDamagePower() { return this.attackDamagePower; }
        public int getEnchantability() { return this.enchantability; }
    }

    private final Set<Block> effectiveBlocks;
    protected ToolEdgeMaterial edgeMaterial;
    protected ToolCoreMaterial coreMaterial;
    protected String toolClass;
    protected TsiItemTool(ToolCoreMaterial coreMaterialIn, ToolEdgeMaterial edgeMaterialIn, float attackDamageIn, float attackSpeedIn, Set<Block> effectiveBlocksIn)
    {
        super(0.0F, 0.0F, ToolMaterial.WOOD, effectiveBlocksIn);
        this.coreMaterial = coreMaterialIn;
        this.edgeMaterial = edgeMaterialIn;
        this.efficiency = 4.0F;
        this.effectiveBlocks = effectiveBlocksIn;
        this.maxStackSize = 1;
        this.setMaxDamage(edgeMaterialIn.getMaxUses());
        this.efficiency = coreMaterialIn.getEfficiency();
        this.attackDamage = attackDamageIn + edgeMaterialIn.getAttackDamage() * coreMaterialIn.getAttackDamagePower();
        this.attackSpeed = attackSpeedIn;
        this.setCreativeTab(CreativeTabs.TOOLS);
        if (this instanceof TsiItemPickaxe)
        {
            toolClass = "pickaxe";
        }
    }
    public int getItemEnchantability()
    {
        return this.coreMaterial.getEnchantability();
    }

    @Override
    public String getToolMaterialName() {
        return edgeMaterial.toString();
    }

    @Override
    public int getHarvestLevel(ItemStack stack, String toolClass, @javax.annotation.Nullable net.minecraft.entity.player.EntityPlayer player, @javax.annotation.Nullable IBlockState blockState)
    {
        int level = super.getHarvestLevel(stack, toolClass,  player, blockState);
        if (level == -1 && toolClass.equals(this.toolClass))
        {
            return this.edgeMaterial.getHarvestLevel();
        }
        else
        {
            return level;
        }
    }
}
