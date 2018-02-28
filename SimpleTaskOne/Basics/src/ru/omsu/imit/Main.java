package ru.omsu.imit;

import java.util.Scanner;

public class Main {
    public static void console(){
        System.out.println("Hello world!");
    }
    public static void consoleDouble(){
        double one,two,three;
        Scanner number = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        one = number.nextDouble();
        System.out.print("Введите второе число: ");
        two = number.nextDouble();
        System.out.print("Введите третье число: ");
        three = number.nextDouble();
        System.out.printf("Произведение: %f", one*two*three);
        System.out.printf("Среднее арифметическое: %f",(one+two+three)/3);
        System.out.print("Числа по возрастанию: ");
        if(one<two){
            if(one<three){
                System.out.printf("%f ", one);
                if(two<three){
                    System.out.printf("%f %f ", two,three);
                }else{
                    System.out.printf("%f %f", three, two);
                }
            }else{
                System.out.printf("%f %f %f", three,one,two);
            }
        }else{
            if(two<three){
                System.out.printf("%f ", two);
                if(one<three){
                    System.out.printf("%f %f", one, three);
                }else{
                    System.out.printf("%f %f", three, one);
                }
            }else{
                System.out.printf("%f %f %f", three, two, one);
            }
        }
        System.out.print("\n");
    }
    public static void consoleInt(){
        int one,two,three;
        Scanner number = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        one = number.nextInt();
        System.out.println("Введите второе число: ");
        two = number.nextInt();
        System.out.println("Введите третье число: ");
        three = number.nextInt();
        System.out.print("Произведение: ");
        System.out.println(one*two*three);
        System.out.print("Среднее арифметическое: ");
        System.out.println((one+two+three)/3);
        System.out.print("Числа по возрастанию: ");
        if(one<two){
            if(one<three){
                System.out.printf("%d ", one);
                if(two<three){
                    System.out.printf("%d %d ", two,three);
                }else{
                    System.out.printf("%d %d", three, two);
                }
            }else{
                System.out.printf("%d %d %d", three,one,two);
            }
        }else{
            if(two<three){
                System.out.printf("%d ", two);
                if(one<three){
                    System.out.printf("%d %d", one, three);
                }else{
                    System.out.printf("%d %d", three, one);
                }
            }else{
                System.out.printf("%d %d %d", three, two, one);
            }
        }
        System.out.print("\n");
    }
    public static void discriminant(){
        double a,b,c,discrim;
        Scanner number = new Scanner(System.in);
        System.out.println("Введите a: ");
        a = number.nextDouble();
        System.out.println("Введите b: ");
        b = number.nextDouble();
        System.out.println("Введите c: ");
        c = number.nextDouble();

        if(a!=0){
            discrim = (b*b)-(4*a*c);
            System.out.printf("Дискриминант: %f\n",discrim);
            if(discrim>0){
                System.out.println("Уравнение имеет два корня!");
                System.out.printf("Первый корень: %f\n", (-b+Math.sqrt(discrim))/2*a);
                System.out.printf("Второй корень: %f\n", (-b-Math.sqrt(discrim))/2*a);
            }else{
                if(discrim==0){
                    System.out.print("Уравнение имеет один корень!");
                    System.out.printf("Корень: %f\n", -b/2*a);
                }else{
                    System.out.print("Уравнение не имеет корней!\n");
                }
            }
        }else{
            if(a==0 && b!=0){
                System.out.printf("Ответ: x = %f",c/-b);
            }
        }
    }
    public static void mathSin(){
        double borderA,borderB,step;
        Scanner number = new Scanner(System.in);
        System.out.println("Введите границу начала табулирования: ");
        borderA = number.nextDouble();
        System.out.println("Введите границу конца табулирования: ");
        borderB = number.nextDouble();
        System.out.println("Введите шаг табулирования: ");
        step = number.nextDouble();
        for(double i=borderA; i<=borderB || Math.abs(i-borderB)<1e-9; i+=step){
            System.out.printf("Аргумент: %f Функция: %f\n",i,Math.sin(i));
        }
    }
    public static void liner(){
        // Вид уравнений x + y + c = 0
        // с - сводный член
        double x[] = new double [7];
        Scanner number = new Scanner(System.in);
        System.out.println("[Первое уравнение] Введите коэффициент перед x: ");
        x[0] = number.nextDouble();
        System.out.println("[Первое уравнение] Введите коэффициент перед y: ");
        x[1] = number.nextDouble();
        System.out.println("[Первое уравнение] Введите свободный член: ");
        x[2] = number.nextDouble();
        System.out.println("[Второе уравнение] Введите коэффициент перед x: ");
        x[3] = number.nextDouble();
        System.out.println("[Второе уравнение] Введите коэффициент перед y: ");
        x[4] = number.nextDouble();
        System.out.println("[Второе уравнение] Введите свободный член: ");
        x[5] = number.nextDouble();
        if(x[0]!=0 && x[1]!=0 && x[3]!=0 && x[4]!=0){
            x[1]=-x[1]/x[0];
            x[2]=-x[2]/x[0];
            if((-x[4]+(-(x[1]*x[3])))!=0){
                x[6]=((x[2]*x[3])+x[5])/(-x[4]+(-(x[1]*x[3])));
                System.out.printf("Ответ: x = %f,y = %f",x[6]*x[1]+x[2],x[6]);
            }else{
                System.out.printf("Нет решений!\n");
            }
        }
        if(x[0]==0 && x[1]!=0 && x[3]!=0 && x[4]!=0){
            x[6]=x[2]/-x[1];
            System.out.printf("Ответ: x = %f, y = %f",(x[4]*x[6]+x[5])/-x[3],x[6]);
        }
        if(x[0]!=0 && x[1]==0 && x[3]!=0 && x[4]!=0){
            x[6]=x[2]/-x[0];
            System.out.printf("Ответ: x = %f, y = %f",x[6],((x[3]*x[6])+x[5])/-x[4]);
        }
        if(x[0]!=0 && x[1]!=0 && x[3]==0 && x[4]!=0){
            x[6]=x[5]/-x[4];
            System.out.printf("Ответ: x = %f, y = %f",(x[1]*x[6]+x[2])/-x[0],x[6]);
        }
        if(x[0]!=0 && x[1]!=0 && x[3]!=0 && x[4]==0){
            x[6]=x[5]/-x[3];
            System.out.printf("Ответ: x = %f, y = %f",x[6],(x[0]*x[6]+x[2])/-x[1]);
        }
        if(x[0]==0 && x[1]==0 && x[3]!=0 && x[4]!=0){
            throw new NullPointerException("Невозможно решить данную систему!\n");
        }
        if(x[0]==0 && x[1]!=0 && x[3]==0 && x[4]!=0){
            if(Math.abs((x[2]/-x[1])-(x[5]/-x[4]))>1e-9){
                throw new NullPointerException("Нет общих решений!\n");
            }else{
                System.out.printf("x = R, y = %f\n",x[2]/-x[1]);
            }
        }
        if(x[0]==0 && x[1]!=0 && x[3]!=0 && x[4]==0){
            System.out.printf("x = %f, y = %f\n",x[5]/-x[3],x[2]/-x[1]);
        }
        if(x[0]!=0 && x[1]==0 && x[3]==0 && x[4]!=0){
            System.out.printf("x = %f, y = %f\n",x[2]/-x[0],x[5]/-x[4]);
        }
        if(x[0]!=0 && x[1]==0 && x[3]!=0 && x[4]==0){
            if(Math.abs((x[2]/-x[0])-(x[5]/-x[3]))>1e-9){
                throw new NullPointerException("Нет общих решений!\n");
            }else{
                System.out.printf("x = %f, y = R\n",x[2]/-x[0]);
            }
        }
        if(x[0]!=0 && x[1]!=0 && x[3]==0 && x[4]==0){
            throw new NullPointerException("Невозможно решить данную систему!\n");
        }
        if(x[0]==0 && x[1]==0 && x[3]==0 && x[4]!=0){
            System.out.printf("x = R, y = %f\n",x[5]/-x[4]);
        }
        if(x[0]==0 && x[1]==0 && x[3]!=0 && x[4]==0){
            System.out.printf("x = %f, y = R\n",x[5]/-x[3]);
        }
        if(x[0]!=0 && x[1]==0 && x[3]==0 && x[4]==0){
            System.out.printf("x = %f, y = R\n",x[2]/-x[0]);
        }
        if(x[0]==0 && x[1]!=0 && x[3]==0 && x[4]==0){
            System.out.printf("x = R, y = %f\n",x[2]/-x[1]);
        }
        if(x[0]==0 && x[1]==0 && x[3]==0 && x[4]!=0){
            System.out.printf("x = R, y = %f\n",x[5]/-x[4]);
        }
        if(x[0]==0 && x[1]==0 && x[3]==0 && x[4]==0){
            System.out.println("x = R, y = R");
        }
    }
    public static int fuct(int n){
        if(n==0) return 1;
        else return n*fuct(n-1);
    }
    public static void exp(){
        double eps;
        int pow=2;
        int count=0;
        double summ=1;
        Scanner number = new Scanner(System.in);
        do{
            System.out.println("Введите точность: ");
            eps = number.nextDouble();
        }while(eps<=0);
        do{
            System.out.println("Введите степень: ");
            count=number.nextInt();
        }while(count<0);
        double temp = Math.pow(count,pow-1)/fuct(pow-1); summ+=temp;
        System.out.printf("Текущий элемент: %f Сумма: %f\n",temp,summ);
        while(temp>eps){
            temp*=(double)count/pow;
            summ+=temp;
            System.out.printf("Текущий элемент: %f Сумма: %f\n",temp,summ);
            pow++;
        }
        System.out.printf("Результат: %.22f Последний член: %.9f\n", summ,temp);
    }
    public static void main(String[] args) {
        //console(); // 1 Задание
        //consoleDouble(); // 2 Задание
        //consoleInt(); // 3 Задание
        //discriminant(); // 4 Задание
        //mathSin(); // 5 Задание
        //liner(); // 6 Задание
        //exp(); // 7 Задание
    }
}