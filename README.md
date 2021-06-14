#WaterLevelMap

There is a two-dimensional array of integers of arbitrary size, which is a rectangular elevation map.

Imagine that water was poured on top of this map, which filled all the recesses. At the same time:


- If there are cells with a height of 0 in the height map, then they are considered "holes". That is, the water will flow through them.

Write a function that will return a height map for the remaining water on the map. The value 0 corresponds to the absence of water in the cell.

Height map:

2 2 2 2

2 2 2 2

2 2 2 2

Result:

0 0 0 0

0 0 0 0

0 0 0 0

All cells are the same height, the water will not remain on the map



## Example 2

Height map:

1 3 4 5

4 1 1 4

5 6 7 2

Result:

0 0 0 0

0 3 3 0

0 0 0 0

The two cells in the center are surrounded on all sides by higher cells. The water in them will reach a height of 3, since this is the minimum height of the cell [1,0] from the surrounding contour



## Example 3

Height map:

1 3 4 5

4 1 0 4

5 6 7 2

Result:

0 0 0 0

0 0 0 0

0 0 0 0

The height map is as in Example 2, but the cell [2,1] has a "hole" (value 0) through which water will leak. Therefore, there will be no water left on such a map.



## Example 4

Height map:

1 2 1 4 4 1

2 1 4 1 1 4

2 1 3 1 1 4

1 2 1 4 4 1

1 1 1 1 1 1

Result:

0 0 0 0 0 0

0 2 0 3 3 0

0 2 0 3 3 0

0 0 0 0 0 0

0 0 0 0 0 0

There will be 2 areas filled with water on this map.
