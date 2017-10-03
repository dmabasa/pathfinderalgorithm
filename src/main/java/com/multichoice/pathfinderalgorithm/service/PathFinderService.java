package com.multichoice.pathfinderalgorithm.service;

import com.multichoice.pathfinderalgorithm.common.Path;

public interface PathFinderService
{
	public Path findPath(int sx, int sy, int tx, int ty);
}
