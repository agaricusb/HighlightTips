package agaricus.mods.highlighttips;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = "HighlightTips", name = "HighlightTips", version = "1.0-SNAPSHOT") // TODO: version from resource
@NetworkMod(clientSideRequired = false, serverSideRequired = false)
public class HighlightTips {

    @Mod.PreInit
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println("HT preinit!");
    }
}
