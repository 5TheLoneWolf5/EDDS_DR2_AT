package com.empresa.logistica;

import com.empresa.logistica.domain.Entrega;
import com.empresa.logistica.domain.TipoFrete;
import com.empresa.logistica.frete.FabricaFrete;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FreteTest {

    @Test
    public void calculaFretePadrao() {
        Entrega e = new Entrega("Rua A", 10, TipoFrete.PAD, "Carlos");
        double valor = FabricaFrete.obter(TipoFrete.PAD).calcular(e);
        Assertions.assertEquals(12.0, valor);
    }
}
