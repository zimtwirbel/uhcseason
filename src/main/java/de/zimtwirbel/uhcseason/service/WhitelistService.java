package de.zimtwirbel.uhcseason.service;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.springframework.stereotype.Service;

@Service
public class WhitelistService {

    public String list() {
        StringBuilder stringBuilder = new StringBuilder();
        for (OfflinePlayer whitelistedPlayer : Bukkit.getWhitelistedPlayers()) {
            if (!stringBuilder.toString().equals(""))
                stringBuilder.append("§7, ");
            stringBuilder.append("§f").append(whitelistedPlayer.getName());
        }
        return stringBuilder.toString();
    }

    public boolean add(String name) {
        if (list().contains(name))
            return false;
        Bukkit.getOfflinePlayer(name).setWhitelisted(true);
        return true;
    }

    public boolean remove(String name) {
        if (!list().contains(name))
            return false;
        Bukkit.getOfflinePlayer(name).setWhitelisted(false);
        return true;
    }

}
