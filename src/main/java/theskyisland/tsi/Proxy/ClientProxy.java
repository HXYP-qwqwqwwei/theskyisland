package theskyisland.tsi.Proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

import java.util.Objects;

public class ClientProxy extends CommonProxy
{
    @Override
    public void modelRegistry(Item item, int metadata, String variantIn) {
        ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()), variantIn));
    }
}
