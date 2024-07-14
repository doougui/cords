package me.doougui.cords.commands;

import me.doougui.cords.Cords;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.Objects;

public class CordsCommand implements CommandExecutor {
    Plugin plugin = Cords.getPlugin(Cords.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (!(sender instanceof Player)) return false;

        Player player = getPlayer(strings, (Player) sender);
        Location location = player.getLocation();

        int x = (int) location.getX();
        int y = (int) location.getY();
        int z = (int) location.getZ();

        String msg = String.format("%s[%s] %sX: %d, Y: %d, Z: %d", ChatColor.DARK_AQUA, player.getDisplayName(), ChatColor.AQUA, x, y, z);

        plugin.getServer().broadcastMessage(msg);

        return true;
    }

    private Player getPlayer(String[] mentions, Player sender) {
        if (mentions.length == 0) return sender;

        Player mentionedPlayer = plugin.getServer().getPlayer(mentions[0]);
        if (mentionedPlayer != null) return mentionedPlayer;

        return sender;
    }
}
