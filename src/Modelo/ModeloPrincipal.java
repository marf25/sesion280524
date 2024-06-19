package Modelo;

import Vista.VistaPrincipal;

public class ModeloPrincipal {
    private VistaPrincipal vista;

    public ModeloPrincipal() {
    }

    public ModeloPrincipal(VistaPrincipal vista) {
        this.vista = vista;
    }

    public VistaPrincipal getVista() {
        return vista;
    }

    public void setVista(VistaPrincipal vista) {
        this.vista = vista;
    }
    
    
}
