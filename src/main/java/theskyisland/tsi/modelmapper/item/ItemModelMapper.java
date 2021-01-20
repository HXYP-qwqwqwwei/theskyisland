package theskyisland.tsi.modelmapper.item;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import theskyisland.tsi.TheSkyIsland;
import theskyisland.tsi.util.Reference;
import static theskyisland.tsi.item.ItemInitializer.synthetic_diamond_ingot;
import static theskyisland.tsi.item.ItemInitializer.tsipickaxe;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = Reference.MODID)
public class ItemModelMapper
{
    @SubscribeEvent
    public static void onModelReg(ModelRegistryEvent event)
    {
        TheSkyIsland.proxy.modelRegistry(synthetic_diamond_ingot, 0, "inventory");
        TheSkyIsland.proxy.modelRegistry(tsipickaxe, 0, "inventory");
    }
}
