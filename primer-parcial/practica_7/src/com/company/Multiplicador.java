package com.company;

public class Multiplicador extends Thread{

    public boolean par;
    Multiplicador(boolean par){
    this.par=par;
    }

    @Override
    public void run() {
        for (int i=0;i<3;i++){
            if(par && ((i+1)%2)==0 ){
                for (int j=0;j<3;j++){

                    Main.array[i][j]=Main.array[i][j]*2;

                }
            }
            if(!par && ((i+1)%2)!=0 ){
                for (int j=0;j<3;j++){

                    Main.array[i][j]=Main.array[i][j]*2;

                }
            }


        }


    }
}
