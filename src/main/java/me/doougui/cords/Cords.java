package me.doougui.cords;

import me.doougui.cords.commands.CordsCommand;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Cords extends JavaPlugin {
    @Override
    public void onEnable() {
        System.out.println("[Cords] Plugin is up");

        PluginCommand command = getCommand("cords");

        if (command == null) return;

        command.setExecutor(new CordsCommand());
    }

    @Override
    public void onDisable() {
        System.out.println("[Cords] Plugin shut down");
    }
}
