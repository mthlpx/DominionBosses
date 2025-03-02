package me.teux.cfg;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class Config {
    private static Configuration config;

    public static String bossLvl1Name;

    private static String BOSSLVL1NAME = "bosslvl1";

    public static void load(File configFile) {
        config = new Configuration(configFile);

        try {
            config.load();
            bossLvl1Name = config.get("bossLvl1", "name", BOSSLVL1NAME).getString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (config.hasChanged()) {
                config.save();
            }
        }
    }

    public static void save() {
        if (config.hasChanged()) {
            config.save();
        }
    }
}
