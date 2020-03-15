package net.hamsterapps.spigot.blankplugin;

import org.bukkit.plugin.java.JavaPlugin;

import net.hamsterapps.spigot.blankplugin.commands.Commands;
import net.hamsterapps.spigot.blankplugin.database.DatabaseHandler;
import net.hamsterapps.spigot.blankplugin.events.Events;

public class App extends JavaPlugin {

  private static App plugin;

  @Override
  public void onEnable() {
    setplugin(this);
    plugin.getServer().getPluginManager().registerEvents(new Events(), plugin);
    Commands.setup(plugin);
    DatabaseHandler.connect();
    getLogger().info("BlankPlugin is starting");
  }

  @Override
  public void onDisable() {
    DatabaseHandler.close();
    getLogger().info("BlankPlugin is stopping");
  }

  public static App getplugin() {
    return plugin;
  }

  private static void setplugin(App plugin) {
    App.plugin = plugin;
  }
}
