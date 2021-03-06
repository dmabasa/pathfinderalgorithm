package com.multichoice.pathfinderalgorithm.common;

public interface TileMapService
{

	public int getWidth();
	public int getHeight();
	public void searchedLocation(int x, int y);
	public boolean walkable(int x, int y);
	public float getCost(int sx, int sy, int tx, int ty);
	public void buildMap();
}
