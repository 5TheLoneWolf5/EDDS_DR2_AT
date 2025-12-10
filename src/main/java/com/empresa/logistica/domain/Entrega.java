package com.empresa.logistica.domain;

import com.empresa.logistica.domain.exception.ValidacaoException;

public final class Entrega {
    private final String endereco;
    private final double peso;
    private final TipoFrete tipoFrete;
    private final String destinatario;

    public Entrega(String endereco, double peso, TipoFrete tipoFrete, String destinatario) {
        if (endereco == null || endereco.isBlank())
            throw new ValidacaoException("Endereço inválido.");

        if (peso <= 0)
            throw new ValidacaoException("Peso deve ser maior que zero.");

        if (tipoFrete == null)
            throw new ValidacaoException("Tipo de frete não pode ser nulo.");

        if (destinatario == null || destinatario.isBlank())
            throw new ValidacaoException("Destinatário inválido.");

        this.endereco = endereco;
        this.peso = peso;
        this.tipoFrete = tipoFrete;
        this.destinatario = destinatario;
    }

    public String getEndereco() { return endereco; }
    public double getPeso() { return peso; }
    public TipoFrete getTipoFrete() { return tipoFrete; }
    public String getDestinatario() { return destinatario; }
}
