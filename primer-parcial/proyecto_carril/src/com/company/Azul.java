package com.company;

import javax.swing.*;

public class Azul extends Thread{

    public JLabel carro;

    public Azul(JLabel carro) {
        this.carro = carro;
    }

    @Override
    public void run() {
        boolean exit=true;
        boolean exit2=true;

        System.out.println("se creo carro id "+getName());
      while(exit){
          if(Panel.accesoAzul){

              if(Integer.parseInt(getName().toString())==Panel.semaforoAzul){

                  while(exit2) {
                      try {
                          System.out.println("un carro moverse el"+getName());
                          carro.setBounds(carro.getX()+10,carro.getY(),carro.getWidth(),carro.getHeight());

                          System.out.println("moviendo carro " +getName());

                          if(carro.getX()>600){
                              exit2=false;
                              Panel.panel.remove(carro);
                              Panel.semaforoAzul++;
                              Panel.hayAzul--;
                          }
                          Panel.panel.repaint();
                          Thread.sleep(300);
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                  }
                  exit=false;



              }
          }

      }
        System.out.println(" El carro " +getName() +"exploto");

    }
}
