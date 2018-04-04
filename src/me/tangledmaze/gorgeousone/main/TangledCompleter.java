package me.tangledmaze.gorgeousone.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

public class TangledCompleter implements TabCompleter {
	
	private ArrayList<String> subCmds;
	
	public TangledCompleter() {
		subCmds = new ArrayList<>(Arrays.asList(
				"wand",
				"select",
				"start",
				"add",
				"subtract",
				"deselect"));
	}
	
	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player))
			return null;
		if(!cmd.getName().equalsIgnoreCase("tangledmaze"))
			return null;
		
		ArrayList<String> options = new ArrayList<>();
		
		switch (args.length) {
		case 1:
			if(args[0].equals(""))
				options.addAll(subCmds);
			else
				for(String command : subCmds)
					if(command.startsWith(args[0].toLowerCase()))
						options.add(command);
			break;
		case 2:
			if(args[0].equalsIgnoreCase("select"))
				options.addAll(Arrays.asList("rectangle", "ellipse"));
			break;
		default:
			break;
		}
		return options;
	}

}