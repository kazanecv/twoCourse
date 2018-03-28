package ru.omsu.imit;

import java.io.*;

public class Main {
    public static void testPayment(){
        Payment one = new Payment("Иванов Иван Иванович",15,12,17,100050);
        System.out.println(one.toString());
        one.setName("Степанов Степан Степанович");
        System.out.println(one.toString());
        one.setDay(1);
        one.setMonth(1);
        one.setYear(1);
        System.out.println(one.toString());
        one.setAmount(1050);
        System.out.println(one.toString());
    }
    public static void testFinanceReport() throws IOException {
        FinanceReport one = new FinanceReport(1);
        Payment pay = new Payment("Привет", 10, 5, 2017, 1000);
        one.setPayment(0, pay);
        one.outPut(new FileOutputStream("Anon"));
        FinanceReport two = new FinanceReport(1);
        two.inPut(new FileInputStream("Anon"));
        System.out.println(two.toString());
    }
    public static void main(String[] args) throws IOException {
        Payment pay0 = new Payment("Привет", 10, 5, 2017, 1000);
        Payment pay1 = new Payment("Петя", 12,  6, 2017, 500);
        Payment pay2 = new Payment("Сидор", 1, 1, 2017, 100500);
        Payment pay3 = new Payment("Иван", 10, 5, 2017, 7500);
//        Payment pay4 = new Payment("Андрей", 7, 10, 2017, 7500);

//        testPayment();
//        testFinanceReport();
        FinanceReport fin = new FinanceReport(4);
        fin.setPayment(0,pay0);
        fin.setPayment(1,pay1);
        fin.setPayment(2,pay2);
        fin.setPayment(3,pay3);
//        fin.setPayment(4,pay4);
        System.out.println( fin.findReport('И'));
        System.out.println("********************");
        System.out.println( fin.getAmountDay("10 05 2017"));  // ???
        System.out.println("********************");
        System.out.println( fin.getListYear(2017));  // 1 5 6 12

    }
}
