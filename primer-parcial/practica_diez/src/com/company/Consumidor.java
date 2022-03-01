package com.company;

import com.sun.source.tree.SynchronizedTree;

public class Consumidor extends Thread{


int numeroConsumidor;

    Consumidor(int numeroConsumidor){
    this.numeroConsumidor=numeroConsumidor;
    }
    @Override
    public void run() {


           while(true){
               try {
                   if(Panel.semaforo==this.numeroConsumidor) {
                       synchronized (Panel.productos) {

                           if (Panel.productos <= 0) {
                               Panel.productos.wait();
                               System.out.println("espero");

                           }
                           Panel.accion.setText("Consumiendo consumidor " + numeroConsumidor);
                           System.out.println("consumi");
                           Panel.productos--;


                       }
                       Thread.sleep(1000);
                       Panel.semaforo++;
                       if(Panel.semaforo>Panel.max){
    Panel.semaforo=1;
                       }
                   }


               } catch (InterruptedException e) {
                   e.printStackTrace();
               }

           }





    }


}
