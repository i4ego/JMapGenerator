import java.util.Random;
import java.util.Vector;

public class MapGenerator {
    public static String[] blockblur = new String[]{"██", "▓▓", "▒▒", "░░"};
    public static String[] asciiblur = new String[]{"@@", "&&", "||", ".."};

    public static Vector<double[]> generateMatrix (int maxSize) {
        Vector<double[]> matrix = new Vector<>(maxSize);

        Random r = new Random();

        for (int i = 0; i < maxSize; i++) {
            double[] k = new double[maxSize];
            for (int j = 0; j < maxSize; j++) {
                k[j] = r.nextDouble();
            }
            matrix.add(k);
        }
        return matrix;
    }

    public static Vector<Vector<double[]>> generateChunk(int maxSize) {

        Vector<Vector<double[]>> chunk = new Vector<>(maxSize){};
        for (int i = 0; i < maxSize; i++) {
            chunk.add(generateMatrix(maxSize));
        }
        return chunk;
    }

    public static Vector<Vector<double[]>> generateChunk(int x, int y) {

        Vector<Vector<double[]>> chunk = new Vector<>(x){};
        for (int i = 0; i < x; i++) {
            chunk.add(generateMatrix(y));
        }
        return chunk;
    }

    public static String export(Vector<Vector<double[]>> matrix, String[] blur){
        StringBuilder toExport = new StringBuilder();
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                int id = (int) (matrix.get(i).get(j)[0] * blur.length);
                toExport.append(blur[id]);
            }
            toExport.append("\n");
        }
        return toExport.toString();
    }
}
