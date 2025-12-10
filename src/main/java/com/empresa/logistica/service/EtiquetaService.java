package com.empresa.logistica.service;

import com.empresa.logistica.domain.Entrega;
import com.empresa.logistica.frete.CalculadoraFrete;

public class EtiquetaService {

    private final CalculadoraFrete calculadora;

    public EtiquetaService(CalculadoraFrete calculadora) {
        this.calculadora = calculadora;
    }

    public String gerarEtiqueta(Entrega entrega) {
        return "Destinatário: " + entrega.getDestinatario()
            + "\nEndereço: " + entrega.getEndereco()
            + "\nValor do Frete: R$" + String.format("%.2f", calculadora.calcular(entrega));
    }

    public String gerarResumo(Entrega entrega) {
        return "Entrega para " + entrega.getDestinatario()
            + " usando frete " + entrega.getTipoFrete()
            + " no valor de R$" + String.format("%.2f", calculadora.calcular(entrega));
    }
}
