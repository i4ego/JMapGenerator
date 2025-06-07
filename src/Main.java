import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        String[] blur = new String[]{"█", "▓", "▒", "░"};
        Vector chunk = MapGenerator.generateChunk(16);
        System.out.println(MapGenerator.export(chunk, blur));
    }
}
