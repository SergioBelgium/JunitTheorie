package be.vdab.theorie;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RekeningTest {
    @Test
    @DisplayName("het Saldo van een niuwe rekening is 0")
    void saldoVanEenNiuweRekeningIs0() {
        var rekening=new Rekening();
        assertThat(rekening.getSaldo()).isZero();
    }

    @Test
    @DisplayName("nadat je stort 10 euro is het saldo 10")
    void nadatJe10euroStortIsHetSaldo10() {
        var rekening=new Rekening();
        rekening.stort(BigDecimal.valueOf(10));
        assertThat(rekening.getSaldo()).isEqualByComparingTo("10");
    }

    @Test
    @DisplayName("nadat je stort 10 euro en nog 1 euro is het saldo 11")
    void nadatJe10en1euroStortIsHetSaldo11() {
        var rekening=new Rekening();
        rekening.stort(BigDecimal.valueOf(10));
        rekening.stort(BigDecimal.ONE);
        assertThat(rekening.getSaldo()).isEqualByComparingTo("11");
    }


}