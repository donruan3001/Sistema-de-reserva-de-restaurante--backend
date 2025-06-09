package ALURAPROJECT.demo.domain.mesas.Dto;

import ALURAPROJECT.demo.domain.mesas.EnumStatusMesa;
import ALURAPROJECT.demo.domain.mesas.Mesa;

public record ListagemChairDto(Long id,String nome,int capacidade,EnumStatusMesa status) {

    public ListagemChairDto(Mesa mesa) {
        this(mesa.getId(), mesa.getNome(),mesa.getCapacidade(),mesa.getStatus());
    }

}
