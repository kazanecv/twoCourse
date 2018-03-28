package ru.omsu.imit;

public class Main {
    public static void main(String[] args) {
        System.out.println(StringProcessor.copyText("Привет",1));
        System.out.println(StringProcessor.countFind("aaa aab aaav aac aa","aa"));
        System.out.println(StringProcessor.replaseNum("У Миши 212345 яблока!"));
        System.out.println(StringProcessor.deleteSymbol(new StringBuilder("12")));
        System.out.println(StringProcessor.replaseNum16("У Миши 0x00C00000 яблока 0x00000011 0x000000FF!"));
        System.out.println(StringProcessor.beginEnd(" aaa nnn aaa bbbbb    "));
    }
}
