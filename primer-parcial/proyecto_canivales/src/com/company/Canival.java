package com.company;

public class Canival extends Thread{


    @Override
    public void run() {
        while(true){

            if(Panel.consumir==true && Panel.turno==Integer.parseInt(getName())){

                Panel.accion.setText("Canival "+getName()+" comiendo");

                Panel.racciones--;
                Panel.totalRacciones.setText(Panel.racciones+"");

                System.out.println("Canival "+getName()+" comiendo");
                if(Panel.racciones<=0){

                    Panel.consumir=false;

                }

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                Panel.turno++;
                if(Panel.turno>=Panel.numeroCanivales){
                    Panel.turno=0;

                }
            }

        }
    }
}

