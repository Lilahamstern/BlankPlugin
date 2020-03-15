package net.hamsterapps.spigot.blankplugin.commands.player;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CatchUnknown;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.annotation.Subcommand;

@CommandAlias("blank")
public class BlankCommand extends BaseCommand {

  @Subcommand("help")
  @CatchUnknown
  @Default
  @Description("Get help for every command")
  public void onAll(CommandSender sender, String[] args) {
    Player player = (Player) sender;
    player.sendMessage("Heey");
  }
}