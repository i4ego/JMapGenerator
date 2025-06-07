import java.util.Random;
import java.util.Vector;

public class MapGenerator {
    private static Vector<double[]> generateMatrix (int maxHeight, int maxWidth) {
        Vector<double[]> matrix = new Vector<double[]>(maxHeight);

        Random r = new Random();
        int[] positions = new int[]{
                r.nextInt(maxHeight),
                r.nextInt(maxWidth),
        };

        for (int i = 0; i < maxHeight; i++) {
            double[] k = new double[16];
            for (int j = 0; j < maxHeight; j++) {
                k[j] = r.nextDouble();
            }
            matrix.add(k);
        }
        return matrix;
    }
    public static Vector generateChunk(int maxSize) {

        Vector<Vector<double[]>> chunk = new Vector<Vector<double[]>>(maxSize){};
        for (int i = 0; i < maxSize; i++) {
            chunk.add(generateMatrix(maxSize, maxSize));
        }
        return chunk;
    }
    public static String export(Vector matrix, String[] blur){
        Vector<Vector<double[]>> chunk = matrix;
        String toExport = "";
        for (int i = 0; i < chunk.size(); i++) {
            for (int j = 0; j < chunk.size(); j++) {
                int id = (int) (chunk.get(i).get(j)[0] * blur.length);
                toExport += (blur[id] + blur[id] + blur[id]);
            }
            toExport += "\n";
        }
        return toExport;
    }
}