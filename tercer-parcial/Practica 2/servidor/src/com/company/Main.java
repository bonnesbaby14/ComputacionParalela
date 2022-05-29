package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import static sun.net.www.protocol.http.AuthCacheValue.Type.Server;


public class Main {


    static final int PUERTO= 8080;
    public static void main(String[] args) throws IOException {
        ServerSocket ss;
        System.out.print("Inicializando servidor... ");
        try {
            ss = new ServerSocket(PUERTO);
            System.out.println("\t [OK] ");
            int idSession = 0;
            while (true) {
                Socket socket;

                socket = ss.accept();
                System.out.println("Nueva conexión entrante : " + socket);
                ((ServidorMultiParlante) new ServidorMultiParlante(socket, idSession)).start();
                idSession++;
            }
        } catch (IOException ex) {
           // Logger.getLogger(ServirUnParlante.class.getName()).log(Level.SEVERE, null, ex);


        }
    }}
