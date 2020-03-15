package net.hamsterapps.spigot.blankplugin.config;

import java.io.File;
import java.util.HashMap;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import net.hamsterapps.spigot.blankplugin.App;

public class ConfigHandler {
  private static Plugin plugin = App.getplugin();
  private static FileConfiguration config = plugin.getConfig();
  private static String configPath = plugin.getDataFolder() + System.getProperty("file.separator") + "config.yml";
  private static File configFile = new File(configPath);

  public static void setup() {
    if (!configFile.exists()) {
      plugin.saveDefaultConfig();
    }
  }

  public static HashMap<String, String> getDatabaseConfig() {
    HashMap<String, String> map = new HashMap<String, String>();
    map.put("dbuser", config.getString("dbuser"));
    map.put("dbpass", config.getString("dbpass"));
    map.put("dbname", config.getString("dbname"));
    map.put("dbhost", config.getString("dbhost"));
    return map;
  }
}