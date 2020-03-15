package net.hamsterapps.spigot.blankplugin.database;

import java.util.HashMap;

import org.bukkit.plugin.Plugin;

import co.aikar.idb.DB;
import co.aikar.idb.Database;
import co.aikar.idb.DatabaseOptions;
import co.aikar.idb.PooledDatabaseOptions;
import net.hamsterapps.spigot.blankplugin.App;
import net.hamsterapps.spigot.blankplugin.config.ConfigHandler;

public class DatabaseHandler {
  private static Plugin plugin = App.getplugin();

  public static void connect() {
    HashMap<String, String> args = ConfigHandler.getDatabaseConfig();
    try {
      DatabaseOptions options = DatabaseOptions.builder()
          .mysql(args.get("dbuser"), args.get("dbpass"), args.get("dbname"), args.get("dbhost")).build();

      Database db = PooledDatabaseOptions.builder().options(options).createHikariDatabase();
      DB.setGlobalDatabase(db);
      plugin.getLogger().info(String.format("Connected to database: %s", args.get("dbname")));
    } catch (Exception e) {
      plugin.getLogger().warning(e.getMessage());
    }
  }

  public static void close() {
    DB.close();
  }
}
