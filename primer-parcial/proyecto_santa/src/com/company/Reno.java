package com.company;

import javax.swing.*;

public class Reno extends Thread{


    public JLabel Reno;

    public Reno(JLabel Reno) {
        this.Reno = Reno;
    }

    @Override
    public void run() {
        boolean exit=true;
        boolean exit2=true;

        System.out.println("se creo reno id "+getName());
        while(exit){
            if(Panel.accesoRojo){

                if(Integer.parseInt(getName().toString())==Panel.semaforoRojo){

                    while(exit2) {
                        try {
                            System.out.println("entrgando regaños duende " +getName());
                            Thread.sleep(600);




                            Panel.panel.remove(Reno);
                            Panel.semaforoRojo++;
                            Panel.hayRojo--;
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
        System.out.println(" El Reno " +getName() +"entrego");

    }
}
