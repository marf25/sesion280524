package Modelo;

import Vista.VistaProductos;

public class ModeloProductos {
    private int codigo;
    private String nombre;
    private String descripcion;
    private double precio_costo;
    private double precio_venta;
    private VistaProductos vista;
    
    public ModeloProductos(){
        
    }
    
    public ModeloProductos(VistaProductos vista){
        this.vista = vista;
    }

    public VistaProductos getVista() {
        return vista;
    }

    public void setVista(VistaProductos vista) {
        this.vista = vista;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio_costo() {
        return precio_costo;
    }

    public void setPrecio_costo(double precio_costo) {
        this.precio_costo = precio_costo;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }
    
    
}
