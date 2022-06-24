package de.zimtwirbel.uhcseason.listener;

import de.zimtwirbel.uhcseason.utils.Prefix;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.springframework.stereotype.Component;

@Component
public class ConnectionListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.setJoinMessage(Prefix.MAIN + "§a" + event.getPlayer().getName() + " §7hat den Server betreten.");
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        event.setQuitMessage(Prefix.MAIN + "§a" + event.getPlayer().getName() + " §7hat den Server verlassen.");
    }

}
