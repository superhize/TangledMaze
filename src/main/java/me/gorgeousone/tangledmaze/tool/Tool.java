package me.gorgeousone.tangledmaze.tool;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;

public abstract class Tool {
	
	private UUID player;

	public Tool(Player builder) {
		this.player = builder.getUniqueId();
	}
	
	public Player getPlayer() {
		return Bukkit.getPlayer(player);
	}

	public abstract String getName();
	
	public abstract void interact(Block clickedBlock, Action interaction);
}