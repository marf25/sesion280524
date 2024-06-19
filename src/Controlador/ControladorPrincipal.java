package Controlador;

import Modelo.ModeloPrincipal;
import Vista.VistaProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControladorPrincipal implements ActionListener,MouseListener{
    ModeloPrincipal modelo;

    public ControladorPrincipal(ModeloPrincipal modelo) {
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getComponent().equals(modelo.getVista().mntmProductos)){
            VistaProductos vproductos = new VistaProductos();
            vproductos.setVisible(true);
            modelo.getVista().dispose();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    
}
