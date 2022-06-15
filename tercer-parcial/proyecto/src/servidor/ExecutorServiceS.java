/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;


/**
 *
 * @author Mariana
 */
public class ExecutorServiceS implements Runnable{


    int arreglo[];
    String resultado = "";

    public ExecutorServiceS(int[] arreglo) {
        this.arreglo = arreglo;

    }
    public void run() {
        int arreglo2[]=executor(arreglo);
    }
    public int [] returnArray()
    {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println(arreglo[i]);

        }
        return arreglo;
    }


    public static  int[] executor(int [] arreglo){

        if(arreglo.length<2){

            for(int i=0; i<arreglo.length;i++){
                arreglo[i]=factorialResultado(arreglo[i]);
            }
            return arreglo;
        }


        int half = arreglo.length / 2;
        int[] left = new int[half];
        int[] rigth = new int[arreglo.length - half];


        for (int i = 0; i < arreglo.length/2; i++) {
            left[i] = arreglo[i];
        }
        for (int i = arreglo.length/2; i < arreglo.length; i++) {
            rigth[i - (arreglo.length/2)] = arreglo[i];
        }






        int [] uno=executor(left);
        int [] dos=executor(rigth);

        int[] concate = new int[uno.length + dos.length];
        System.arraycopy(uno, 0, concate, 0, uno.length);
        System.arraycopy(dos, 0, concate, uno.length, dos.length);

        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = concate[i];
        }

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
