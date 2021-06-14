package img.imaginary;

public class AppStarter {
       
    public static void main(String[] args) {
        int[][] landScapeMap = {
                { 1, 2, 1, 4, 4, 1 },
                { 2, 1, 4, 1, 1, 4 },
                { 2, 1, 3, 1, 1, 4 },
                { 1, 2, 1, 4, 4, 1 },
                { 1, 1, 1, 1, 1, 1 }
                };
        FlatMapViewerUtil.viewFlatMap(new WaterMapBuilder(landScapeMap).buildWaterMap());
    }
}
