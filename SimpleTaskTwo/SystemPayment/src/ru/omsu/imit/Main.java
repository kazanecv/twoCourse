package ru.omsu.imit;

import java.io.*;

public class Main {
    public static void testPayment(){
        Payment one = new Payment("Иванов Иван Иванович",15,12,17,100050);
        System.out.println(one.toString());
        one.setName("Степанов Степан Степанович");
        System.out.println(one.toString());
        one.setDay(1);one.setMonth(1);one.setYear(1);
        System.out.println(one.toString());
        one.setAmount(1050);
        System.out.println(one.toString());
    }
    public static void testFinanceReport() throws IOException {
        FinanceReport one = new FinanceReport(1);
        one.setAmount(0, 1000);
        one.setName(0, "Привет");
        one.setDay(0, 10);
        one.setMonth(0, 5);
        one.setYear(0, 2017);
        one.outPut(new FileOutputStream("Denis"));
        FinanceReport two = new FinanceReport(1);
        two.inPut(new FileInputStream("Denis"));
        System.out.println(two.toString());
    }
    public static void main(String[] args) throws IOException {
        //testPayment();
        testFinanceReport();
    }
}
