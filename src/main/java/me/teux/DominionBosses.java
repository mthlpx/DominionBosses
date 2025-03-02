package me.teux;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import me.teux.cfg.Config;
import me.teux.commands.BossLvl1Command;
import me.teux.commands.WorldNameCommand;

import java.io.File;

@Mod(modid = DominionBosses.MODID, name = DominionBosses.NAME)
public class DominionBosses {

    public static final String MODID = "dominionbosses";
    public static final String NAME = "Dominion Bosses";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        File configFile = new File(event.getModConfigurationDirectory(), MODID + ".cfg");
        Config.load(configFile);
    }

    public void init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        event.registerServerCommand(new BossLvl1Command());
        event.registerServerCommand(new WorldNameCommand());
    }
}
