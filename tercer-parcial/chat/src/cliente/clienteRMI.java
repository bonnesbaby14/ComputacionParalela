
package cliente;

import interfaz.chatServidor;
import javax.swing.JOptionPane;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class clienteRMI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here}
        try{
            String nombre = JOptionPane.showInputDialog("Ingresa tu nombre");
            String nom = nombre;

            Registry rmii = LocateRegistry.getRegistry("localhost", 3030);

            chatServidor servidor = (chatServidor) rmii.lookup("Chat");
            new Thread(new implementacionClienteChat(nom, servidor)).start();


        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }

}