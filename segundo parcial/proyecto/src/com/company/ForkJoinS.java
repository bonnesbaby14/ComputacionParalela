/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.Arrays;


public class ForkJoinS extends RecursiveTask<int []> {

    public  int[] arreglo;

    public ForkJoinS(int[] arreglo){
        this.arreglo = arreglo;
    }

    @Override
    protected int [] compute() {

        if (arreglo.length < 2) {
            for(int i=0; i<arreglo.length;i++){
                arreglo[i]=factorialResultado(arreglo[i]);
            }

            return arreglo;

        }
        int half = arreglo.length / 2;

        int[] left = new int[half];
        System.arraycopy(arreglo, 0, left, 0, half);

        int[] right = new int[arreglo.length - half];
        System.arraycopy(arreglo, half, right, 0, arreglo.length - half);

        ForkJoinS taskLeft=new ForkJoinS(left);
        ForkJoinS taskRight=new ForkJoinS(right);

        taskLeft.fork();
        taskRight.fork();
        int [] uno=taskLeft.join();
        int [] dos=taskRight.join();

        int[] concate = new int[uno.length + dos.length];
        System.arraycopy(uno, 0, concate, 0, uno.length);
        System.arraycopy(dos, 0, concate, uno.length, dos.length);
        return  concate;



    }



    public static int factorialResultado( int numero ) {
        int fact = 1;
        for( int i = 1; i <= numero; i++ ) {
            fact *= i;
        }

        return fact;

    }



}
