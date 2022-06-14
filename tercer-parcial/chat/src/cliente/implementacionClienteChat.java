/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente;

import interfaz.chatCliente;
import interfaz.chatServidor;
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
        System.out.println(mensaje);
    }
    
    @Override
    public void run() {
        Scanner s = new Scanner(System.in);
        String mensaje, opc;
        int cont = 0;
        int[ ] numeros = new int[2];
        
        while(true){
            mensaje = s.nextLine();
            try{
                servidor.mensaje(nombre + " : "+mensaje);
                
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    
    
}
