package com.MrEngMan.OpenAnvil.commands;

import com.MrEngMan.OpenAnvil.OpenAnvil;
import com.MrEngMan.OpenAnvil.util.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class ReloadCommandHandler implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        // Player issued command
        if (sender instanceof Player) {
            Player player = (Player) sender;

            // Make sure they have permission
            if (player.hasPermission("oareload.reload")) {
                OpenAnvil.getPlugin().reloadTheConfig();
                player.sendMessage(Utils.SendChatMessage(OpenAnvil.getPlugin().getConfig().getString("reloaded-message")));
            } else {
                player.sendMessage(Utils.SendChatMessage(OpenAnvil.getPlugin().getConfig().getString("no-permission-message")));
            }

        }

        // Console issued command
        else if (sender instanceof ConsoleCommandSender) {
            OpenAnvil.getPlugin().reloadTheConfig();
            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
            console.sendMessage(Utils.SendChatMessage(OpenAnvil.getPlugin().getConfig().getString("reloaded-message")));
        }

        return true;
    }

}