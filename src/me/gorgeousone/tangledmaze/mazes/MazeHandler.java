package me.gorgeousone.tangledmaze.mazes;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;

import me.gorgeousone.tangledmaze.core.Renderer;

public abstract class MazeHandler {
	
	private static HashMap<UUID, Maze> mazes = new HashMap<>();
	
	public static boolean hasMaze(Player p) {
		return mazes.containsKey(p.getUniqueId());
	}
	
	public static Maze getMaze(Player p) {
		return mazes.get(p.getUniqueId());
	}
	
	public static void setMaze(Player p, Maze maze) {
		mazes.put(p.getUniqueId(), maze);
		Renderer.registerMaze(maze);
	}
	
	public static void removeMaze(Player p) {
		Renderer.unregisterMaze(getMaze(p));
		mazes.remove(p.getUniqueId());
	}
}