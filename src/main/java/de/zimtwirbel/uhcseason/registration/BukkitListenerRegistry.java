package de.zimtwirbel.uhcseason.registration;

import de.zimtwirbel.uhcseason.registration.event.BukkitPluginEnableEvent;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class BukkitListenerRegistry {

    private static final Logger LOGGER = LoggerFactory.getLogger(BukkitListenerRegistry.class);


    @EventListener
    public void loadOnEnable(BukkitPluginEnableEvent event) {
        event.getApplicationContext().getBeansOfType(Listener.class).forEach((s, listener) -> {
            Bukkit.getPluginManager().registerEvents(listener, event.getPlugin());
            LOGGER.info("Listener of bean " + s + " has been enabled!");
        });
    }

}
