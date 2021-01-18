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
    public static Item myFirstItem;
    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(
                myFirstItem = new Item()
                        .setCreativeTab(CreativeTabs.MATERIALS)
                        .setRegistryName("theskyisland:myfirstitem")
                        .setTranslationKey("myFirstName"));
    }
}
