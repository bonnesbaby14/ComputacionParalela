/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;

import com.sun.security.jgss.GSSUtil;
import interfacee.chatCliente;
import interfacee.chatServidor;
import java.util.ArrayList;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;


public class implementacionChat extends UnicastRemoteObject implements chatServidor {

    public ArrayList<chatCliente> clientes;
    public int cont ;
    public int[] arreglo;
    public int cantidad;
    public String uno;
    public String dos;
    public implementacionChat() throws RemoteException {
        clientes = new ArrayList<chatCliente>();
        cont=0;
    }

    public void mensaje(String mensaje,String nombre) throws RemoteException {
        int a = 0;
        Scanner s = new Scanner(System.in);


        System.out.println(nombre + " : " + mensaje);

        if(mensaje.equals("fork")){

            int  array[] = new int[cantidad];
            System.arraycopy(arreglo, 0, array, 0, cantidad);

            ForkJoinPool pool = new ForkJoinPool(4);
            ForkJoinS forkjoin = new ForkJoinS(arreglo);
            long startTime = System.currentTimeMillis();
            int [] arrayn=pool.invoke(forkjoin);
            long tiempoCadena = System.currentTimeMillis() - startTime;

            String resultado = "";

            for(int i=0; i<cantidad; i++){
                resultado = resultado + arrayn[i];
                if(i < cantidad-1)
                    resultado = resultado + ", ";
            }
            //etiquetaForkJoin.setText(resultado);
            //etiquetaTiempo2.setText("TIEMPO FORK JOIN: "+tiempoCadena + " mili segundos");
            a = 0;
            while (a < clientes.size()) {
                clientes.get(a).mensajeCliente(String.valueOf(resultado+"!"+tiempoCadena+" mili segundos!fork"));
                a++;
            }
            System.arraycopy(array, 0, arreglo, 0, cantidad);

            return;

        }
        if(mensaje.equals("secu")){

            System.out.println("llegu aca server");
            long startTime = System.currentTimeMillis();
            System.out.println("1");
            int array[] = new int[cantidad];
            System.out.println("2");
            System.arraycopy(arreglo, 0, array, 0, cantidad);
            System.out.println("3");
            Secuencial secuencial = new Secuencial(arreglo);
            System.out.println("4");
            long tiempoCadena = System.currentTimeMillis() - startTime;
            System.out.println("4");
            System.out.println("llegue al final server");
           // etiquetaSecuencial.setText(secuencial.resultado);
            //etiquetaTiempo1.setText("TIEMPO SECUENCIAL: "+tiempoCadena + " mili segundos");

            a = 0;
            while (a < clientes.size()) {
                clientes.get(a).mensajeCliente(String.valueOf(secuencial.resultado+"!"+tiempoCadena+" mili segundos!secu"));
                a++;
            }
            System.arraycopy(array, 0, arreglo, 0, cantidad);

            return;
        }
        if(mensaje.equals("exe")){
            int array[] = new int[cantidad];
            System.arraycopy(arreglo, 0, array, 0, cantidad);


            ExecutorService executorS = Executors.newFixedThreadPool(4);
            ExecutorServiceS executeClase = new ExecutorServiceS(arreglo);
            long startTime = System.currentTimeMillis();
            executorS.execute(executeClase);
            long tiempoCadena = System.currentTimeMillis() - startTime;

            String resultado = "";

            executeClase.returnArray();


            for(int i=0; i<cantidad; i++){
                resultado = resultado + arreglo[i];
                if(i < cantidad-1)
                    resultado = resultado + ", ";
            }
            //etiquetaExecutorService.setText(resultado);
            //etiquetaTiempo3.setText("TIEMPO EXECUTORSERVICE: "+tiempoCadena + " mili segundos");
            a = 0;
            while (a < clientes.size()) {
                clientes.get(a).mensajeCliente(String.valueOf(resultado+"!"+tiempoCadena+" mili segundos!exe"));
                a++;
            }
            System.arraycopy(array, 0, arreglo, 0, cantidad);


            return;
        }


        cont++;
        System.out.println(cont);
        if (cont == 1) {
            uno=mensaje;
        } else if (cont == 2) {
            cont = 0;
        dos=mensaje;

        String [] unos=uno.replace("]","").replace("[","").split(",");
        String [] doss=dos.replace("]","").replace("[","").split(",");
        int tamano=0;
        tamano=unos.length;
        tamano+=doss.length;

        cantidad=tamano;
         arreglo=new int[tamano];
        int contador=0;


            for(int x=0;x<unos.length;x++){
                arreglo[contador]=Integer.parseInt(unos[x].replace(" ",""));
                contador++;


            }
            for(int x=0;x<doss.length;x++){
                arreglo[contador]=Integer.parseInt(doss[x].replace(" ",""));
                contador++;

            }



            System.out.println("SE ACTUALIZARON LOS DATOS");
        }


            



        }


    public void registro(chatCliente cliente) throws RemoteException {
        this.clientes.add(cliente);
    }



}
