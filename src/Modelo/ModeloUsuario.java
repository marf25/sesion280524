package Modelo;

import Vista.VistaLogin;
;

public class ModeloUsuario {
    private String usuario;
    private String password;
    private String correo;
    private VistaLogin vista;
    
    public ModeloUsuario(){
        
    }

    public ModeloUsuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }
    
    
    public ModeloUsuario(VistaLogin vista){
        this.vista = vista;
    }

    public VistaLogin getVista() {
        return vista;
    }

    public void setVista(VistaLogin vista) {
        this.vista = vista;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
    
}