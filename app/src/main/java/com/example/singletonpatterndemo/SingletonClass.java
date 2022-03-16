package com.example.singletonpatterndemo;

public class SingletonClass {

    private static volatile SingletonClass INSTANCE = null;

    private SingletonClass(){ }

    public static SingletonClass getInstance(){
        if (INSTANCE == null){
            //Thread safe
            synchronized (SingletonClass.class){
                if (INSTANCE == null){
                    INSTANCE = new SingletonClass();
                }
            }
        }
        return INSTANCE;
    }

    private double leitzins = 0.5;

    public double getLeitzins() {
        return leitzins;
    }

    public void setLeitzins(double leitzins) {
        if (leitzins > 0.5){
            this.leitzins = leitzins;
        }

    }
}
