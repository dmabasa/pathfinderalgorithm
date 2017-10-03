package com.multichoice.pathfinderalgorithm.common;

public class ManhattanDistanceCalculator
{

	public float getCost(int x, int y, int tx, int ty) {

		return (Math.abs(x - tx) + Math.abs(y - ty));
	}
}
