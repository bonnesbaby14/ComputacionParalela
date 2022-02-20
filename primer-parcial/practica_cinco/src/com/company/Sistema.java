package com.company;

public class Sistema implements Calculadora{
    Sistema(){

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
