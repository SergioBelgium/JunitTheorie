package be.vdab.theorie;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PersoonRepository {
    /*chtagpt:En resumen, Files.readAllLines() lee todas las líneas de un archivo en memoria como una lista de cadenas,
     mientras que Files.lines() proporciona un flujo de líneas que permite procesar eficientemente un archivo línea por línea.
      Dependiendo de tus necesidades y del tamaño del archivo, puedes elegir el método más adecuado para tu situación.

     */
    List<BigDecimal> findAllWeddes() {
        try (var stream = Files.lines(Path.of("/data/personen.csv"))) { //el metodo .line() proporciona un "stream"
            return stream
                     // regel splitsen in onderdelen, 4° onderdeel omzetten naar BigDecimal:
                    .map(regel -> new BigDecimal(regel.split(",")[3])).toList();
        } catch (IOException ex) {
            throw new RepositoryException(ex);
        }
    }

}
