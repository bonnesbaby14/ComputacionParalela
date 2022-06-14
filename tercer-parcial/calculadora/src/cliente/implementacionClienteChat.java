/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente;

import interfacee.chatCliente;
import interfacee.chatServidor;
import java.util.Scanner;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class implementacionClienteChat extends UnicastRemoteObject implements chatCliente,  Runnable {

    chatServidor servidor;
    public String nombre = null;
    
    implementacionClienteChat(String nombre, chatServidor servidor) throws RemoteException{
        this.nombre = nombre;
        this.servidor = servidor;
        servidor.registro(this);
    }
    
    @Override
    public void mensajeCliente(String mensaje) throws RemoteException {
        System.out.println("RESULTADO"+mensaje);
    }
    
    @Override
    public void run() {
        Scanner s = new Scanner(System.in);
        String mensaje, operacion;


        
        while(true){
            System.out.println("DIGITA UN VALOR: ");
            mensaje = s.nextLine();
            try{
                System.out.println(nombre+" DIGITO: "+mensaje);
                
                System.out.println("OPERACION: [+] [-] [*] [/] ");
                operacion = s.nextLine();
                
                servidor.mensaje(mensaje,nombre,operacion);
                
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    
    
}
