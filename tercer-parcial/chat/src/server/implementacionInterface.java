/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import interfaz.interfaceRMI;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class implementacionInterface extends UnicastRemoteObject implements interfaceRMI {

    public implementacionInterface() throws RemoteException {
        super();
    }

    public String nombre(String nombre) throws RemoteException {
        return nombre;
    }
}

