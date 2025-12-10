package com.empresa.logistica.frete;

import com.empresa.logistica.domain.Entrega;

public interface CalculadoraFrete {
    double calcular(Entrega entrega);
}
