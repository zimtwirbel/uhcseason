package de.zimtwirbel.uhcseason.configuration;

import co.aikar.commands.PaperCommandManager;
import de.zimtwirbel.uhcseason.registration.event.BukkitPluginEnableEvent;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bukkit.plugin.java.JavaPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class BukkitConfiguration {

    private final ApplicationEventPublisher eventPublisher;


    @Getter
    private JavaPlugin plugin;


    public void startBukkitPlugin(ApplicationContext context, JavaPlugin plugin) {
        this.plugin = plugin;
        this.eventPublisher.publishEvent(new BukkitPluginEnableEvent(context, plugin));
    }

    @Setter
    private PaperCommandManager commandManager;



}
