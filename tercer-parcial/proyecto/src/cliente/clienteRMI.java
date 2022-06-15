/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cliente;

import interfacee.chatServidor;
import javax.swing.JOptionPane;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class clienteRMI {

    public static void main(String[] args) {
        // TODO code application logic here}
        try{
            String nombre = JOptionPane.showInputDialog("Ingresa tu nombre");
            String nom = nombre;
            
            Registry rmii = LocateRegistry.getRegistry("localhost", 3031);

            chatServidor servidor = (chatServidor) rmii.lookup("CALCULADORA");
            Interfaz v = new Interfaz(nom,servidor);
            implementacionClienteChat x=new implementacionClienteChat(nom, servidor,v);
            Thread nuevo=new Thread(x);
            nuevo.start();




            
            
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            
        }
    }
    
}
