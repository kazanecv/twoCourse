package ru.omsu.imit;

import java.io.*;
import java.util.Scanner;

public class FinanceReport {
    private Payment[] array;
    public FinanceReport(int n){
        if(n<0) throw new IllegalArgumentException("Некорректный размер массива");
        array = new Payment[n];
        for(int i=0; i<n; i++){
            array[i] = new Payment();
        }
    }
    public void inPut(InputStream in) throws IOException {
        DataInputStream r = new DataInputStream(in);
        int g = r.readInt();
        array = new Payment[g];
        for(int i = 0; i < array.length; i++) {
            array[i] = new Payment();
            array[i].setName(r.readUTF());
            array[i].setDay(r.readInt());
            array[i].setMonth(r.readInt());
            array[i].setYear(r.readInt());
            array[i].setAmount(r.readInt());
        }
    }
    public Payment getPayment(int index) {
        // TODO check index
        if(index<0 || index>array.length) throw new IllegalArgumentException("Вызываемого платежа не существует!");
        return this.array[index];
    }
    public void setPayment(int index, Payment pay) {
        // TODO check index
        this.array[index] = new Payment(pay);
    }

    public void outPut(OutputStream in) throws IOException {
        DataOutputStream w = new DataOutputStream(in);
        w.writeInt(array.length);
        for(int i = 0; i < array.length; i++) {
            w.writeUTF(array[i].getName());
            w.writeInt(array[i].getDay());
            w.writeInt(array[i].getMonth());
            w.writeInt(array[i].getYear());
            w.writeInt(array[i].getAmount());
        }
    }
    public int getCountReport(){
        return array.length;
    }
//    public String getName(int index){
//        if(index<0 || index>array.length) throw new IllegalArgumentException("Вызываемого платежа не существует!");
//        return array[index].getName();
//    }
//    public int getDay(int index){
//        if(index<0 || index>array.length) throw new IllegalArgumentException("Вызываемого платежа не существует!");
//        return array[index].getDay();
//    }
//    public int getMonth(int index){
//        if(index<0 || index>array.length) throw new IllegalArgumentException("Вызываемого платежа не существует!");
//        return array[index].getMonth();
//    }
//    public int getYear(int index){
//        if(index<0 || index>array.length) throw new IllegalArgumentException("Вызываемого платежа не существует!");
//        return array[index].getYear();
//    }
//    public int getAmount(int index){
//        if(index<0 || index>array.length) throw new IllegalArgumentException("Вызываемого платежа не существует!");
//        return array[index].getAmount();
//    }
//    public void setName(int index,String name){
//        if(index<0 || index>array.length) throw new IllegalArgumentException("Вызываемого платежа не существует!");
//        array[index].setName(name);
//    }
//    public void setDay(int index,int day){
//        if(index<0 || index>array.length) throw new IllegalArgumentException("Вызываемого платежа не существует!");
//        array[index].setDay(day);
//    }
//    public void setMonth(int index, int month){
//        if(index<0 || index>array.length) throw new IllegalArgumentException("Вызываемого платежа не существует!");
//        array[index].setMonth(month);
//    }
//    public void setYear(int index,int year){
//        if(index<0 || index>array.length) throw new IllegalArgumentException("Вызываемого платежа не существует!");
//        array[index].setYear(year);
//    }
//    public void setAmount(int index,int amount){
//        if(index<0 || index>array.length) throw new IllegalArgumentException("Вызываемого платежа не существует!");
//        array[index].setAmount(amount);
//    }
    public String findReport(char symbol){
        StringBuilder result = new StringBuilder();
        for(int i=0; i<array.length; i++){
            if (this.array[i].getName().charAt(0) == symbol) {
                result.append(this.array[i].toString()).append('\n');
            }
        }
        return result.toString();
    }
    @Override
    public String toString(){
        String res="";
        for(int i=0; i<array.length; i++){
            res+=array[i].toString();
            res+="\n";
        }
        return res;
    }
    public FinanceReport(FinanceReport copy){
        array = new Payment[copy.getCountReport()];
        for(int i=0; i<this.array.length; i++){
            array[i] = new Payment(copy.array[i]);
        }
    }
    public String outByAmount(int amount){
        StringBuilder result = new StringBuilder();
        for(int i=0; i<array.length; i++){
            if(this.array[i].getAmount() < amount){
                result.append(this.array[i].toString()).append('\n');
            }
        }
        return result.toString();
    }
    public int getAmountDay(String date){
        char[] temp = new char [2];
        date.getChars(0, 2, temp, 0);
        int day = Integer.parseInt(new String(temp), 10);
//        System.out.println("d "+day);
        date.getChars(3, 5, temp, 0);
        int mouth = Integer.parseInt(new String(temp), 10);
        //System.out.println("m "+mouth);
        char[] temp2 = new char [4];
        date.getChars(6, 10, temp2, 0);
        int year = Integer.parseInt(new String(temp2), 10);
        //System.out.println("y "+year);
        int allAmount=0;
        for(int i=0; i<array.length;i++){
//            System.out.println(this.array[i].getDay()+" "+this.array[i].getMonth()+" "+this.array[i].getYear());
            if(this.array[i].getDay()==day && this.array[i].getMonth()==mouth && this.array[i].getYear()==year) {

                allAmount += this.array[i].getAmount();
            }
        }
        return allAmount;
    }
    public String getListYear(int year){
        String[] months = {"Январь\n","Февраль\n","Март\n","Апрель\n","Май\n","Июнь\n","Июль\n","Август\n","Сентябрь\n","Октябрь\n","Ноябрь\n","Декабрь\n"};
        String result = "";
        boolean[] keys = new boolean [12];
        for(int i=0; i<12; i++){
            keys[i]=false;
        }
        for(int i=0; i<array.length; i++){
            keys[this.array[i].getMonth()-1]=true;
        }
        for(int i=0; i<12; i++){
            if(!keys[i]) result+=months[i];
        }
        return result;
    }
}
