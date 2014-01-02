package com.kame.ancientrelics;

import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class CommonProxy {

    // Client stuff
    public void registerRenderers() {
            // Nothing here as the server doesn't render graphics or entities!  
}
public int addArmor(String string)
{
return 0;
}
   public void registerServerTickHandler() {
	   TickRegistry.registerTickHandler(new ServerTickHandler(), Side.SERVER);
   }
}
