package be.vdab.theorie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;


class RekeningTest {
    private Rekening rekening;
    @BeforeEach
    void beforeEach(){
        rekening=new Rekening();
    }
    @Test
    @DisplayName("het Saldo van een niuwe rekening is 0")
    void saldoVanEenNiuweRekeningIs0() {

        assertThat(rekening.getSaldo()).isZero();
    }

    @Test
    @DisplayName("nadat je stort 10 euro is het saldo 10")
    void nadatJe10euroStortIsHetSaldo10() {

        rekening.stort(BigDecimal.valueOf(10));
        assertThat(rekening.getSaldo()).isEqualByComparingTo("10");
    }

    @Test
    @DisplayName("nadat je stort 10 euro en nog 1 euro is het saldo 11")
    void nadatJe10en1euroStortIsHetSaldo11() {

        rekening.stort(BigDecimal.valueOf(10));
        rekening.stort(BigDecimal.ONE);
        assertThat(rekening.getSaldo()).isEqualByComparingTo("11");
    }
    @Test
    @DisplayName("het gestorte bedrag mag niet nul zijn")
    void hetGestorteBedragMagNietNulZijn(){
        assertThatIllegalArgumentException().isThrownBy(()->rekening.stort(BigDecimal.ZERO));
    }
    @Test
    void hetGestortBedragMagNietNegatiefZijn() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> rekening.stort(BigDecimal.valueOf(-1)));
    }
    @Test
    void stortMetNullKanNiet() {
        assertThatNullPointerException().isThrownBy(() -> rekening.stort(null));
    }
    private static final BigDecimal TWEE = BigDecimal.valueOf(2);
    @Test
    void eenNieuweRekeningHeeftGeenStortingen() {
        assertThat(rekening.getStortingen()).isEmpty();
    }
    @Test
    void nadatJe10€StortIsErEenStortingVan10€() {
        rekening.stort(BigDecimal.TEN);
        assertThat(rekening.getStortingen()).containsOnly(BigDecimal.TEN);
    }
    @Test
    void nadatJe10€En1€StortZijnDeStortingen10€En1€() {
        rekening.stort(BigDecimal.TEN);
        rekening.stort(BigDecimal.ONE);
        assertThat(rekening.getStortingen())
                .containsExactly(BigDecimal.TEN, BigDecimal.ONE);
    }
    @Test
    void nadatJe10€En1€En2€StortZijnDeStortingenGesorteerd1€En2€En10€() {
        rekening.stort(BigDecimal.TEN);
        rekening.stort(BigDecimal.ONE);
        rekening.stort(TWEE);
        assertThat(rekening.getStortingenGesorteerd()).isSorted()
.containsExactly(BigDecimal.ONE, TWEE, BigDecimal.TEN);
    }






}