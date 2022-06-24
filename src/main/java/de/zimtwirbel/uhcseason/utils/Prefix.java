package de.zimtwirbel.uhcseason.utils;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Prefix {

    MAIN("§2UHCSeason §8» §7"),
    WL("§cWhitelist §8» §7")
    ;
    private String prefix;

    @Override
    public String toString() {
        return prefix;
    }
}
