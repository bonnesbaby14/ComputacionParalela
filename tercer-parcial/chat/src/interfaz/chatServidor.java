/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Lenovo
 */
public interface chatServidor extends Remote {

    void registro(chatCliente cliente) throws RemoteException;
    void mensaje(String mensaje) throws RemoteException;
}