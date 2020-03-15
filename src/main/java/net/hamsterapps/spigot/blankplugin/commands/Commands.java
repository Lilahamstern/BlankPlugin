package net.hamsterapps.spigot.blankplugin.commands;

import org.bukkit.plugin.Plugin;

import co.aikar.commands.PaperCommandManager;
import net.hamsterapps.spigot.blankplugin.commands.player.BlankCommand;

public class Commands {

  public static void setup(Plugin plugin) {
    PaperCommandManager manager = new PaperCommandManager(plugin);
    manager.registerCommand(new BlankCommand());
  }
}