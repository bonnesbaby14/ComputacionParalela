package com.company;

public class Main {

    public volatile static  int array[][];
    public static void main(String[] args) throws InterruptedException {
	// write your code here




        int max = 100;
        int min = 1;
        int range = max - min + 1;
         array = new int[3][3];

        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){

                array[i][j]=(int)(Math.random() * range) + min;

            }
        }
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                System.out.print(array[i][j]+"  ");

            }
            System.out.println();
        }


        Multiplicador uno=new Multiplicador(true);
        Multiplicador dos=new Multiplicador(false);

        uno.start();
        uno.join();
        dos.start();
        dos.join();
        System.out.println("matriz multiplicada");
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                System.out.print(array[i][j]+"  ");

            }
            System.out.println();
        }


    }
}
