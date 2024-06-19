package Controlador;

import Modelo.ModeloProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControladorProductos implements ActionListener {

    ModeloProductos modelo;
    ArrayList<ModeloProductos> baseDatos = new ArrayList<>();

    public ControladorProductos(ModeloProductos modelo) {
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(modelo.getVista().btnIngresar.getActionCommand())) {
            agregarProducto();
        } else if (e.getActionCommand().equals(modelo.getVista().btnBuscar.getActionCommand())) {
            buscarProducto();
        }
    }

    public void agregarProducto() {
        try {
            ModeloProductos producto = new ModeloProductos();
            producto.setCodigo(Integer.parseInt(modelo.getVista().txtCodigoA.getText()));
            producto.setNombre(modelo.getVista().txtNombreA.getText());
            producto.setDescripcion(modelo.getVista().txtDescripcionA.getText());
            producto.setPrecio_costo(Double.parseDouble(modelo.getVista().txtCostoA.getText()));
            producto.setPrecio_venta(Double.parseDouble(modelo.getVista().txtVentaA.getText()));
            baseDatos.add(producto);
            mostrarMensaje("Producto agregado con exito", "Agregar productos", JOptionPane.INFORMATION_MESSAGE);
            limpiarTextos();
        } catch (NumberFormatException ex) {
            mostrarMensaje("Solo se permiten numeros enteros en el codigo o decimales en los precios", "Solamente numeros", JOptionPane.ERROR_MESSAGE);
            modelo.getVista().txtCodigoA.setText("0");
            modelo.getVista().txtCostoA.setText("0");
            modelo.getVista().txtVentaA.setText("0");
        }

    }

    public void buscarProducto() {
        for (int i = 0; i < baseDatos.size(); i++) {
            if (baseDatos.get(i).getCodigo() == Integer.parseInt(modelo.getVista().txtCodigoB.getText())) {
                modelo.getVista().txtNombreB.setText(baseDatos.get(i).getNombre());
                modelo.getVista().txtDescripcionB.setText(baseDatos.get(i).getDescripcion());
                modelo.getVista().txtCostoB.setText(String.valueOf(baseDatos.get(i).getPrecio_costo()));
                modelo.getVista().txtVentaB.setText(String.valueOf(baseDatos.get(i).getPrecio_venta()));
            }
            modelo.getVista().txtNombreB.setEditable(true);
        }
    }

    public void limpiarTextos() {
        modelo.getVista().txtCodigoA.setText("");
        modelo.getVista().txtNombreA.setText("");
        modelo.getVista().txtDescripcionA.setText("");
        modelo.getVista().txtCostoA.setText("");
        modelo.getVista().txtVentaA.setText("");
    }
    
    public void mostrarMensaje(String mensaje, String titulo, int tipoMensaje){
        JOptionPane.showMessageDialog(null, mensaje, titulo, tipoMensaje);
    }

}
