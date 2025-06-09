package ALURAPROJECT.demo.domain.mesas.Dto;

import ALURAPROJECT.demo.domain.mesas.EnumStatusMesa;

public record InserirChairDto(String nome,int capacidade,EnumStatusMesa status) {

}
