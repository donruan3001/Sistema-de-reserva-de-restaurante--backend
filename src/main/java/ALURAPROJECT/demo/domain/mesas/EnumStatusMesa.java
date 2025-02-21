package ALURAPROJECT.demo.domain.mesas;



public enum EnumStatusMesa {
DISPONIVEL("disponivel"),
INDISPONIVEL("indisponivel"),
INATIVO("inativo");


private String status;
EnumStatusMesa(String status){
    this.status = status;
    }
    public String getStatus() {
        return status;}
}
