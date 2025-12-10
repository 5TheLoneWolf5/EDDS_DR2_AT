package com.empresa.logistica.frete;

import com.empresa.logistica.domain.TipoFrete;
import com.empresa.logistica.domain.exception.FreteNaoSuportadoException;

import java.util.Map;

public class FabricaFrete {

    private static final Map<TipoFrete, CalculadoraFrete> MAPA = Map.of(
        TipoFrete.EXP, new FreteExpresso(),
        TipoFrete.PAD, new FretePadrao(),
        TipoFrete.ECO, new FreteEconomico()
    );

    public static CalculadoraFrete obter(TipoFrete tipo) {
        if (!MAPA.containsKey(tipo))
            throw new FreteNaoSuportadoException("Frete não suportado: " + tipo);

        return MAPA.get(tipo);
    }
}
