package be.vdab.theorie;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class JaarTest {
    @Test
    @DisplayName("Een jaar deelbaar door 400 is een schrikkeljaar")
    void eenJaarDeelbaarDoor400IsEenSchrikkeljaar(){
        var jaar=new Jaar(2000);
        assertThat(jaar.isSchrikkeljaar()).isTrue();


    }
    @Test
    void eenJaarDeelbaarDoor100IsGeenSchrikkeljaar(){
        assertThat(new Jaar(1900).isSchrikkeljaar()).isFalse();
    }
    @Test
    void eenJaarDeelbaarDoor4IsEenSchrikkeljaar(){
        assertThat(new Jaar(2012).isSchrikkeljaar()).isTrue();
    }
    @Test
    void eenJaarDieNietDeelbaarDoor4IsGeenSchrikkeljaar(){
        assertThat(new Jaar(2015).isSchrikkeljaar()).isFalse();
    }
    @Test
    void toStringGeeftHetJaarAlsTekst(){
        var jaar=new Jaar(2024);
      //  assertThat(jaar.toString()).isEqualTo("2024");
        assertThat(jaar).hasToString("2024");

    }
    @Test
    @DisplayName("Jaren met hetzelfde jaartal zijn gelijk")
    void jarenMetHetzelfdeJaartalZijnGelijk(){
        assertThat(new Jaar(2015)).isEqualTo(new Jaar(2015));
    }

    @Test
    @DisplayName("Jaren met een verschillend jaartal zijn versillend")
    void jarenMetEenVerschillendJaartalZijnVerschillend() {
        assertThat(new Jaar(2015)).isNotEqualTo(new Jaar(2016));

    }
    @Test
    @DisplayName("De hasCode van gelijke Jaren is gelijk")
    void deHashCodeVanGelijkeJarenIsGelijk(){
        assertThat(new Jaar(2015)).hasSameHashCodeAs(new Jaar(2015));
    }
}
