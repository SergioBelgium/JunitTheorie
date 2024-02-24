package be.vdab.theorie;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class PersoonService {
   // private final PersoonRepository repository = new PersoonRepository();  //esto desaparecera con la inyeccion de depencias!
    private final PersoonRepository repository;
    PersoonService(PersoonRepository repository){
        this.repository=repository;
    }
    public BigDecimal standaardAfwijkingWeddes() {
        var weddes = repository.findAllWeddes();
        var totaal = weddes.stream()
        .reduce(BigDecimal.ZERO, (vorigTotaal, huidigeWedde) ->
                vorigTotaal.add(huidigeWedde));
        var gemiddelde =
                totaal.divide(BigDecimal.valueOf(weddes.size()), 2, RoundingMode.HALF_UP);
        totaal = weddes.stream()
                .map(wedde -> wedde.subtract(gemiddelde))
                .map(verschil -> verschil.pow(2))
                .reduce(BigDecimal.ZERO, (vorigTotaal, huidigKwadraat) ->
                        vorigTotaal.add(huidigKwadraat));
        var variantie =
                totaal.divide(BigDecimal.valueOf(weddes.size()), 2, RoundingMode.HALF_UP);
        var standaardAfwijking =
                variantie.sqrt(new MathContext(10, RoundingMode.HALF_UP));
        return standaardAfwijking;

    }
}
