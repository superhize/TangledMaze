package me.gorgeousone.tangledmaze.mazes;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;

import me.gorgeousone.tangledmaze.core.Renderer;
import me.gorgeousone.tangledmaze.mazes.generation.BlockGenerator;
import me.gorgeousone.tangledmaze.mazes.generation.BuildMap;
import me.gorgeousone.tangledmaze.mazes.generation.ExitGenerator;
import me.gorgeousone.tangledmaze.mazes.generation.PathGenerator;

public abstract class MazeHandler {
	
	private static HashMap<UUID, Maze> mazes = new HashMap<>();

	public static void reload() {
		mazes.clear();
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
	
	public static void buildMaze(Maze maze) {
		Renderer.hideMaze(maze);
		
		BuildMap map = new BuildMap(maze);
		ExitGenerator.generateExits(map);
		PathGenerator.generatePaths(map);
		BlockGenerator.generateBlocks(map, null);
	}
}