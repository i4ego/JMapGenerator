import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            help();
        }
        else if (args[0]=="help") {help();}
        else if (args.length == 1) {
            try {
                int size = Integer.parseInt(args[0]);
                Vector<Vector<double[]>> chunk = MapGenerator.generateChunk(size);
                System.out.println(MapGenerator.export(chunk, MapGenerator.blockblur));
                System.exit(0);
            }
            catch (Exception e) {
                System.out.println("Invalid arguments!");
                System.exit(1);
            }
        }
        else {
            try {
                int sizeX = Integer.parseInt(args[0]);
                int sizeY = Integer.parseInt(args[1]);
                Vector<Vector<double[]>> chunk = MapGenerator.generateChunk(sizeX, sizeY);
                System.out.println(MapGenerator.export(chunk, MapGenerator.blockblur));
                System.exit(0);
            }
            catch (Exception e) {
                System.out.println("Invalid arguments!");
                System.exit(1);
            }
        }
        System.exit(0);
    }
    public static void help() {
        System.out.println("Usage:\n   .. <x> <y>\n   .. <size>\nExamples:\n   .. 8 16\n   .. 16");
    }
}