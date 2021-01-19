package theskyisland.tsi.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
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
    public static TsiItemPickaxe test;
    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register(
                synthetic_diamond_ingot = new Item()
                        .setCreativeTab(CreativeTabs.MATERIALS)
                        .setRegistryName("theskyisland:synthetic_diamond_ingot")
                        .setTranslationKey("synthetic_diamond_ingot"));
        event.getRegistry().register(
                quartz_crystal = new Item()
                        .setCreativeTab(CreativeTabs.MATERIALS)
                        .setRegistryName("theskyisland:quartz_crystal")
                        .setTranslationKey("quartz_crystal"));
        event.getRegistry().register(
                monocrystalline_silicon = new Item()
                        .setCreativeTab(CreativeTabs.MATERIALS)
                        .setRegistryName("theskyisland:monocrystalline_silicon")
                        .setTranslationKey("monocrystalline_silicon"));
        event.getRegistry().register(
                small_silicon_crystal = new Item()
                        .setCreativeTab(CreativeTabs.MATERIALS)
                        .setRegistryName("theskyisland:small_silicon_crystal")
                        .setTranslationKey("small_silicon_crystal"));
        event.getRegistry().register(
                nickel_ingot = new Item()
                        .setCreativeTab(CreativeTabs.MATERIALS)
                        .setRegistryName("theskyisland:nickel_ingot")
                        .setTranslationKey("nickel_ingot"));
        event.getRegistry().register(
                artificial_ruby = new Item()
                        .setCreativeTab(CreativeTabs.MATERIALS)
                        .setRegistryName("theskyisland:artificial_ruby")
                        .setTranslationKey("artificial_ruby"));
        event.getRegistry().register(registryItem(new TsiItemPickaxe(ToolMaterial.DIAMOND), "tsipickaxe"));
    }
    private static <T extends Item> T registryItem(T item, String name)
    {
        item.setCreativeTab(CreativeTabs.TOOLS);
        item.setRegistryName("theskyisland:" + name);
        item.setTranslationKey(name);
        return item;
    }
}


