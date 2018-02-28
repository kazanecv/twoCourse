package ru.omsu.imit;

public class Equals {
    public static boolean nextDouble(double one,double two){
        return(Math.abs(one-two)<1e-9);
    }
}
