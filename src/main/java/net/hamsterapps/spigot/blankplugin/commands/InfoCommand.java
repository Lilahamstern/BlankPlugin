package net.hamsterapps.spigot.blankplugin.commands;

import org.bukkit.entity.Player;

import net.hamsterapps.spigot.blankplugin.Main;

public class InfoCommand extends SubCommand {

  private Main plugin = Main.getInstance();

  @Override
  public void onCommand(Player player, String[] args) {
    player.sendMessage("Welcome to blank command");
  }

  @Override
  public String name() {
    return plugin.commandManager.info;
  }

  @Override
  public String info() {
    return "";
  }

  @Override
  public String[] aliases() {
    return new String[0];
  }

}
