package ru.omsu.imit;

public class QuadraticEqution{
    private double[] array = new double[3];
    public QuadraticEqution(double a,double b, double c){
        if(a==0) throw new IllegalArgumentException("Некорректные данные!");
        array[0]=a;
        array[1]=b;
        array[2]=c;
    }
    public double[] solveEquetion(){
        double[] result;
        double temp = Math.pow(array[1],2)-4*array[0]*array[2];
        if(temp>0) {
            result = new double[2];
            result[0] = (-array[1]+Math.sqrt(temp))/(2*array[0]);
            result[1] = (-array[1]-Math.sqrt(temp))/(2*array[0]);
        } else {
            if (temp == 0) {
                result = new double[1];
                result[0] = -array[1] / (2 * array[0]);
            } else {
                result = new double[0];
            }
        }
        return result;
    }
}
