package de.zimtwirbel.uhcseason.service.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import de.zimtwirbel.uhcseason.service.WhitelistService;
import de.zimtwirbel.uhcseason.utils.Prefix;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@CommandAlias("wl|whitelist")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class WhitelistCommand extends BaseCommand {

    private final WhitelistService whitelistService;

    @Default
    @CatchUnknown
    public void onDefault(Player sender) {
        String list = whitelistService.list();
        if (list.equals(""))
            sender.sendMessage(Prefix.WL + "§cEs sind keine Spieler auf der §fWhitelist§c!");
        else
            sender.sendMessage(Prefix.WL + list);
    }

    @Subcommand("add")
    @CommandPermission("wl.add")
    @Syntax("§7[§ename§7]")
    public void add(Player sender, @Single String playerName) {
        if (whitelistService.add(playerName)) {
            sender.sendMessage(Prefix.WL + "Du hast §2" + playerName + "§7 der §fWhitelist §ahinzugefügt§7!");
            return;
        }
        sender.sendMessage(Prefix.WL + "§2" + playerName + "§7 ist §abereits§7 auf der §fWhitelist§7!");
    }

    @Subcommand("add")
    @CommandPermission("wl.remove")
    @CommandCompletion("@players @nothing")
    @Syntax("§7[§ename§7]")
    public void remove(Player sender, @Single String playerName) {
        Player player = Bukkit.getPlayer(playerName);
        if (player != null)
            player.kickPlayer(Prefix.WL + "Du wurdest von der §fWhitelist §centfernt§7!");
        if (whitelistService.remove(playerName)) {
            sender.sendMessage(Prefix.WL + "Du hast §c" + playerName + "§7 von der §fWhitelist §centfernt§7!");
            return;
        }
        sender.sendMessage(Prefix.WL + "§c" + playerName + "§7 ist §anicht§7 auf der §fWhitelist§7!");
    }
}
