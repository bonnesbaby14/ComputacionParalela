package com.company;

import javax.swing.*;

public class Rojo extends Thread {

    public JLabel carro;

    public Rojo(JLabel carro) {
        this.carro = carro;
    }

    @Override
    public void run() {
        boolean exit=true;
        boolean exit2=true;

        System.out.println("se creo carro id "+getName());
        while(exit){
            if(Panel.accesoRojo){

                if(Integer.parseInt(getName().toString())==Panel.semaforoRojo){

                    while(exit2) {
                        try {
                            System.out.println("un carro moverse el"+getName());
                            carro.setBounds(carro.getX()-10,carro.getY(),carro.getWidth(),carro.getHeight());

                            System.out.println("moviendo carro " +getName());

                            if(carro.getX()<200){
                                exit2=false;
                                Panel.panel.remove(carro);
                                Panel.semaforoRojo++;
                                Panel.hayRojo--;
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
