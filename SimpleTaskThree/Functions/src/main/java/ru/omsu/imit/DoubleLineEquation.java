package ru.omsu.imit;

public class DoubleLineEquation implements Function {
    private double borderA;
    private double borderB;
    private double[] param = new double[4];
    public DoubleLineEquation(double a,double b,double c,double d,double borderA,double borderB){
        if(borderA>borderB) throw new IllegalArgumentException("Некорректный отрезок!");
        this.borderA=borderA;
        this.borderB=borderB;
        param[0]=a;
        param[1]=b;
        param[2]=c;
        param[3]=d;
    }
    public double decideFunction(double x){
        if(x<borderA || x>borderB) throw new IllegalArgumentException("Функция не определена!");
        if((param[2]*x)+param[3]==0) throw new IllegalArgumentException("Невозможно вычислить!");
        return ((param[0]*x)+param[1])/((param[2]*x)+param[3]);
    }
    public double getBorderA(){
        return borderA;
    }
    public double getBorderB(){
        return borderB;
    }
}
