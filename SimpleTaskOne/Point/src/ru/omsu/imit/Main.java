package ru.omsu.imit;

public class Main {
    public static void testPoint3D(){
        Point3D one = new Point3D();
        System.out.println(one.toString());
        Point3D two = new Point3D(1,2,3);
        System.out.println(two.toString());
        one.setX(3.4);
        one.setY(1.4);
        one.setX(2.4);
        System.out.println(one.toString());
        double arr[] = new double[3];
        arr[0] = two.getX();
        arr[1] = two.getY();
        arr[2] = two.getZ();
        System.out.printf("Координаты второй точки: %f,%f,%f\n",arr[0],arr[1],arr[2]);
        if(one==two) System.out.println("Первая точка равна второй");
        else System.out.println("Первая точка НЕ равна второй");
        if(one==one) System.out.println("Первая точка равна сама себе");
        else System.out.println("Первая точка НЕ равна сама себе");
    }
    public static void testVector3D(){
        Vector3D one = new Vector3D();
        Vector3D three = new Vector3D(0,-2,-4);
        Vector3D two = new Vector3D(0,-2,-4);
        System.out.printf("Длина второго вектора: %f\n", two.lenght());
        System.out.printf("Первый и второй векторы равны? %b\n",two.equals(three));
        System.out.printf("Первый и тертий векторы равны? %b\n",one.equals(three));
    }
    public static void testVector3DProcessor(){
        boolean collinearity;
        Vector3D vComposition;
        double sComposition;
        Vector3D vAddition;
        Vector3D vSubtraction;
        Vector3D one = new Vector3D(0,-2,-4);
        Vector3D two = new Vector3D(-6,-8,-10);
        vAddition = Vector3DProcessor.addition(one, two);
        vSubtraction = Vector3DProcessor.subtraction(one, two);
        sComposition = Vector3DProcessor.scalarComposition(one,two);
        vComposition = Vector3DProcessor.vectorComposition(one,two);
        System.out.printf("Сумма векторов one и two: %f %f %f \n",vAddition.getI(),vAddition.getJ(),vAddition.getK());
        System.out.printf("Разность векторов one и two: %f %f %f \n",vSubtraction.getI(),vSubtraction.getJ(),vSubtraction.getK());
        System.out.printf("Векторное произведение векторов one и two: %f %f %f \n",vComposition.getI(),vComposition.getJ(),vComposition.getK());
        System.out.printf("Скалярное произведение векторов one и two: %f \n",sComposition);
        Vector3D tOne = new Vector3D(1,2,3);
        Vector3D tTwo = new Vector3D(4,-8,12);
        collinearity = Vector3DProcessor.vectorCollinearity(one,two);
        System.out.printf("Вектора one и two коллинеарны? %b \n",collinearity);
        collinearity = Vector3DProcessor.vectorCollinearity(tOne, tTwo);
        System.out.printf("Вектора tOne и tTwo коллинеарны? %b \n",collinearity);
        Point3D[] array;

    }
    public static void testVector3DArray(){
        Vector3DArray one = new Vector3DArray(2);
        one.setVector(new Vector3D(1,1,1), 0);
        one.setVector(new Vector3D(2,2,2), 1);
        Point3D[] array;
        array = one.goTo(new Point3D(1,1,1));
        double max = one.getMaxLength();
        double[] keys = new double [2];
        for(int i=0; i<2; i++){
            keys[i]=i+2;
        }
        System.out.printf("Сумма всех векторов: %s",(one.getAllAddition()).toString());
        System.out.printf("Максимальная длина векторов в массиве: %f\n",max);
        System.out.printf("Индекс искомого вектора: %d\n",one.findVector(new Vector3D(1,1,1)));
        for(int i=0; i<2; i++){
            System.out.print(one.toString(i));
        }
        for(int i=0; i<2; i++){
            System.out.print(array[i].toString());
        }
        one.getLinerCombination(keys);
        System.out.println("Массив векторов:");
        for(int i=0;i<2;i++){
            System.out.print(one.toString(i));
        }
    }
    public static double areaTrialngle(Vector3D one,Vector3D two){
        return Vector3DProcessor.vectorComposition(one, two).lenght()*0.5;
    }
    public static void main(String[] args) {
        //testPoint3D();
        //testVector3D();
        //testVector3DProcessor();
        //testVector3DArray();
        System.out.printf("Площадь: %f\n",areaTrialngle(new Vector3D(1,1,1),new Vector3D(4,0,0)));
    }

}
