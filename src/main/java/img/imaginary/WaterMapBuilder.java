package img.imaginary;

/**
 * This class is intended for building a height map of the water level
 * processing the incoming landscape map (rectangular two-dimensional array)
 * if assuming that the landscape was filled with water to the highest
 * point and water has poured out over the edges
 */
public class WaterMapBuilder {
    private final int[][] landscapeMap; 
    private boolean[][] visited;
    private int[][] waterMap;
    
    /**
     * Creates WaterMapBuilder that uses landscape Map (rectangular two-dimensional array)
     * 
     * @param landscapeMap (int[][] array of landscape)
     * @throws IllegalArgumentException If landscape map is null        
     */
    public WaterMapBuilder(int[][] landscapeMap) {
        if(landscapeMap == null) {
            throw new IllegalArgumentException("landscapeMap can't be null");
        }
        this.landscapeMap = landscapeMap;
    }
    
    /**
    * Returns water level on a flat map of landscape 
    * 
    * @return int[][] array of water level
    */
    public int[][] buildWaterMap() {
        int lines = landscapeMap.length;
        int columns = landscapeMap[0].length;            
        waterMap = new int[lines][columns]; 
        visited = new boolean[lines][columns];
        waterMap = buildMapFrame(lines, columns);
        for (int i = 1; i < lines - 1; i++) {
            for (int j = 1; j < columns - 1; j++) {
                waterMap[i][j] = getMinWaterLevel(i, j);
            }
        }
        return waterMap;
    }

    private int[][] buildMapFrame(int lines, int columns) {
        int[][] mapFrame = new int[lines][columns];
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                mapFrame[i][j] = -1;
                mapFrame[0][j] = 0;
                mapFrame[i][0] = 0;
                mapFrame[i][columns - 1] = 0;
                mapFrame[lines - 1][j] = 0;
            }
        }
        return mapFrame;
    }

    /*
     * the length of this recursive method is too long, it has a certain
     * amount of repetitive code that is not separated into separate methods.
     * This is done on purpose so as not to reduce the possible depth of the call stack
     */
    private int getMinWaterLevel(int i, int j) {
        if (visited[i][j]) {
            return Integer.MAX_VALUE;
        }
        if (landscapeMap[i][j] == 0) {
            waterMap[i][j] = 0;
            return 0;
        }
        if (waterMap[i][j] != -1) {
            return waterMap[i][j];
        }
        visited[i][j] = true;
        int min = Integer.MAX_VALUE;
        int shift = j - 1;
        int waterLevel;
        int shiftValue;
        if (waterMap[i][shift] != -1) {
            waterLevel = waterMap[i][shift];
        } else {
            waterLevel = getMinWaterLevel(i, shift);
        }
        shiftValue = max(waterLevel, landscapeMap[i][shift]);
        if (shiftValue <= landscapeMap[i][j]) {
            waterMap[i][j] = 0;
            visited[i][j] = false;
            return 0;
        }
        if (shiftValue < min) {
            min = shiftValue;
        }
        shift = j + 1;
        if (waterMap[i][shift] != -1) {
            waterLevel = waterMap[i][shift];
        } else {
            waterLevel = getMinWaterLevel(i, shift);
        }
        shiftValue = max(waterLevel, landscapeMap[i][shift]);
        if (shiftValue <= landscapeMap[i][j]) {
            waterMap[i][j] = 0;
            visited[i][j] = false;
            return 0;
        }
        if (shiftValue < min) {
            min = shiftValue;
        }
        shift = i - 1;
        if (waterMap[shift][j] != -1) {
            waterLevel = waterMap[shift][j];
        } else {
            waterLevel = getMinWaterLevel(shift, j);
        }
        shiftValue = max(waterLevel, landscapeMap[shift][j]);
        if (shiftValue <= landscapeMap[i][j]) {
            waterMap[i][j] = 0;
            visited[i][j] = false;
            return 0;
        }
        if (shiftValue < min) {
            min = shiftValue;
        }
        shift = i + 1;
        if (waterMap[shift][j] != -1) {
            waterLevel = waterMap[shift][j];
        } else {
            waterLevel = getMinWaterLevel(shift, j);
        }
        shiftValue = max(waterLevel, landscapeMap[shift][j]);
        if (shiftValue <= landscapeMap[i][j]) {
            waterMap[i][j] = 0;
            visited[i][j] = false;
            return 0;
        }
        if (shiftValue < min) {
            min = shiftValue;
        }
        visited[i][j] = false;
        return min;
    }
    
    private int max (int first, int second) {
        return first > second ? first : second;
    }
}
