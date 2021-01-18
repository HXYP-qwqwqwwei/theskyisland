package theskyisland.tsi;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import theskyisland.tsi.util.Reference;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = "1.12.2")
public class TheSkyIsland {
    @Instance
    public static TheSkyIsland instance = new TheSkyIsland();
}
