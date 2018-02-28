package ru.omsu.imit;
import java.util.Scanner;
public class Main {
    public static String toString(double array[]){
        String res = "";
        for(int i=0; i<array.length; i++){
            res += String.format("%f ",array[i]);
        }
        return res;
    }
    public static void setArray(double array[]){
        Scanner cin = new Scanner(System.in);
        for(int i=0; i<array.length;i++){
            System.out.printf("Ввведите array[%d]: ", i);
            array[i] = cin.nextDouble();
        }
    }
    public static double summArray(double array[]){
        double temp=0;
        for(int i=0; i<array.length;i++){
            temp+=array[i];
        }
        return temp;
    }
    public static int countArray(double array[]){
        int count=0;
        for(int i=0; i<array.length; i++){
            if(array[i]%2==0) count++;
        }
        return count;
    }
    public static int lineArray(double array[],double a,double b){
        int count=0;
        for(int i=0; i<array.length;i++){
            if(array[i]>=a && array[i]<=b) count++;
        }
        return count;
    }
    public static boolean additionArray(double array[]){
        boolean flag=true;
        for(int i=0;i<array.length && flag;i++){
            if(array[i]<0) flag=false;
        }
        return flag;
    }
    public static void backArray(double array[]){
        double temp;
        for(int i=0; i<array.length/2; i++){
            temp = array[i];
            array[i] = array[array.length-(i+1)];
            array[array.length-(i+1)] = temp;
        }
    }
    public static void main(String[] args) {
        double array[] = new double [5];
        setArray(array);
        System.out.println(toString(array));
        System.out.printf("Сумма: %f\n", summArray(array));
        System.out.printf("Чётных чисел: %d\n", countArray(array));
        System.out.printf("Все положительные? %b\n", additionArray(array));
        System.out.printf("Отрезок: %d\n", lineArray(array,0.5,2));
        backArray(array);
        System.out.println(toString(array));
    }
}
