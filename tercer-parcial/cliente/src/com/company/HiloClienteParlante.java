package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloClienteParlante extends Thread {
    protected Socket sk;
    protected DataOutputStream dos;
    protected DataInputStream dis;
    private int id; public HiloClienteParlante (int id) {
        this.id = id;
    }

@Override
public void run () {
    try {
        sk = new Socket("127.0.0.1", 8080);
        dos = new DataOutputStream(sk.getOutputStream());
        dis = new DataInputStream(sk.getInputStream());
        System.out.println(id + "envia saludo");
        dos.writeUTF("hola");
        String respuesta = "";
        respuesta = dis.readUTF();
        System.out.println(id + " Servidor devuelve saludo : " + respuesta);
        dis.close();
        dos.close();
        sk.close();
    } catch (IOException ex) {
        //Logger.getLogger(HiloCliente Parlante.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}
