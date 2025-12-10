package com.empresa.logistica.frete;

import com.empresa.logistica.domain.Entrega;

public class FreteExpresso implements CalculadoraFrete {

    @Override
    public double calcular(Entrega entrega) {
        return entrega.getPeso() * 1.5 + 10;
    }
}
