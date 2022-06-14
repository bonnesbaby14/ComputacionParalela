package server;

import server.implementacionChat;
import java.rmi.registry.Registry;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;


public class servidorRMI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     try{
       Registry rmi = LocateRegistry.createRegistry(3030);
       rmi.rebind("Chat", (Remote) new implementacionChat());
       //rmi.rebind("Chat", (Remote) new implementacionChat()));
        System.out.println("Servidor Activo");
        
     } catch (Exception e){
         e.printStackTrace();
     }
    }
    
}
