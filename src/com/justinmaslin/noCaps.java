package com.justinmaslin;

import java.util.logging.Logger;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class noCaps extends JavaPlugin implements Listener
{
	Logger log;

	public void onEnable()
	{
		log=this.getLogger();
		log.info("noCaps enabled.");
		getServer().getPluginManager().registerEvents(new noCaps(), this);
	}

	public void onDisable()
	{
		log.info("noCaps disabled.");
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerChat(PlayerChatEvent event)
	{
		//Player player=event.getPlayer();
		String message=event.getMessage();

		int value, capsCount=0, symbolCount=0;
		double percentCaps, percentSymbols;

		for (int x=0; x<message.length(); x++)
		{
			value=message.charAt(x);
			if (value >= 65 && value <=90)
				capsCount++;
			if (value >= 33 && value <= 64)
				symbolCount++;
			//else
			//	normCount++;
		}

		percentCaps=(double)capsCount/message.length();
		percentSymbols=(double)symbolCount/message.length();
		
		if (percentCaps > .55)
		{
			event.setMessage("I used too many caps!");
		}
		
		if (symbolCount > 4)
		{
			event.setMessage("I used too many numbers or symbols!");
		}
		
		
	}

}
