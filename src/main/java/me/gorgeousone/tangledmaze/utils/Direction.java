package me.gorgeousone.tangledmaze.utils;

public enum Direction {
	
	//putting opposite values next to each other can help quicken methods like Maze.sealsMaze();
	EAST(new Vec2(1, 0)),
	WEST(new Vec2(-1, 0)),
	SOUTH(new Vec2(0, 1)),
	NORTH(new Vec2(0, -1)),
	SOUTH_EAST(new Vec2(1, 1)),
	NORTH_WEST(new Vec2(-1, -1)),
	SOUTH_WEST(new Vec2(-1, 1)),
	NORTH_EAST(new Vec2(1, -1));
	
	private Vec2 facing;
	
	Direction(Vec2 facing) {
		this.facing = facing;
	}
	
	public static Direction[] fourCardinals() {
		return new Direction[]{EAST, WEST, SOUTH, NORTH};
	}
	
	/**
	 * Returns if the diretion's vector is pointing towards positive or negative (with it's x or z coordinate)
	 */
	public boolean isPositive() {
		return facing.getZ() == 0 ? facing.getX() == 1 : facing.getZ() == 1;
	}
	
	/**
	 * Returns if the x coordinate of the direction's vector is not 0
	 */
	public boolean isXAligned() {
		return facing.getX() != 0;
	}
	
	public Vec2 getVec2() {
		return facing.clone();
	}
}