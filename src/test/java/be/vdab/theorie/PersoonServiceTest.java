package be.vdab.theorie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class PersoonServiceTest {
    private PersoonService service;

   @BeforeEach
    public void beforeEach() {
        service = new PersoonService(new PersoonRepositoryStub());   //aki ya vemos la "dependency injection"!!

    }
    @Test
    public void deWeddeStandaardAfwijkingIsPositief() {
        assertThat(service.standaardAfwijkingWeddes()).isEqualByComparingTo("2");
    }
}