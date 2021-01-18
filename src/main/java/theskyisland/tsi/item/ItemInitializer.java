package theskyisland.tsi.item;

import com.google.common.eventbus.Subscribe;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import theskyisland.tsi.util.Reference;

import java.rmi.registry.Registry;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public final class ItemInitializer
{
    public static Item synthetic_diamond_ingot;
    public static Item quartz_crystal;
    public static Item monocrystalline_silicon;
    public static Item small_silicon_crystal;
    public static Item nickel_ingot;
    public static Item artificial_ruby;
    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(
                synthetic_diamond_ingot = new Item()
                        .setCreativeTab(CreativeTabs.MATERIALS)
                        .setRegistryName("theskyisland:synthetic_diamond_ingot")
                        .setTranslationKey("synthetic diamond ingot"));
        event.getRegistry().registerAll(
                quartz_crystal = new Item()
                        .setCreativeTab(CreativeTabs.MATERIALS)
                        .setRegistryName("theskyisland:quartz_crystal")
                        .setTranslationKey("quartz crystal"));
        event.getRegistry().registerAll(
                monocrystalline_silicon = new Item()
                        .setCreativeTab(CreativeTabs.MATERIALS)
                        .setRegistryName("theskyisland:monocrystalline_silicon")
                        .setTranslationKey("monocrystalline silicon"));
        event.getRegistry().registerAll(
                small_silicon_crystal = new Item()
                        .setCreativeTab(CreativeTabs.MATERIALS)
                        .setRegistryName("theskyisland:small_silicon_crystal")
                        .setTranslationKey("small silicon crystal"));
        event.getRegistry().registerAll(
                nickel_ingot = new Item()
                        .setCreativeTab(CreativeTabs.MATERIALS)
                        .setRegistryName("theskyisland:nickel_ingot")
                        .setTranslationKey("nickel ingot"));
        event.getRegistry().registerAll(
                artificial_ruby = new Item()
                        .setCreativeTab(CreativeTabs.MATERIALS)
                        .setRegistryName("theskyisland:artificial_ruby")
                        .setTranslationKey("artificial ruby"));
    }
}


