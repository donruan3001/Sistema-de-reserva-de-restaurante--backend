package ALURAPROJECT.demo.classes.User;

public enum EnumRole {
    CLIENT("user"),
    ADMIN("admin");

    private String role;

    EnumRole(String role){
        this.role=role;
    }
    public String getRole(){
        return role;
    }

    
}
