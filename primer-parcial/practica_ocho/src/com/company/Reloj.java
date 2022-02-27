package com.company;

import javax.swing.*;
import java.awt.*;

public class Reloj extends JFrame implements Runnable{
    private JLabel label1;
    private int segundos=0, minutos=0, hora=0;

    Reloj(){
        setLayout(new GridBagLayout());

        setBounds(10,10,200,100);

        setTitle("PRACTICA OCHO");

        setResizable(false);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        label1 = new JLabel(String.format("%02d",this.hora)+":"+String.format("%02d", this.minutos)+":"+String.format("%02d",this.segundos));

        label1.setBounds(10,20,200,30);
        add(label1,new GridBagConstraints());

        setVisible(true);

    }

    @Override
    public void run() {
      while(true){
          try
          {

              Thread.sleep(998);
              this.segundos++;
              if(this.segundos==60){
                  this.minutos++;
                  if(this.minutos==60){
                      this.minutos=0;
                      this.hora++;
                  }
                  this.segundos=0;
              }

              this.label1.setText(String.format("%02d",this.hora)+":"+String.format("%02d", this.minutos)+":"+String.format("%02d",this.segundos));

          }catch(InterruptedException e){}
      }
    }
}
