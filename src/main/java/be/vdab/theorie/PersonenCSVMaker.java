package be.vdab.theorie;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class PersonenCSVMaker {
    private final static String[] VOORNAMEN =
            { "Arthur", "Noa", "Adam", "Louis", "Liam", "Emma", "Olivia", "Louise",
                    "Mila", "Alice" };
    private final static String[] FAMILIENAMEN =
            { "Peeters", "Janssens", "Maes", "Jacobs", "Mertens", "Willems", "Claes",
                    "Goossens", "Wouters", "Desmet" };
    private final static Path BESTAND_PATH = Path.of("/data/personen.csv");
    private final static Path DIRECTORY_PATH = BESTAND_PATH.getParent();
    public static void main(String[] args) throws IOException {
        if (!Files.isDirectory(DIRECTORY_PATH)) {
            Files.createDirectory(DIRECTORY_PATH);
        }
        var random = new Random();
        try (var writer = new PrintWriter(Files.newBufferedWriter(BESTAND_PATH))) {
            for (var i = 1; i <= 10_000_000; i++) {
                writer.print(i);
                writer.print(',');
                writer.print(VOORNAMEN[random.nextInt(VOORNAMEN.length)]);
                writer.print(',');
                writer.print(FAMILIENAMEN[random.nextInt(FAMILIENAMEN.length)]);
                writer.print(',');
                writer.print(2000 + random.nextInt(3000));
                writer.print('.');
                writer.println(random.nextInt(100));
                System.out.printf("%,d\n", i);
            }
        }
        System.out.println("Bestand gemaakt");
    }

}
