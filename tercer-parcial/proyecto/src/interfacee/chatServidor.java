/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfacee;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface chatServidor extends Remote {
    
    void registro(chatCliente cliente) throws RemoteException;
    void mensaje(String arreglo,String nombre) throws RemoteException;
}
