package ru.omsu.imit;
public class Vector3DArray {
    private Vector3D[] array;
    public Vector3DArray(int n){
        if(n<0){
            throw new IllegalArgumentException("Не возможно создать массив данной длины!");
        }
        array = new Vector3D [n];
        for(int i=0; i<n;i++){
            array[i] = new Vector3D();
        }
    }
    public int getLength(){
        return array.length;
    }
    public void setVector(Vector3D vector,int index){
        if(vector==null){
            throw new IllegalArgumentException("Объект не создан!");
        }
        if(index>array.length || index<0){
            throw new ArrayIndexOutOfBoundsException("Вектора с данным индексом не существует!");
        }
        array[index].setI(vector.getI());
        array[index].setJ(vector.getJ());
        array[index].setK(vector.getK());
    }
    public double getMaxLength(){
        double vectorLength=0;
        for(int i=0; i<array.length; i++){
            double temp = array[i].lenght();
            if(temp>vectorLength) vectorLength=temp;
        }
        return vectorLength;
    }
    public int findVector(Vector3D vector){
        int index = -1;
        if(vector==null){
            throw new IllegalArgumentException("Объект не создан!");
        }  
        for(int i=0;i<array.length && index==-1;i++){
            if(array[i].equals(vector)){
                index=i;
            }
        }
        return index;
    }
    public Vector3D getAllAddition(){
        Vector3D addition = new Vector3D();
        for(int i=0; i<array.length; i++){
            addition = Vector3DProcessor.addition(addition,array[i]);
        }
        return addition;
    }
    public void getLinerCombination(double[] keys){
        if(keys.length!=array.length){
            throw new IllegalArgumentException("Массив коэффициентов не соответствует массиву векторов!");
        
        }
        for(int i=0; i<array.length; i++){
            array[i].setI(array[i].getI()*keys[i]);
            array[i].setJ(array[i].getJ()*keys[i]);
            array[i].setK(array[i].getK()*keys[i]);
        }
    }
    public String toString(int index) {
        if(index>array.length || index<0){
            throw new ArrayIndexOutOfBoundsException("Вектора с данным индексом не существует!");
        }
        return array[index].toString();
    }
    public Point3D[] goTo(Point3D x){
        if(x==null){
            throw new IllegalArgumentException("Объект не создан!");
        }
        Point3D[] temp = new Point3D [array.length];
        for(int i=0; i<array.length;i++){
            temp[i] = new Point3D();
            temp[i].setX( array[i].getI() + x.getX());
            temp[i].setY( array[i].getJ() + x.getY());
            temp[i].setZ( array[i].getK() + x.getZ());
        }
        return temp;
    }
}
