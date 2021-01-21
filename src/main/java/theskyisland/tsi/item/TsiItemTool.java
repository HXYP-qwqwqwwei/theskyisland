package theskyisland.tsi.item;

import com.google.common.collect.Multimap;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Set;

public class TsiItemTool extends TsiItem
{
    private final Set<Block> effectiveBlocks;
    protected float efficiency;
    protected float attackDamage;
    protected float attackSpeed;
    protected ToolEdgeMaterial edgeMaterial;
    protected ToolCoreMaterial coreMaterial;
    protected TsiItemTool(float attackDamageIn, float attackSpeedIn, ToolCoreMaterial coreMaterialIn, ToolEdgeMaterial edgeMaterialIn, Set<Block> effectiveBlocksIn)
    {
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

    protected TsiItemTool(ToolCoreMaterial coreMaterialIn, ToolEdgeMaterial edgeMaterialIn, Set<Block> effectiveBlocksIn)
    {
        this(0.0F, 0.0F, coreMaterialIn, edgeMaterialIn, effectiveBlocksIn);
    }

    public float getDestroySpeed(ItemStack stack, IBlockState state)
    {
        for (String type : getToolClasses(stack))
        {
            if (state.getBlock().isToolEffective(type, state))
                return efficiency;
        }
        return this.effectiveBlocks.contains(state.getBlock()) ? this.efficiency : 1.0F;
    }

    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        stack.damageItem(2, attacker);
        return true;
    }

    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving)
    {
        if (!worldIn.isRemote && (double)state.getBlockHardness(worldIn, pos) != 0.0D)
        {
            stack.damageItem(1, entityLiving);
        }

        return true;
    }

    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }

    public int getItemEnchantability()
    {
        return this.coreMaterial.getEnchantability();
    }

    public String getCoreMaterialName()
    {
        return this.coreMaterial.toString();
    }

    public String getEdgeMaterialName()
    {
        return this.edgeMaterial.toString();
    }

    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        ItemStack mat = this.edgeMaterial.getRepairItemStack();
        if (!mat.isEmpty() && net.minecraftforge.oredict.OreDictionary.itemMatches(mat, repair, false)) return true;
        return super.getIsRepairable(toRepair, repair);
    }

    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
    {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND)
        {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Tool modifier", (double)this.attackDamage, 0));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Tool modifier", (double)this.attackSpeed, 0));
        }

        return multimap;
    }

    /*===================================== FORGE START =================================*/
    @javax.annotation.Nullable
    private String toolClass;
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

    @Override
    public Set<String> getToolClasses(ItemStack stack)
    {
        return toolClass != null ? com.google.common.collect.ImmutableSet.of(toolClass) : super.getToolClasses(stack);
    }
    /*===================================== FORGE END =================================*/
/*
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
    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        ItemStack mat = this.toolMaterial.getRepairItemStack();
        if (!mat.isEmpty() && net.minecraftforge.oredict.OreDictionary.itemMatches(mat, repair, false)) return true;
        return super.getIsRepairable(toRepair, repair);
    }
 */
}
