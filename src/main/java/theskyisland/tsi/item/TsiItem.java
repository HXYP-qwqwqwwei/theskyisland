package theskyisland.tsi.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;
import theskyisland.tsi.util.Reference;


@Mod.EventBusSubscriber(modid = Reference.MODID)
public class TsiItem extends Item
{
    public static Item synthetic_diamond_ingot;
    public static Item antiskid_bar;
    public static Item osmium_ingot;
    public static Item quartz_crystal;
    public static Item monocrystalline_silicon;
    public static Item small_silicon_crystal;
    public static Item nickel_ingot;
    public static Item artificial_ruby;
    public static TsiItemPickaxe tsipickaxe;
    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event)
    {
        /* registry common items */
        event.getRegistry().register(synthetic_diamond_ingot = registryItem(new Item(), CreativeTabs.MATERIALS, "synthetic_diamond_ingot"));
        event.getRegistry().register(antiskid_bar = registryItem(new Item(), CreativeTabs.MATERIALS, "antiskid_bar"));
        event.getRegistry().register(osmium_ingot = registryItem(new Item(), CreativeTabs.MATERIALS, "osmium_ingot"));
        /*
        event.getRegistry().register(quartz_crystal = registryItem(new Item(), CreativeTabs.MATERIALS, "quartz_crystal"));
        event.getRegistry().register(monocrystalline_silicon = registryItem(new Item(), CreativeTabs.MATERIALS, "monocrystalline_silicon"));
        event.getRegistry().register(small_silicon_crystal = registryItem(new Item(), CreativeTabs.MATERIALS, "small_silicon_crystal"));
        event.getRegistry().register(nickel_ingot = registryItem(new Item(), CreativeTabs.MATERIALS, "nickel_ingot"));
        event.getRegistry().register(artificial_ruby = registryItem(new Item(), CreativeTabs.MATERIALS, "artificial_ruby"));
        */
        /* registry tools */
        event.getRegistry().register(tsipickaxe = registryItem(new TsiItemPickaxe(TsiItemTool.ToolCoreMaterial.IRIDIUM, TsiItemTool.ToolEdgeMaterial.SYN_DIA), CreativeTabs.TOOLS, "tsipickaxe"));
    }
    private static <T extends Item> T registryItem(T item, CreativeTabs tab, String name)
    {
        item.setCreativeTab(tab);
        item.setRegistryName("theskyisland:" + name);
        item.setTranslationKey(name);
        return item;
    }

    protected static enum ToolEdgeMaterial
    {
        SYN_DIA(10, 100, 10),
        WOOD(0, 59, 0.0F),
        STONE(1, 131, 1.0F),
        IRON(2, 250, 2.0F),
        DIAMOND(3, 1561, 3.0F),
        GOLD(0, 32,0.0F);
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

        @Deprecated // Use getRepairItemStack below
        public Item getRepairItem()
        {
            if (this == WOOD)
            {
                return Item.getItemFromBlock(Blocks.PLANKS);
            }
            else if (this == STONE)
            {
                return Item.getItemFromBlock(Blocks.COBBLESTONE);
            }
            else if (this == GOLD)
            {
                return Items.GOLD_INGOT;
            }
            else if (this == IRON)
            {
                return Items.IRON_INGOT;
            }
            else if (this == SYN_DIA)
            {
                return TsiItem.synthetic_diamond_ingot;
            }
            else
            {
                return this == DIAMOND ? Items.DIAMOND : null;
            }
        }

        public ToolEdgeMaterial setRepairItem(ItemStack stack)
        {
            if (!this.repairMaterial.isEmpty()) throw new RuntimeException("Repair material has already been set");
            if (this == SYN_DIA || this == WOOD || this == STONE || this == GOLD || this == IRON || this == DIAMOND) throw new RuntimeException("Can not change vanilla tool repair materials");
            this.repairMaterial = stack;
            return this;
        }

        public ItemStack getRepairItemStack()
        {
            if (!repairMaterial.isEmpty()) return repairMaterial;
            Item ret = this.getRepairItem();
            if (ret != null) repairMaterial = new ItemStack(ret, 1, net.minecraftforge.oredict.OreDictionary.WILDCARD_VALUE);
            return repairMaterial;
        }
    }
    protected static enum ToolCoreMaterial
    {
        IRIDIUM(22.56F, 10),
        Nickel(8.902F, 10);
        /** The strength of this tool material against blocks which it is effective against. */
        private final float efficiency;
        /** Damage versus entities. */
        private final float attackDamagePower;
        /** Defines the natural enchantability factor of the material. */
        private final int enchantability;

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
}


