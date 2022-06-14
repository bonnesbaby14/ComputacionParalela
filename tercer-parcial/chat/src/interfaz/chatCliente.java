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
public interface chatCliente extends Remote {
    void mensajeCliente(String mensaje) throws RemoteException;
}
