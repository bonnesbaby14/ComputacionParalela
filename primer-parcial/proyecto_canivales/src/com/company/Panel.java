package com.company;

import javax.swing.*;

public class Panel extends JFrame {

    protected static JTextField NoCanival;
    protected static JButton iniciar;
    public static volatile JLabel accion;
    protected static JLabel NoCanivalText;
    protected static JLabel NoRacionesText;
    protected static JTextField NoRaciones;

    public static volatile JLabel totalRacciones;

    public static volatile int Totalracciones=0;
    public static volatile int racciones=0;
    public static volatile boolean consumir=false;
    public static volatile int turno=0;
    public static volatile int numeroCanivales=0;



    public Canival[] canivales;



    Panel(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel=new JPanel();

        accion=new JLabel("Esperando para iniciar");
        iniciar=new JButton("inciar");
        NoCanival=new JTextField("2");
        NoCanivalText=new JLabel("No. Canival");
        NoRaciones=new JTextField("2");
        NoRacionesText=new JLabel("No. Racciones");

        totalRacciones=new JLabel("0");

        panel.setLayout(null);

        getContentPane().add(panel);
        setSize(700,550);

        iniciar.setBounds(335,20,100,20);
        accion.setBounds(300,390,300,30);
        NoCanival.setBounds(10,30,50,30);
        NoCanivalText.setBounds(10,70,100,30);

        NoRaciones.setBounds(600,30,50,30);
        NoRacionesText.setBounds(600,70,100,30);

        totalRacciones.setBounds(350,225,100,30);

        iniciar.addActionListener(e->{

         Panel.Totalracciones=Integer.parseInt(NoRaciones.getText().toString());

            System.out.println("Entro al boton");

         Cocinero cociner= new Cocinero();

         numeroCanivales=Integer.parseInt(NoCanival.getText());
         canivales=new Canival[Integer.parseInt(NoCanival.getText())];
            for(int x=0;x<Integer.parseInt(NoCanival.getText());x++){
                canivales[x]=new Canival();
                canivales[x].setName(""+x);



                canivales[x].start();
                System.out.println("creando canival "+x);

            }



         cociner.start();

        });



        panel.add(iniciar);
        panel.add(accion);
        panel.add(NoCanival);
        panel.add(NoCanivalText);
        panel.add(NoRaciones);
        panel.add(NoRacionesText);
        panel.add(totalRacciones);

        this.setVisible(true);

    }


}
