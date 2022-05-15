package com.company;

import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Sistema nuevo =new Sistema();
        nuevo.setVisible(true);
        System.out.println("Ingresa la opcion deseada");
        System.out.println("[1] suma");
        System.out.println("[2] resta");
        System.out.println("[3] multiplicacion");
        System.out.println("[4] division");
        System.out.println("[5] potencia");
        System.out.println("[6] modulo");
        int data= new Scanner(System.in).nextInt();
        int dato1;
        int dato2;
        switch (data){
            case 1:
                System.out.println("Ingresa el valor uno");
                 dato1=new Scanner(System.in).nextInt();
                System.out.println("Ingresa el valor dos");
                 dato2=new Scanner(System.in).nextInt();
                System.out.println("El resultado es: "+nuevo.suma(dato1,dato2));
                break;

            case 2:
                System.out.println("Ingresa el valor uno");
                 dato1=new Scanner(System.in).nextInt();
                System.out.println("Ingresa el valor dos");
                 dato2=new Scanner(System.in).nextInt();
                System.out.println("El resultado es: "+nuevo.resta(dato1,dato2));
                break;
            case 3:
                System.out.println("Ingresa el valor uno");
                dato1=new Scanner(System.in).nextInt();
                System.out.println("Ingresa el valor dos");
                dato2=new Scanner(System.in).nextInt();
                System.out.println("El resultado es: "+nuevo.multiplicacion(dato1,dato2));
                break;
            case 4:
                System.out.println("Ingresa el valor uno");
                dato1=new Scanner(System.in).nextInt();
                System.out.println("Ingresa el valor dos");
                dato2=new Scanner(System.in).nextInt();
                System.out.println("El resultado es: "+nuevo.division(dato1,dato2));
                break;
            case 5:
                System.out.println("Ingresa el valor uno");
                dato1=new Scanner(System.in).nextInt();
                System.out.println("Ingresa el valor dos");
                dato2=new Scanner(System.in).nextInt();
                System.out.println("El resultado es: "+nuevo.potencia(dato1,dato2));
                break;
            case 6:
                System.out.println("Ingresa el valor uno");
                dato1=new Scanner(System.in).nextInt();
                System.out.println("Ingresa el valor dos");
                dato2=new Scanner(System.in).nextInt();
                System.out.println("El resultado es: "+nuevo.modulo(dato1,dato2));
                break;

        }



    }


}
