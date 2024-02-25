package be.vdab.theorie;

public class StandaardAfwijking { //esto seria una buena forma de comprobar si el metodo codificado es correcto o funciona segun lo esperado!
    public static void main(String[] args) {
        try {

            var service = new PersoonService(new PersoonRepository());
            System.out.println(service.standaardAfwijkingWeddes());
        } catch (RepositoryException ex) {
            System.err.println("Kan personen niet lezen.");
            ex.printStackTrace(System.err);
        }
    }
}
