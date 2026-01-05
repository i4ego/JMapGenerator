import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        String[] blur = new String[]{"██", "▓▓", "▒▒", "░░"};
        Vector<Vector<double[]>> chunk = MapGenerator.generateChunk(8);
        System.out.println(MapGenerator.export(chunk, blur));
    }
}
