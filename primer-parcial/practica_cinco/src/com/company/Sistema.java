package com.company;

import javax.swing.*;

public class Sistema extends JFrame implements Calculadora{


    Sistema(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel=new JPanel();
        panel.setLayout(null);

        JLabel resultado=new JLabel("Resutado");
        resultado.setBounds(150,140,110,50);
        panel.add(resultado);

        getContentPane().add(panel);
        setSize(500,250);


        JTextField dato2=new JTextField("2");
        dato2.setBounds(130,40,100,50);
        panel.add(dato2);


        JTextField dato1=new JTextField("1");
        dato1.setBounds(20,40,100,50);
        panel.add(dato1);

        JButton sumar =new JButton("+");
        sumar.setBounds(10,90,50,50);
        sumar.addActionListener(e->{
            resultado.setText(this.suma(Float.valueOf(dato1.getText()),Float.valueOf(dato2.getText()))+"");
        });


        panel.add(sumar);
        JButton resta =new JButton("-");
        resta.setBounds(60,90,50,50);
        resta.addActionListener(e->{
            resultado.setText(this.resta(Float.valueOf(dato1.getText()),Float.valueOf(dato2.getText()))+"");
        });
        panel.add(resta);
        JButton multiplicacion =new JButton("*");
        multiplicacion.setBounds(110,90,50,50);
        multiplicacion.addActionListener(e->{
            resultado.setText(this.multiplicacion(Float.valueOf(dato1.getText()),Float.valueOf(dato2.getText()))+"");
        });
        panel.add(multiplicacion);
        JButton division =new JButton("/");
        division.setBounds(160,90,50,50);
        panel.add(division);
        division.addActionListener(e->{
            resultado.setText(this.division(Float.valueOf(dato1.getText()),Float.valueOf(dato2.getText()))+"");
        });
        JButton potencia =new JButton("^");
        potencia.setBounds(210,90,50,50);
        panel.add(potencia);
        potencia.addActionListener(e->{
            resultado.setText(this.potencia(Float.valueOf(dato1.getText()),Float.valueOf(dato2.getText()))+"");
        });
        JButton modulo =new JButton("%");
        modulo.setBounds(260,90,50,50);
        modulo.addActionListener(e->{
            resultado.setText(this.modulo(Float.valueOf(dato1.getText()),Float.valueOf(dato2.getText()))+"");
        });
        panel.add(modulo);


    }

    @Override
    public  float suma(float a, float b) {
        return a+b;
    }

    @Override
    public float resta(float a, float b) {
        return a-b;
    }

    @Override
    public float multiplicacion(float a, float b) {
        return a*b;
    }

    @Override
    public float division(float a, float b) {
        return a/b;
    }

    @Override
    public float potencia(float a, float b) {
        return (float) Math.pow(a,b);
    }

    @Override
    public int modulo(float a, float b) {
        return (int) (a%b);
    }
}
