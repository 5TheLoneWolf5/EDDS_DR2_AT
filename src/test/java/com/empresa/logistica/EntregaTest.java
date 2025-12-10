package com.empresa.logistica;

import com.empresa.logistica.domain.Entrega;
import com.empresa.logistica.domain.TipoFrete;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EntregaTest {

    @Test
    public void criarEntregaValida() {
        Entrega e = new Entrega("Rua X", 5.0, TipoFrete.PAD, "João");
        Assertions.assertEquals("Rua X", e.getEndereco());
    }

    @Test
    public void erroPesoInvalido() {
        Assertions.assertThrows(RuntimeException.class, () ->
            new Entrega("Rua Y", -2, TipoFrete.EXP, "Maria"));
    }
}
