package theskyisland.tsi;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import theskyisland.tsi.Proxy.CommonProxy;
import theskyisland.tsi.util.Reference;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = "1.12.2")
public class TheSkyIsland {
    @Instance
    public static TheSkyIsland instance = new TheSkyIsland();

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;
}
