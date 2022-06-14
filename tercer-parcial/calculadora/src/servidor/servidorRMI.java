package servidor;

import servidor.implementacionChat;
import java.rmi.registry.Registry;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;



public class servidorRMI {


    public static void main(String[] args) {
     try{
       Registry rmi = LocateRegistry.createRegistry(3030);
       rmi.rebind("CALCULADORA", (Remote) new implementacionChat());

        System.out.println("Calculadora corriendo");
        
     } catch (Exception e){
         e.printStackTrace();
     }
    }
    
}
