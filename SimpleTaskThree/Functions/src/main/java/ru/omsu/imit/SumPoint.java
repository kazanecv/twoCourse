package ru.omsu.imit;

public class SumPoint implements Fanctional<Function> {
    public double decideFanctional(Function fun, double a, double b) {
        if(a>b) throw new IllegalArgumentException("Некорректный отрезок!");
        double res=0;
        res+=fun.decideFunction(a);
        res+=fun.decideFunction(b);
        res+=fun.decideFunction((b+a)/2);
        return res;
    }
}
