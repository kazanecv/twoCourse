package ru.omsu.imit;

import java.util.Objects;

public class Payment {
    private String name;
    private int day;
    private int month;
    private int year;
    private int amount;
    public Payment(){
        
    }
    public Payment(String name,int day,int month,int year,int amount){
        if(name.trim().length() == 0 || name==null) throw new IllegalArgumentException("ФИО Плательщика не указано");
        if(day<=0 || month<=0 || year<0) throw new IllegalArgumentException("Некорректная дата");
        if(amount<=0) throw new IllegalArgumentException("Некорректная сумма платежа");
        this.name= new String(name);
        this.day=day;
        this.month=month;
        this.year=year;
        this.amount=amount;
    }
    public String getName(){
        return name;
    }
    public int getDay(){
        return day;
    }
    public int getMonth(){
        return month;
    }
    public int getYear(){
        return year;
    }
    public int getAmount(){
        return amount;
    }
    public void setName(String name){
        if(name=="" || name==null) throw new IllegalArgumentException("ФИО Плательщика не указано");
        this.name = new String(name);
    }
    public void setDay(int day){
        if(day<=0) throw new IllegalArgumentException("Некорректный день");
        this.day=day;
    }
    public void setMonth(int month){
        if(month<=0) throw new IllegalArgumentException("Некорректный месяц");
        this.month=month;
    }
    public void setYear(int year){
        if(year<0) throw new IllegalArgumentException("Некорректный год");
        this.year = year;
    }
    public void setAmount(int amount){
        this.amount=amount;
    }
    @Override
    public String toString(){
        return String.format("ФИО: %s | Дата: %d.%d.%d | Сумма: %d рублей %02d копеек",name,day,month,year,amount/100,amount%100);
    }
    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if(this.getClass() != other.getClass()) return false;
        Payment otherObj = (Payment)other;
        return(name.equals(otherObj.getName()) && day==otherObj.getDay() 
        && year==otherObj.getYear() && month==otherObj.getMonth() 
        && amount==otherObj.getAmount());
    }
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.name);
        hash = 13 * hash + this.day;
        hash = 13 * hash + this.month;
        hash = 13 * hash + this.year;
        hash = 13 * hash + this.amount;
        return hash;
    }
}
