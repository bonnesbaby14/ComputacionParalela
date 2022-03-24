package com.company;

import javax.swing.*;

public class Duendes extends Thread{

    public JLabel duende;

    public Duendes(JLabel duende) {
        this.duende = duende;
    }

    @Override
    public void run() {
        boolean exit=true;
        boolean exit2=true;

        System.out.println("se creo duende id "+getName());
        while(exit){
            if(Panel.accesoAzul){

                if(Integer.parseInt(getName().toString())==Panel.semaforoAzul){

                    while(exit2) {
                        try {
                            System.out.println("mtrabjando duende " +getName());
                            Thread.sleep(600);




                                Panel.panel.remove(duende);
                                Panel.semaforoAzul++;
                                Panel.hayAzul--;
                                exit2=false;

                            Panel.panel.repaint();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    exit=false;



                }
            }

        }
        System.out.println(" El reno ayudo " +getName() +"exploto");

    }
}
