package be.vdab.theorie;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class JaarTest {
    @Test
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

}
