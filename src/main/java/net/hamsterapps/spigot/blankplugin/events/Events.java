package net.hamsterapps.spigot.blankplugin.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Events implements Listener {

  @EventHandler
  public void onMove(PlayerMoveEvent e) {
    Player player = (Player) e.getPlayer();
    player.sendMessage("STOP FACKING MOVE FAGGOT");
  }
}