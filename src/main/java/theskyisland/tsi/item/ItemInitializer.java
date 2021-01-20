package theskyisland.tsi.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import theskyisland.tsi.util.Reference;


@Mod.EventBusSubscriber(modid = Reference.MODID)
public final class ItemInitializer extends Item
{
    public static Item synthetic_diamond_ingot;
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
}


