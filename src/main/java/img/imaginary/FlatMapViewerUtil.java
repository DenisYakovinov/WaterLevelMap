package img.imaginary;

public class FlatMapViewerUtil {

    private FlatMapViewerUtil() {
    }

    public static void viewFlatMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
