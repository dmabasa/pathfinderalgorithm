package com.multichoice.pathfinderalgorithm.common;

import com.multichoice.pathfinderalgorithm.service.PathFinderService;
import com.multichoice.pathfinderalgorithm.service.impl.PathFinderServiceImpl;

public class MapBuilder implements TileMapService
{

	private int width;
	private int height;
	private Obstacle[][] terrain = null;
	private boolean[][] visited = null;
	private TileMapService map;

	public void init() {

		beforeInit();
		terrain = new Obstacle[getWidth()][getHeight()];
		visited = new boolean[getWidth()][getHeight()];
		buildMap();
		afterInit();
	}

	public void afterInit() {

		setMap(this);
	}

	public void beforeInit() {

	}

	public void setWidth(int width) {

		this.width = width;
	}

	public int getWidth() {

		return width;
	}

	public int getHeight() {

		return height;
	}

	public void setHeight(int height) {

		this.height = height;
	}

	public void searchedLocation(int x, int y) {

		visited[x][y] = true;
	}

	public boolean walkable(int x, int y) {

		return terrain[x][y].getCost() == 0;
	}

	public float getCost(int sx, int sy, int tx, int ty) {

		return terrain[sx][sy].getCost();
	}

	public Obstacle[][] getTerrain() {

		return terrain;
	}

	public void printMap() {

		for (int xp = 0; xp < getWidth(); xp++) {
			for (int yp = 0; yp < getHeight(); yp++) {
				System.out.print(getTerrain()[xp][yp].getSymbol());
			}
			System.out.println("");
		}
	}

	public void replaceByBestPath(Path path, int length) {

		for (int i = 0; i < length; i++) {
			terrain[path.getX(i)][path.getY(i)].setSymbol("#");
		}
	}

	public TileMapService getMap() {

		return map;
	}

	public void setMap(TileMapService map) {

		this.map = map;
	}

	public void addObstacleToMap(int x, int y, Obstacle obstacle) {

		terrain[x][y] = obstacle;
	}

	public void buildMap() {

	}

	public void findPath(int sx, int sy, int tx, int ty ) {

		PathFinderService pathFinder = new PathFinderServiceImpl(map, getWidth()*getHeight());
		Path path = pathFinder.findPath(sx, sy, tx, tx);

		int length = path.getLength();
		System.out.println("--------------- |Original|------------------------");
		printMap();
		System.out.println("--------------- |After Replacement|---------------");
		replaceByBestPath(path, length);
		printMap();
		System.out.println("--------------------------------------------------");
	}
}
