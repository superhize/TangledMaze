package me.gorgeousone.tangledmaze.utils;

import org.bukkit.util.Vector;

public enum Directions {
	
	EAST(      new Vec2( 1,  0)),
	SOUTH_EAST(new Vec2( 1,  1)),
	SOUTH(     new Vec2( 0,  1)),
	SOUTH_WEST(new Vec2(-1,  1)),
	WEST(      new Vec2(-1,  0)),
	NORTH_WEST(new Vec2(-1, -1)),
	NORTH(     new Vec2( 0, -1)),
	NORTH_EAST(new Vec2( 1, -1));

	private Vec2 facing;
	
	Directions(Vec2 facing) {
		this.facing = facing;
	}
	
	public Vec2 facing() {
		return facing.clone();
	}
	
	public Vector facing3d() {
		return facing.toVec3();
	}
	
	public static Directions[] cardinalValues() {
		return new Directions[] {EAST, SOUTH, WEST, NORTH};
	}
}