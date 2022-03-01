package com.company;

import java.util.Random;

public class Productor extends Thread{

    Integer productos;

    Productor(Integer productos){
        this.productos=productos;
    }

    @Override
    public void run() {

        while (true){
            if(Panel.productos<=0){
                try {
                    synchronized(Panel.productos) {
                        Panel.accion.setText("productor creando productos");
                        Thread.sleep(1000);

                        Panel.productos=new Random().nextInt(11);
                        productos.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }



    }
}
