package Controlador;

import Modelo.ModeloUsuario;
import Vista.VistaPrincipal;
import Vista.registrousuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ControladorUsuario implements ActionListener {

    // Lista estática que contiene todos los usuarios registrados
    private static ArrayList<ModeloUsuario> baseUsuarios = new ArrayList<>();
    
    // Instancia de ModeloUsuario que representa el modelo asociado con este controlador
    private ModeloUsuario modelo;

    // Constructor de la clase ControladorUsuario que recibe un modelo como parámetro
    public ControladorUsuario(ModeloUsuario modelo) {
        // Asigna el modelo proporcionado al atributo modelo
        this.modelo = modelo;
        // Añade un usuario predeterminado a la lista de usuarios
        baseUsuarios.add(new ModeloUsuario("mpazl", "12345"));
    }

    // Método que valida si las credenciales del usuario son correctas
    public boolean validarUsuario() {
        // Obtiene el nombre de usuario ingresado en la vista asociada al modelo
        String inputUser = modelo.getVista().txtUsuario.getText();
        // Obtiene la contraseña ingresada en la vista asociada al modelo
        String inputPass = String.valueOf(modelo.getVista().txtPassword.getPassword());
        
        // Recorre la lista de usuarios registrados
        for (ModeloUsuario usuario : baseUsuarios) {
            // Comprueba si el nombre de usuario y la contraseña ingresados coinciden con los de algún usuario registrado
            if (usuario.getUsuario().equals(inputUser) && usuario.getPassword().equals(inputPass)) {
                // Si coinciden, retorna true
                return true;
            }
        }
        // Si no hay coincidencias, retorna false
        return false;
    }

    // Método que registra un nuevo usuario
    public void registrarUsuario() {
        // Crea una nueva instancia de la vista de registro de usuario
        registrousuario r = new registrousuario();
        // Hace visible la vista de registro
        r.setVisible(true);
        
        // Añade un listener al botón de guardar de la vista de registro
        r.btnguardar.addActionListener(e -> {
            // Obtiene el nombre de usuario ingresado en la vista de registro
            String newUser = r.txtusuario.getText();
            // Obtiene la contraseña ingresada en la vista de registro
            String newPass = r.txtcontraseña.getText();
            // Obtiene el nombre y apellido ingresados en la vista de registro (aunque parece estar mal nombrado)
            String newPassConfirm = r.txtnombreapellido.getText();  // Este nombre de variable no es claro

            // Recorre la lista de usuarios registrados
            for (ModeloUsuario usuario : baseUsuarios) {
                // Comprueba si el nombre de usuario ya existe en la lista de usuarios registrados
                if (usuario.getUsuario().equals(newUser)) {
                    // Si el usuario ya existe, muestra un mensaje de error
                    JOptionPane.showMessageDialog(null, "El usuario ya existe");
                    return;
                }
            }
            // Si el usuario no existe, lo añade a la lista de usuarios registrados
            baseUsuarios.add(new ModeloUsuario(newUser, newPass));
            // Muestra un mensaje de éxito
            JOptionPane.showMessageDialog(null, "Usuario registrado con éxito");
            // Cierra la vista de registro
            r.dispose();
        });
    }

    // Método que maneja los eventos de la interfaz de usuario
    @Override
    public void actionPerformed(ActionEvent e) {
        // Comprueba si el evento fue generado por el botón de ingresar de la vista asociada al modelo
        if (e.getSource().equals(modelo.getVista().btnIngresar)) {
            // Si el botón de ingresar fue presionado, llama al método validarUsuario
            if (validarUsuario()) {
                // Si la validación es exitosa, crea una nueva instancia de la vista principal
                VistaPrincipal vprincipal = new VistaPrincipal();
                // Hace visible la vista principal
                vprincipal.setVisible(true);
                // Cierra la vista actual
                modelo.getVista().dispose();
            } else {
                // Si la validación falla, muestra un mensaje de error
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } 
        // Comprueba si el evento fue generado por el botón de registrar de la vista asociada al modelo
        else if (e.getSource().equals(modelo.getVista().registrar)) {
            // Si el botón de registrar fue presionado, llama al método registrarUsuario
            registrarUsuario();
        }
    }
}
