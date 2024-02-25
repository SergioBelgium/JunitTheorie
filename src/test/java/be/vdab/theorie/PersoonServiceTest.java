package be.vdab.theorie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersoonServiceTest {
    @Mock
    private PersoonRepository repository;
    private PersoonService service;

   @BeforeEach
    public void beforeEach() {
        service = new PersoonService(repository);   //aki ya vemos la "dependency injection"!!

    }
    @Test
    public void deWeddeStandaardAfwijkingIs2() {                         //con entrenamiento de MOCK!!
       when(repository.findAllWeddes()).thenReturn(Stream.of(2, 4, 4, 4, 5, 5, 7, 9)
               .map(getal -> BigDecimal.valueOf(getal))
               .toList());
        assertThat(service.standaardAfwijkingWeddes()).isEqualByComparingTo("2");
        verify(repository).findAllWeddes();
    }
}