package com.company;

import javax.swing.*;
import java.awt.*;

public class Interfaz extends JFrame {

    public Interfaz() {
        setTitle("Práctica 2");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicializar();
         setVisible(true);
    }

    public void inicializar(){

        setLayout(new FlowLayout());
        JTextArea area = new JTextArea("Escribe tu opinion");
        // area.setBounds(10, 10, 150, 200);
        add(area);

        JButton guardar;
        guardar = new JButton("Guardar");
        // guardar.setBounds(20, 210, 100, 20);
        add(guardar);

        JCheckBox boxUno = new JCheckBox("Femenino");
        //boxUno.setBounds(200, 0, 100, 50);
        JCheckBox boxDos = new JCheckBox("Masculino");
        //boxDos.setBounds(200, 50, 100, 50);
        add(boxUno);
        add(boxDos);


        JRadioButton radio1 = new JRadioButton("1) Fútbol");
        JRadioButton radio2 = new JRadioButton("2) Basket");
        //radio1.setBounds(200, 100, 100, 30);
        //radio2.setBounds(200, 140, 100, 30);
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(radio1);
        grupo.add(radio2);
        add(radio1);
        add(radio2);

        String nombres[] = {"rosa", "mariana", "karla"};
        JComboBox combo = new JComboBox(nombres);
        //combo.setBounds(350, 10, 150, 20);
        add(combo);

        JScrollBar scroll = new JScrollBar();
        //scroll.setBounds(760, 0, 20, 400);
        add(scroll);

        JMenuBar barra = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem opc1 = new JMenuItem("Rojo");
        JMenuItem opc2 = new JMenuItem("Amarillo");
        menu.add(opc1);
        menu.addSeparator();
        menu.add(opc2);
        barra.add(menu);
        setJMenuBar(barra);


        JLabel nombre;
        nombre = new JLabel("Nombre: Gabriel Rodriguez ");
        // nombre.setBounds(160, 240, 100, 20);
        add(nombre);

        DefaultListModel<String> lista = new DefaultListModel<>();
        lista.addElement("Lunes");
        lista.addElement("Martes");
        lista.addElement("Miercoles");
        lista.addElement("Jueves");
        JList<String> list = new JList<>(lista);
        // list.setBounds(200, 180, 130, 75);
        add(list);

        String datas[][] = {{"14110265", "Rosa", "89.9"},
                {"14112323", "Alonso", "96.6"},
                {"14565676", "Dani", "79.9"}};
        String column[] = {"Registro", "Nombre", "Promedio"};
        JTable jt = new JTable(datas, column);
        //jt.setBounds(20, 400, 300, 300);
        JScrollPane sp = new JScrollPane(jt);
        add(sp, BorderLayout.SOUTH);

        JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
        JOptionPane.showMessageDialog(null, "Mensaje dentro de la ventana", "Mensaje en la barra de titulo", JOptionPane.WARNING_MESSAGE);
        String respuesta = JOptionPane.showInputDialog("Escribe tu nombre");
        int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro?");

        setVisible(true);

    }


}
