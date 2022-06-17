package seguridad.controlador;

public class clsPerfil {
    private int iper_id;
    private String sper_nombre;
    private String sper_estado;

    public clsPerfil() {
    }

    public clsPerfil(int iid) {
        this.iper_id = iid;
    }
    
    public clsPerfil(String snombre, String sestado) {
        this.sper_nombre = snombre;
        this.sper_estado = sestado;
    }
    
    public clsPerfil(int iid, String snombre, String sestado) {
        this.iper_id = iid;
        this.sper_nombre = snombre;
        this.sper_estado = sestado;
    }
    

    public int getId_perfil() {
        return iper_id;
    }

    public void setId_perfil(int iid) {
        this.iper_id = iid;
    }

    public String getperfil() {
        return sper_nombre;
    }

    public void setnombreperfil(String snombre) {
        this.sper_nombre = snombre;
    }

    public String getnombreperfil() {
        return sper_estado;
    }

    public void setEstado(String sestado) {
        this.sper_estado = sestado;
    }
    
    public String getEstado() {
        return sper_estado;
    }

    @Override
    public String toString() {
        return "tbl_perfil{" + "per_idPerfil=" + iper_id + ", per_NombrePerfil=" + sper_nombre + ", per_EstatusPerfil=" + sper_estado + '}';
    }
    
    
}
