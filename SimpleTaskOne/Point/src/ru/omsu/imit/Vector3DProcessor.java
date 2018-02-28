package ru.omsu.imit;
public class Vector3DProcessor {
    public static Vector3D addition(Vector3D x,Vector3D y){
        Vector3D temp = new Vector3D();
        if(x==null || y==null ){
            System.out.println("Не все объекты созданы!");
            temp=null;
        }else{
            temp.setI(x.getI()+y.getI());
            temp.setJ(x.getJ()+y.getJ());
            temp.setK(x.getK()+y.getK());
        }
        return(temp);
    }
    public static Vector3D subtraction(Vector3D x,Vector3D y){
        Vector3D temp = new Vector3D();
        if(x==null || y==null ){
            System.out.println("Не все объекты созданы!");
            temp=null;
        }else{
            temp.setI(x.getI()-y.getI());
            temp.setJ(x.getJ()-y.getJ());
            temp.setK(x.getK()-y.getK());
        }
        return(temp);
    }
    public static double scalarComposition(Vector3D x, Vector3D y){
        double temp = 0;
        if(x==null || y==null ){
            System.out.println("Не все объекты созданы!");
        }else{
            temp+=x.getI()*y.getI();
            temp+=x.getJ()*y.getJ();
            temp+=x.getK()*y.getK();
        }
        return temp;
    }
    public static Vector3D vectorComposition(Vector3D x, Vector3D y){
        Vector3D temp = new Vector3D();
        if(x==null || y==null ){
            System.out.println("Не все объекты созданы!");
            temp=null;
        }else{
            temp.setI(x.getJ()*y.getK()-x.getK()*y.getJ());
            temp.setJ(x.getK()*y.getI()-x.getI()*y.getK());
            temp.setK(x.getI()*y.getJ()-x.getJ()*y.getI());
        }
        return temp;
    }
    public static boolean vectorCollinearity(Vector3D one, Vector3D two){
        if(one==null || two==null ){
            System.out.println("Не все объекты созданы!");
            return false;
        }
        double tempOne=0;
        double tempTwo=0;
        double tempThree=0;
        if(two.getI()!=0){
            tempOne = one.getI()/two.getI();
        }else{
            if(one.getI()!=0) return false;
        }
        if(two.getJ()!=0){
            tempTwo = one.getJ()/two.getJ();
        }else{
            if(one.getJ()!=0) return false;
        }
        if(two.getK()!=0){
            tempThree = one.getK()/two.getK();
        }else{
            if(one.getK()!=0) return false;
        }
        if(Equals.nextDouble(tempOne, tempTwo)){
            if(Equals.nextDouble(tempOne, tempThree)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
