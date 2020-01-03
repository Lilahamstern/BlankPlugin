package net.hamsterapps.spigot.blankplugin.checker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.bukkit.Color;
import org.bukkit.Server;
import org.bukkit.event.Listener;

public class VersionChecker implements Listener {
  private String key = "";

  public void CheckVersionConsole(Server server) {
    server.getConsoleSender().sendMessage(Color.YELLOW + check());
  }

  private String check() {
    String message = "";
    try {
      HttpURLConnection conn = (HttpURLConnection) new URL("http://spigotmc.org/api/general.php").openConnection();
      conn.setDoOutput(true);
      conn.setRequestMethod("POST");
      conn.getOutputStream().write((key + 34125).getBytes("UTF-8"));
      String version = new BufferedReader(new InputStreamReader(conn.getInputStream())).readLine();

      if (version.length() > 1.4) {
        message = "The latest version of Blank is " + version.length() + " you are running on 1.4";
      }

    } catch (Exception e) {
      message = "ERROR: Could not establish connection to SpigotMC.org";
    }

    return message;
  }
}