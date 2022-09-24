package main;

public class QuadraticEquation2 {
    private float a;
    private float b;
    private float c;

    public static void main(String[] args) {

    }

    public QuadraticEquation2() {
    }

    public QuadraticEquation2(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public float denta()
    {
        return b*b-4*a*c;
    }

    public void giaiPT()
    {
        if(denta()<0)
        {
            System.out.println("Vo nghiem!");
        }
        else
        if(denta()==0)
        {

            System.out.println("Nghiem kep x1=x2="+getX1());
        }
        else
        {
            System.out.println("Hai nghiem phan biet:");
            System.out.println("x1="+getX1() +", x2="+getX2());
        }
    }

    public float getX1()
    {
        if(denta()==0)
            return -b/2*a;
        return (float)((-b+Math.sqrt(denta()))/(2*a));
    }

    public float getX2()
    {
        if(denta()==0)
            return -b/2*a;
        return (float)((-b-Math.sqrt(denta()))/(2*a));
    }

    public float getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public float getC() {
        return c;
    }

    public void setC(float c) {
        this.c = c;
    }
}
