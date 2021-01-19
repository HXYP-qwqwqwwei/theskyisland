package theskyisland.tsi.modelmapper.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import theskyisland.tsi.TheSkyIsland;
import theskyisland.tsi.item.ItemInitializer;
import theskyisland.tsi.util.Reference;

import java.util.Objects;

import static theskyisland.tsi.item.ItemInitializer.synthetic_diamond_ingot;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = Reference.MODID)
public class ItemModelMapper
{
    @SubscribeEvent
    public static void onModelReg(ModelRegistryEvent event)
    {
        TheSkyIsland.proxy.modelRegistry(synthetic_diamond_ingot, 0, "inventory");
    }
}
