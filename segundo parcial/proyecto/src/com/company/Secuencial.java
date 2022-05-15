/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company;


public class Secuencial {

    int cantidad;
    int arreglo[] = new int[cantidad];
    String resultado = "";
    double tiempo;

    Secuencial(int[] arreglo, int cantidad){
        this.cantidad = cantidad;
        this.arreglo = arreglo;

        factorial(arreglo);

        long inicio = System.nanoTime();

        for(int i =0; i< arreglo.length;++i){
            resultado = resultado + arreglo[i];
            if(i != arreglo.length-1)
                resultado = resultado + ", ";
        }
        System.out.println("");
        long fin = System.nanoTime();

        tiempo = fin - inicio;

    }

    public static void factorial(int[] arreglo) {
        for(int i=0; i<arreglo.length;i++){
            arreglo[i]=factorialResultado(arreglo[i]);


        }

    }

    public static int factorialResultado( int numero ) {
        int fact = 1;
        for( int i = 1; i <= numero; i++ ) {
            fact *= i;
        }

        return fact;

    }




}
