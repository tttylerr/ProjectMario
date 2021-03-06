package me.mountmario.projectmario.commands;

import me.mountmario.projectmario.ProjectMario;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class smp implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("smp")) {
            if(!(sender instanceof Player)) {
                System.out.println("Sorry, player is needed!");
            }
            Player player = (Player) sender;
            sendServer(player,"smp");


        }
        return true;
    }

    private void sendServer(Player player, String server) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeUTF("Connect");
            dataOutputStream.writeUTF(server);
        } catch (IOException e) {
            e.printStackTrace();
        }
        player.sendPluginMessage(ProjectMario.getPlugin(), "BungeeCord", byteArrayOutputStream.toByteArray());
        player.sendMessage(ChatColor.GREEN + "Connecting to the SMP.");
    }
}
