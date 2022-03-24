package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Panel extends JFrame {


    protected static JButton addLeft;
    protected static JButton addRigth;

    public static volatile int hayRojo;
    public static volatile int hayAzul;




    public static volatile boolean accesoAzul;
    public static volatile boolean accesoRojo;




    public static volatile int semaforoRojo;
    public static volatile int semaforoAzul;

    public int escaleraDuende=0;
    public int escaleraReno=0;








    public ImageIcon autoimageAzul;
    public ImageIcon autoimageRojo;

    public static  JPanel panel;


    Panel(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel=new JPanel();
        getContentPane().add(panel);
        setSize(1000,550);

        panel.setLayout(null);
      //  auto1=new JLabel();
        //auto1.setBounds(180,220,50,50);
        autoimageAzul= new ImageIcon("/home/bonnesbaby14/Escritorio/desarrollo-movil/primer_parcial/proyecto_santa/src/com/company/auto.png");
        autoimageRojo= new ImageIcon("/home/bonnesbaby14/Escritorio/desarrollo-movil/primer_parcial/proyecto_santa/src/com/company/auto2.png");

        //auto1.setIcon(new ImageIcon(autoimage.getImage().getScaledInstance(auto1.getWidth(),auto1.getHeight(), Image.SCALE_SMOOTH)));

        addLeft=new JButton("ADD DUENDE");
        addRigth=new JButton("ADD RENO");

        addLeft.setBounds(10,30,200,30);
        addRigth.setBounds(211,30,200,30);


        addLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JLabel auto=new JLabel("d");
                auto.setBounds(50,220+escaleraDuende,60,60);
                auto.setIcon(new ImageIcon(autoimageAzul.getImage().getScaledInstance(auto.getWidth(),auto.getHeight(), Image.SCALE_SMOOTH)));
                panel.add(auto);

                Duendes duende=new Duendes(auto);
                duende.setName(hayAzul+"");
                duende.start();

                hayAzul++;
                System.out.println("El numero de azules es: "+hayAzul);
                panel.revalidate();
                panel.repaint();
                escaleraDuende+=50;


            }
        });

        addRigth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JLabel auto=new JLabel("d");
                auto.setBounds(720,190+escaleraReno,60,60);
                auto.setIcon(new ImageIcon(autoimageRojo.getImage().getScaledInstance(auto.getWidth(),auto.getHeight(), Image.SCALE_SMOOTH)));
                panel.add(auto);

                Reno reno=new Reno(auto);
                reno.setName(hayRojo+"");
                reno.start();
                hayRojo++;
                System.out.println("El numero de renos es: "+hayRojo);
                panel.revalidate();
                panel.repaint();
                escaleraReno+=30;

            }
        });






        panel.add(addRigth);
        panel.add(addLeft);
        //panel.add(auto1);

        this.setVisible(true);
        Observador observador=new Observador();
        observador.start();

    }







}
