package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code

        int cantidad;

        do{
            Random r = new Random();
            cantidad = 10000;

        }while(cantidad == 1);

        int arreglo[] = new int[cantidad];

        for(int i=0; i<cantidad; i++){
            arreglo[i] = random();
        }


        Interfaz v = new Interfaz(arreglo, cantidad);


    }

    public static int random(){
        Random r = new Random();
        int valorDado = r.nextInt(10)+1;
        return valorDado;
    }
}
