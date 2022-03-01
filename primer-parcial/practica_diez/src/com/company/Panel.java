package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JFrame
{

    protected static volatile Integer productos=0;
    protected static volatile Integer semaforo=1;
    protected static volatile Integer max;



    protected static Consumidor[] consimidores;
    protected static Productor productor;
    protected static JTextField NoConsumidor;
    protected static JButton iniciar;
    protected static JLabel productosJ;
    protected static JLabel accion;

    Panel(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel=new JPanel();
        JTextField NoConsumidor= new JTextField("2");
        accion=new JLabel("Esperando para iniciar");
        iniciar=new JButton("inciar");
        productosJ= new JLabel(productos.toString());

        iniciar.addActionListener(e->{
            max=Integer.parseInt(NoConsumidor.getText());
            consimidores=new Consumidor[Integer.parseInt(NoConsumidor.getText())];
            for(int x=0;x<Integer.parseInt(NoConsumidor.getText());x++){
                consimidores[x]=new Consumidor(x+1);

                consimidores[x].start();
                System.out.println("creando consumidor "+x);

            }
            productor=new Productor(productos);
            Observador observador=new Observador(productos,productosJ);
            productor.start();
            observador.start();

        });

        panel.setLayout(null);

        getContentPane().add(panel);
        setSize(700,550);

        NoConsumidor.setBounds(10,20,70,20);
        iniciar.setBounds(335,20,100,20);
        productosJ.setBounds(335,222,100,30);
        accion.setBounds(300,390,300,30);
        panel.add(NoConsumidor);
        panel.add(iniciar);
        panel.add(productosJ);
        panel.add(accion);

        this.setVisible(true);
    }



}
