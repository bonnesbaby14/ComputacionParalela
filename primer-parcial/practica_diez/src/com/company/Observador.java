package com.company;

import javax.swing.*;

public class Observador extends Thread{

    private Integer productos;
    private JLabel productosJ;

    public Observador(Integer productos, JLabel productosJ) {
        this.productos = productos;
        this.productosJ = productosJ;
    }

    @Override
    public void run() {

        while(true) {
            productosJ.setText(Panel.productos.toString());

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
