package ru.omsu.imit;

public class StringProcessor {
    public static String copyText(String text,int n){
        if(n<0) throw new IllegalArgumentException("Некорректные параметры!");
        StringBuffer textTemp = new StringBuffer();
        textTemp.ensureCapacity(text.length() * n);
        for(int i=0; i<n; i++){
            textTemp.append(text);
        }
        text = new String(textTemp);
        return text;
    }
    public static int countFind(String text,String find){
        int count=0;
        int index=text.indexOf(find,0);
        while(index!=-1){
            index+=find.length();
            index = text.indexOf(find,index);
            count++;
        }
        return count;
    }
    public static String replaseNum(String s) {
        s = s.replace("1", "один");
        s = s.replace("2", "два");
        s = s.replace("3", "три");
        s = s.replace("4", "четыре");
        s = s.replace("5", "пять");
        s = s.replace("6", "шесть");
        s = s.replace("7", "семь");
        s = s.replace("8", "восемь");
        s = s.replace("9", "девять");
        s = s.replace("0", "ноль");
        return s;
    }
    public static StringBuilder deleteSymbol(StringBuilder text){
        for(int i=1; i<text.length(); i++){
            text.delete(i,i+1);
        }
        return text;
    }
    public static String beginEnd(String textA){
        StringBuilder text = new StringBuilder(textA);
        char[] symbol = new char [1];
        int beginA=-1;
        int endA=0;
        int beginB=-1;
        int endB=0;
        if(text.length()>0){
            text.getChars(0, 1, symbol, 0);
        }
        for(int i=0; i<text.length() && (symbol[0]!=' ' || beginA==-1) ;i++){
           text.getChars(i, i+1, symbol, 0);
           if(beginA==-1 && symbol[0]!=' ')beginA = i;
           if(beginA!=-1 && symbol[0]==' ')endA=i;
        }
        if(beginA>endA) endA=text.length();
        for(int i=text.length(); i>endA && (symbol[0]!=' ' || beginB==-1) ;i--){
           text.getChars(i-1, i, symbol, 0);
           if(beginB==-1 && symbol[0]!=' ')beginB = i;
           if(beginB!=-1 && symbol[0]==' ')endB=i;
        }
        if(beginA!=-1 && beginB!=-1){    
            char[] wordA = new char[endA-beginA];
            char[] wordB = new char[beginB-endB];
            text.getChars(beginA,endA,wordA,0);
            text.getChars(endB,beginB,wordB,0);
            text.delete(beginA,endA);
            text.delete(endB-(endA-beginA),beginB-(endA-beginA));
            text.insert(beginA, wordB);
            text.insert(endB-(endA-beginA)+(beginB-endB), wordA);
        }
        return text.toString();
    }
    public static String replaseNum16(String textA){
        StringBuilder text = new StringBuilder(textA);
        int index = text.indexOf("0x",0);
        while(index!=-1){
            index+=2;
            boolean flag = true;
            int i=index;
            for(; i<index+8 && flag && i<text.length(); i++){
                char q = text.charAt(i);
                if(q==' ' || (q!='A' && q!='a' && q!='B' && q!='b' && q!='C' && q!='c' && q!='D' && q!='d' && q!='E' && q!='e' && q!='F' && q!='f'
                        && q!='0' && q!='1' && q!='2' && q!='3' && q!='4' && q!='5' && q!='6' && q!='7' && q!='8' && q!='9')) flag=false;
            }
            if(i-1!=index){
                char[] num = new char [i-index-1];
                text.getChars(index, i-1, num, 0);
                String temp = new String(num);
                int result = Integer.parseInt(temp, 16);
                text.delete(index-2,i-1);
                text.insert(index-2, result);
            }else{
                index++;
            }
            index=text.indexOf("0x",index);
        }
        return text.toString();
    }
}
