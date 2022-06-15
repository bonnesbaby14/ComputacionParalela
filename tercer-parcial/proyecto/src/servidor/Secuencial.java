/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;


public class Secuencial {


    int arreglo[];
    String resultado = "";


    Secuencial(int[] arreglo){

        this.arreglo = arreglo;
        for(int i=0; i<arreglo.length;i++){

            System.out.println(arreglo[i]);


        }
        factorial(arreglo);



        for(int i =0; i< arreglo.length;++i){
            resultado = resultado + arreglo[i];
            if(i != arreglo.length-1)
                resultado = resultado + ", ";
        }
        System.out.println("");



        for(int i=0; i<arreglo.length;i++){

            System.out.println(arreglo[i]);


        }
    }

    public static void factorial(int[] arreglo) {
        for(int i=0; i<arreglo.length;i++){
            arreglo[i]=factorialResultado(arreglo[i]);
            System.out.println(arreglo[i]);


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
