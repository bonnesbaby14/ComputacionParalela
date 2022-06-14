/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;

import interfacee.chatCliente;
import interfacee.chatServidor;
import java.util.ArrayList;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;


public class implementacionChat extends UnicastRemoteObject implements chatServidor {

    public ArrayList<chatCliente> clientes;
    public int cont = 0, num1 = 0, num2 = 0;

    public implementacionChat() throws RemoteException {
        clientes = new ArrayList<chatCliente>();
    }

    public void mensaje(String mensaje, String nombre, String operacion) throws RemoteException {
        int a = 0;
        Scanner s = new Scanner(System.in);
        cont++;

        System.out.println(nombre + " : " + mensaje);

        if (cont == 1) {
            num1 = Integer.valueOf(mensaje);
        } else if (cont == 2) {
            num2 = Integer.valueOf(mensaje);
            switch (operacion){
                case "+":
                    a = 0;
                    while (a < clientes.size()) {
                        clientes.get(a).mensajeCliente(String.valueOf(" suma " + num1 + "+" + num2 + ": " + (num1 + num2)));
                        a++;
                    }
                    break;
                case "-":
                    a = 0;
                    while (a < clientes.size()) {
                        clientes.get(a).mensajeCliente(String.valueOf(" resta " + num1 + "-" + num2 + ": " + (num1 - num2)));
                        a++;
                    }
                    break;

                case "*":
                    a = 0;
                    while (a < clientes.size()) {
                        clientes.get(a).mensajeCliente(String.valueOf(" multiplicacion " + num1 + "*" + num2 + ": " + (num1 * num2)));
                        a++;
                    }
                    break;

                case "/":
                    a = 0;
                    while (a < clientes.size()) {
                        clientes.get(a).mensajeCliente(String.valueOf(" division: " + num1 + "/" + num2 + ": " + (num1 / num2)));
                        a++;
                    }
                    break;


default:
    a = 0;
    while (a < clientes.size()) {
        clientes.get(a).mensajeCliente(String.valueOf("DIGITA UN VALOR VALIDO"));
        a++;
    }
    break;


            }


            
             cont = 0;


        }
    }

    public void registro(chatCliente cliente) throws RemoteException {
        this.clientes.add(cliente);
    }

}
