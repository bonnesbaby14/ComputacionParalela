/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente;

import interfacee.chatCliente;
import interfacee.chatServidor;

import javax.swing.*;
import java.util.Scanner;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class implementacionClienteChat extends UnicastRemoteObject implements chatCliente,  Runnable {

    chatServidor servidor;
    public String nombre = null;
    Interfaz v;
    
    implementacionClienteChat(String nombre, chatServidor servidor, Interfaz v) throws RemoteException{
        this.nombre = nombre;
        this.servidor = servidor;
        this.v=v;
        servidor.registro(this);
    }
    
    @Override
    public void mensajeCliente(String mensaje) throws RemoteException {
        String[] respuesta=mensaje.split("!");
        if(respuesta[2].equals("fork")){
            v.etiquetaForkJoin.setText("");
            v.etiquetaTiempo2.setText("");
            v.etiquetaForkJoin.setText(respuesta[0]);
            v.etiquetaTiempo2.setText(respuesta[1]);

        }else if(respuesta[2].equals("exe")){
            v.etiquetaExecutorService.setText("");
            v.etiquetaTiempo3.setText("");
            v.etiquetaExecutorService.setText(respuesta[0]);
            v.etiquetaTiempo3.setText(respuesta[1]);
        }else if(respuesta[2].equals("secu")){
            v.etiquetaSecuencial.setText("");
            v.etiquetaTiempo1.setText("");
            v.etiquetaSecuencial.setText(respuesta[0]);
            v.etiquetaTiempo1.setText(respuesta[1]);
        }

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
                
                servidor.mensaje("",nombre);
                
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    
    
}
