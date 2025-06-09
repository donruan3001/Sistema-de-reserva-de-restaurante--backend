package ALURAPROJECT.demo.domain.mesas.Dto;

import ALURAPROJECT.demo.domain.mesas.EnumStatusMesa;

public record UpdateChairDto(
String nome,
int capacidade,
EnumStatusMesa status) {


    
}