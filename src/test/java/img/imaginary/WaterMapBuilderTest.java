package img.imaginary;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class WaterMapBuilderTest {
   
    @Test
    void buildWaterMap_ShouldReturnFlatWaterMap_WhenLandscapeMap() {
        int[][] landscapeMap = {
                { 1, 2, 1, 4, 4, 1 },
                { 2, 1, 4, 1, 1, 4 },
                { 2, 1, 3, 1, 1, 4 },
                { 1, 2, 1, 4, 4, 1 },
                { 1, 1, 1, 1, 1, 1 }
                };      
        WaterMapBuilder builder = new WaterMapBuilder(landscapeMap);
        int[][] expected = {
                { 0, 0, 0, 0, 0, 0 },
                { 0, 2, 0, 3, 3, 0 },
                { 0, 2, 0, 3, 3, 0 },
                { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 }
                };
        int[][] actual = builder.buildWaterMap();
        assertArrayEquals(expected, actual);
    }
    
    @Test
    void buildWaterMap_ShouldReturnAllZerosInTheMap_WhenAllHeightsAreEqual() {
        int[][] landscapeMap = {
                { 2, 2, 2, 2 },
                { 2, 2, 2, 2 },
                { 2, 2, 2, 2 },
                { 2, 2, 2, 2 }
                };
        WaterMapBuilder builder = new WaterMapBuilder(landscapeMap);
        int[][] expected =  {
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 }
                };
        int[][] actual = builder.buildWaterMap();
        assertArrayEquals(expected, actual);
    }
    
    @Test
    void buildWaterMap_ShouldReturnMapWithZeroHeights_WhenExistZeroInTheLandscape() {
        int[][] landscapeMap = {
                { 1, 2, 1, 4, 4, 1 },
                { 2, 1, 4, 1, 1, 4 },
                { 2, 0, 3, 1, 1, 4 },
                { 1, 2, 1, 4, 4, 1 },
                { 1, 1, 1, 1, 1, 1 }
                };
        WaterMapBuilder builder = new WaterMapBuilder(landscapeMap);
        int[][] expected =  {
                { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 3, 3, 0 },
                { 0, 0, 0, 3, 3, 0 },
                { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 }
                };
        int[][] actual = builder.buildWaterMap();
        assertArrayEquals(expected, actual);
    }
    
    @Test
    void instantiationWaterMapBuilder_ShouldThrowIllegalArgumentException_WhenNull() {
        assertThrows(IllegalArgumentException.class, () -> new WaterMapBuilder(null));
    }
}
