package ru.omsu.imit;
public class Vector3D {
    private double i,j,k;
    public double getI(){
        return i;
    }
    public double getJ(){
        return j;
    }
    public double getK(){
        return k;
    }
    public void setI(double i){
        this.i=i;
    }
    public void setJ(double j){
        this.j=j;
    }
    public void setK(double k){
        this.k=k;
    }
    public Vector3D(){
        i=0;j=0;k=0;
    }
    public Vector3D(double i,double j,double k){
        this.i=i;
        this.j=j;
        this.k=k;
    }
    public Vector3D(Point3D one, Point3D two){
        this.i=two.getX() - one.getX();
        this.j=two.getY() - one.getY();
        this.k=two.getZ() - one.getZ();
    }
    public double lenght(){
        return (Math.sqrt(Math.pow(i,2)+Math.pow(j,2)+Math.pow(k,2)));
    }
    @Override
    public String toString() {
        return String.format("Vector3d I: %f J: %f K: %f\n",i,j,k);
    }
    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if(this.getClass() != other.getClass()) return false;
        Vector3D otherObj = (Vector3D)other;
        return(i==otherObj.getI() && j==otherObj.getJ() && k==otherObj.getK());
    }
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.i) ^ (Double.doubleToLongBits(this.i) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.j) ^ (Double.doubleToLongBits(this.j) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.k) ^ (Double.doubleToLongBits(this.k) >>> 32));
        return hash;
    }
}