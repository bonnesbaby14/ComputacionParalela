package com.company;

public class Cocinero extends Thread {

    @Override
    public void run() {

        while(true){

            if(Panel.consumir==false){

                Panel.accion.setText("Cocinero concinando");

                Panel.racciones++;
                Panel.totalRacciones.setText(Panel.racciones+"");

                System.out.println("cocinando");
                if(Panel.Totalracciones==Panel.racciones){

                    Panel.consumir=true;

                }

                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }

        }



    }
}
