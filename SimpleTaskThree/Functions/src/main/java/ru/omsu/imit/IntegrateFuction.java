package ru.omsu.imit;

public class IntegrateFuction implements Fanctional<Function> {
    public double decideFanctional(Function fun,double a,double b) {
        if(a>b) throw new IllegalArgumentException("Некорректный отрезок!");
        double res=0;
        int n = 1000;
        double h = (b-a)/n;
        for(int i=0; i<n; i++){
            res += fun.decideFunction(a + h * (i + 0.5));
        }
        res*=h;
        return res;
    }
}
