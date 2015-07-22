package com.ETOILE123.Chat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	//SWAG//
	private Boolean ChatDisable = false;
	private String Prefix = "["+ChatColor.GOLD+""+ChatColor.BOLD+"ChatManager"+ChatColor.WHITE+"] ";
	private int Line;
	//SWAG//
	
	public void onEnable(){
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}
	
	//EVENTS//
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		
		if(!ChatDisable == false){
			e.setCancelled(true);
			p.sendMessage(Prefix+ChatColor.RED+"Le chat est desactivé pour le moment !");
		}else{
			e.setCancelled(false);
		}
		
	}
	
	
	//COMMANDES//
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
    	//ChatDisable
    	if(cmd.getName().equalsIgnoreCase("ChatDisable")){
    		
    		if(ChatDisable == true){
    			Bukkit.broadcastMessage(Prefix+ChatColor.GREEN+"Le Chat est activé !");
    			ChatDisable = false;
    		}else{
                Bukkit.broadcastMessage(Prefix+ChatColor.RED+"Le Chat est desactivé !");
    			ChatDisable = true;
    		}
    		
    	}
    	
    	//ChatClear
    	if(cmd.getName().equalsIgnoreCase("ChatClear")){
    		Line = 100;
    		while(!(Line == 0)){
    		Line--;	
    		Bukkit.broadcastMessage(" ");
    		}
    		Bukkit.broadcastMessage(Prefix+ChatColor.AQUA+"Chat Clear by : "+sender.getName());
    	}
    	
    	
    	return false;
    }
	
	
}
