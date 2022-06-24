package de.zimtwirbel.uhcseason;

import de.zimtwirbel.uhcseason.configuration.BukkitConfiguration;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BukkitPlugin extends JavaPlugin {

    @Getter
    private static AnnotationConfigApplicationContext context;

    @Override
    public void onEnable() {
        Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
        context = new AnnotationConfigApplicationContext(Application.class);
        BukkitConfiguration bukkitConfiguration = context.getBean(BukkitConfiguration.class);
        bukkitConfiguration.startBukkitPlugin(context, this);
        context.registerShutdownHook();
    }
}
