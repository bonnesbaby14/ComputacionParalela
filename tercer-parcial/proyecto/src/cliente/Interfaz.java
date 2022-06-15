/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente;

import interfacee.chatServidor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class Interfaz extends JFrame implements ActionListener {

    JTextArea etiquetaDesordenada = new JTextArea();
    JTextArea etiquetaSecuencial = new JTextArea();
    JTextArea etiquetaForkJoin = new JTextArea();
    JTextArea etiquetaExecutorService = new JTextArea();

    JLabel etiquetaTiempo1 = new JLabel();
    JLabel etiquetaTiempo2 = new JLabel();
    JLabel etiquetaTiempo3 = new JLabel();
    JTextField cantidadd=new JTextField();
    JButton boton3 = new JButton();
    JButton boton2 = new JButton();
    JButton boton1 = new JButton();
    JButton boton = new JButton();
    JFrame ventana;

    int cantidad;
    int arreglo[] ;
    String nombre;
    chatServidor servidor;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int[] getArreglo() {
        return arreglo;
    }

    public void setArreglo(int[] arreglo) {
        this.arreglo = arreglo;
    }

    Interfaz(String nombre, chatServidor servidor) {

        this.servidor=servidor;
        this.nombre=nombre;
        //this.cantidad = cantidad;
        //this.arreglo = arreglo;
        String arregloDesordenado = "";
/*
        for (int i = 0; i < cantidad; i++) {
            arregloDesordenado = arregloDesordenado + arreglo[i];
            if (i != cantidad - 1)
                arregloDesordenado = arregloDesordenado + ", ";
        }
*/
        etiquetaDesordenada.setText(arregloDesordenado);


        ventana = new JFrame();
        ventana.setTitle(nombre);
        ventana.setLayout(null);
        ventana.setSize(1200, 700);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        etiquetaTiempo1.setText("TIEMPO SECUENCIAL");
        etiquetaTiempo1.setBounds(20, 30, 400, 20);

        etiquetaTiempo2.setText("TIEMPO FORK JOIN");
        etiquetaTiempo2.setBounds(20, 50, 400, 20);

        etiquetaTiempo3.setText("TIEMPO EXECUTORSERVICE");
        etiquetaTiempo3.setBounds(20, 70, 400, 20);


        etiquetaDesordenada.setLineWrap(true);
        etiquetaDesordenada.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(etiquetaDesordenada);
        scroll.setBounds(10, 100, 500, 500);


        etiquetaSecuencial.setLineWrap(true);
        etiquetaSecuencial.setWrapStyleWord(true);
        JScrollPane scroll1 = new JScrollPane(etiquetaSecuencial);
        scroll1.setBounds(600, 10, 400, 150);


        etiquetaForkJoin.setLineWrap(true);
        etiquetaForkJoin.setWrapStyleWord(true);
        JScrollPane scroll2 = new JScrollPane(etiquetaForkJoin);
        scroll2.setBounds(600, 170, 400, 150);


        etiquetaExecutorService.setLineWrap(true);
        etiquetaExecutorService.setWrapStyleWord(true);
        JScrollPane scroll3 = new JScrollPane(etiquetaExecutorService);
        scroll3.setBounds(600, 330, 400, 150);

        boton.addActionListener(this);

        boton1.addActionListener(this);
        boton1.setText("Secuencial");
        boton1.setBounds(1030, 70, 120, 50);

        boton2.addActionListener(this);
        boton2.setText("Fork-join");
        boton2.setBounds(1030, 230, 120, 50);


        boton3.addActionListener(this);
        boton3.setText("ExecutorService");
        boton3.setBounds(1030, 380, 150, 50);

        boton.setBounds(130, 600,100,100);

        boton.setBounds(130, 600,100,100);

        cantidadd.setBounds(30,600,100,100);

        ventana.add(cantidadd);
        ventana.add(boton);
        ventana.add(boton1);
        ventana.add(boton2);
        ventana.add(boton3);

        ventana.add(scroll1);
        ventana.add(scroll2);
        ventana.add(scroll3);

        ventana.add(scroll);
        ventana.add(etiquetaTiempo1);
        ventana.add(etiquetaTiempo2);
        ventana.add(etiquetaTiempo3);
        ventana.setVisible(true);




    }



    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        if(e.getSource() == boton1){

            try {
                servidor.mensaje("secu",nombre);
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }

/*

            long startTime = System.currentTimeMillis();
            int array[] = new int[cantidad];
            System.arraycopy(arreglo, 0, array, 0, cantidad);
            Secuencial secuencial = new Secuencial(arreglo);
            long tiempoCadena = System.currentTimeMillis() - startTime;
            etiquetaSecuencial.setText(secuencial.resultado);
            etiquetaTiempo1.setText("TIEMPO SECUENCIAL: "+tiempoCadena + " mili segundos");

            System.arraycopy(array, 0, arreglo, 0, cantidad);



*/

        }
        else if(e.getSource() == boton){

            cantidad=Integer.parseInt(cantidadd.getText().toString());
            arreglo=new int[cantidad];
            for(int i=0; i<cantidad; i++){
                arreglo[i] = random();
            }
            String arregloDesordenado = "";

            for (int i = 0; i < cantidad; i++) {
                arregloDesordenado = arregloDesordenado + arreglo[i];
                if (i != cantidad - 1)
                    arregloDesordenado = arregloDesordenado + ", ";
            }
            etiquetaDesordenada.setText(arregloDesordenado);

            try {
                servidor.mensaje(Arrays.toString(arreglo),nombre);
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }
        else if(e.getSource() == boton2){


            try {
                servidor.mensaje("fork",nombre);
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
/*

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
            etiquetaForkJoin.setText(resultado);
            etiquetaTiempo2.setText("TIEMPO FORK JOIN: "+tiempoCadena + " mili segundos");

            System.arraycopy(array, 0, arreglo, 0, cantidad);


*/


        }
        else if(e.getSource() == boton3){

            try {
                servidor.mensaje("exe",nombre);
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
/*
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
            etiquetaExecutorService.setText(resultado);
            etiquetaTiempo3.setText("TIEMPO EXECUTORSERVICE: "+tiempoCadena + " mili segundos");

            System.arraycopy(array, 0, arreglo, 0, cantidad);
 */
        }


    }

    public static int random() {
        Random r = new Random();
        int data = r.nextInt(10) + 1;
        return data;
    }
    }
