package com.company;

import javax.swing.*;

public class Main  {

    public static void main(String[] args) {
    Thread a= new Thread(new Reloj());
    a.start();

    }




}
