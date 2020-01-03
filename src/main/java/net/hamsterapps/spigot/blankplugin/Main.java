package net.hamsterapps.spigot.blankplugin;

import org.bukkit.plugin.java.JavaPlugin;

import net.hamsterapps.spigot.blankplugin.commands.CommandManager;

public class Main extends JavaPlugin {

  private static Main instance;
  public CommandManager commandManager;

  @Override
  public void onEnable() {
    setInstance(this);
    commandManager = new CommandManager();
    commandManager.setup();
    getLogger().info("BlankPlugin is starting");
  }

  @Override
  public void onDisable() {
    getLogger().info("BlankPlugin is stopping");
  }

  public static Main getInstance() {
    return instance;
  }

  private static void setInstance(Main instance) {
    Main.instance = instance;
  }
}
