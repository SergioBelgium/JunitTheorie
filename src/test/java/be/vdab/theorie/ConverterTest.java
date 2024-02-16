package be.vdab.theorie;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;


import static org.assertj.core.api.Assertions.assertThat;

public class ConverterTest {
    @Test
    @DisplayName("Één inch is 2.54 centimeters")
    void eenInchIs2Komma54Centimeters(){
        assertThat(new Converter().inchesNaarCentimeters(BigDecimal.ONE)).isEqualByComparingTo("2.54");
    }
}
