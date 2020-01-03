package net.hamsterapps.spigot.blankplugin.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.hamsterapps.spigot.blankplugin.Main;
import net.md_5.bungee.api.ChatColor;

public class CommandManager implements CommandExecutor {
  private ArrayList<SubCommand> commands = new ArrayList<SubCommand>();
  private Main plugin = Main.getInstance();

  public CommandManager() {
  }

  public String main = "blank";
  public String info = "info";

  public void setup() {
    plugin.getCommand(main).setExecutor(this);

    this.commands.add(new InfoCommand());
  }

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (!(sender instanceof Player)) {
      sender.sendMessage(ChatColor.RED + "You are not allowed to execute the command from console!");
    }

    Player player = (Player) sender;

    if (command.getName().equalsIgnoreCase(main)) {
      if (args.length == 0) {
        player.sendMessage(ChatColor.RED + "Arguments are missing. Type /" + main + " help for more info");
      }

      SubCommand target = this.get(args[0]);

      if (target == null) {
        player.sendMessage(Color.RED + "Invalid subcommand");
        return true;
      }

      ArrayList<String> arrayList = new ArrayList<String>();

      arrayList.addAll(Arrays.asList(args));
      arrayList.remove(0);

      try {
        target.onCommand(player, args);
      } catch (Exception e) {
        player.sendMessage(Color.RED + "An error has occuerd");

        e.printStackTrace();
      }
    }
    return true;
  }

  private SubCommand get(String name) {
    Iterator<SubCommand> subCommands = this.commands.iterator();

    while (subCommands.hasNext()) {
      SubCommand sc = (SubCommand) subCommands.next();

      if (sc.name().equalsIgnoreCase(name)) {
        return sc;
      }

      String[] aliases;
      int length = (aliases = sc.aliases()).length;

      for (int i = 0; i < length; i++) {
        String alias = aliases[i];
        if (name.equalsIgnoreCase(alias)) {
          return sc;
        }
      }
    }
    return null;
  }
}