package com.multichoice.pathfinderalgorithm.common;

import java.util.HashMap;
import java.util.Map;

import com.multichoice.pathfinderalgorithm.common.obstacles.UserStartTile;
import com.multichoice.pathfinderalgorithm.common.obstacles.GoalTile;
import com.multichoice.pathfinderalgorithm.common.obstacles.DotFlatland;
import com.multichoice.pathfinderalgorithm.common.obstacles.Forest;
import com.multichoice.pathfinderalgorithm.common.obstacles.Mountain;
import com.multichoice.pathfinderalgorithm.common.obstacles.Water;

public class ObstacleRegistry {

	private static Map<String, Class<? extends Obstacle>> obstacles;

	static {

		obstacles = new HashMap<String, Class<? extends Obstacle>>();
		obstacles.put("~", Water.class); 
		obstacles.put("@", UserStartTile.class);
		obstacles.put("X", GoalTile.class);
		obstacles.put(".", DotFlatland.class);
		obstacles.put("*", Forest.class);
		obstacles.put("^", Mountain.class);
	}

	@SuppressWarnings("unchecked")
	public static <T extends Obstacle> T getInstance(String symbol) {

		T instance = null;
		try {
			if (instance == null) {
				instance = (T) obstacles.get(symbol).newInstance();
			}
		} catch (IllegalAccessException e) {
			// throw new SystemException(e);
		} catch (InstantiationException e) {
			// throw new SystemException(e);
		}
		return instance;
	}
}
