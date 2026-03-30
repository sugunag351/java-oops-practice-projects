package FractionClass;

public class FractionUse
{
     public static void main(String[] args)
     {
          Fraction f1=new Fraction(10,20);
          f1.increment();
          f1.print();
          Fraction f2=new Fraction(20,30);
          f1.add(f2);
          f1.print();
          Fraction f3=Fraction.add(f1,f2);
          f3.print();
     }
}
class Fraction
{
    private int numerator;
    private int denominator;
    public Fraction(int numerator, int denominator)
    {
        this.numerator=numerator;
        this.denominator=denominator;
        simplify();
    }
    private void simplify()
    {
        int gcd=1;
        int smaller=Math.min(numerator,denominator);
        for(int i=2;i<=smaller;i++)
        {
            if(numerator%i==0 && denominator%i==0)
            {
                gcd=i;
            }
        }
        numerator=numerator/gcd;
        denominator=denominator/gcd;
    }
    public void print()
    {
        System.out.println(numerator+"/"+denominator);
    }
    public void increment()
    {
        numerator=numerator+denominator;
        simplify();
    }
    //Adding two fractions and result is stored in first fraction
    public void add(Fraction f2)
    {
        this.numerator=this.numerator*f2.denominator + f2.numerator*this.denominator;
        this.denominator=this.denominator*f2.denominator;
        simplify();
    }
    //Adding two fractions and result is stored in another farction
    public static Fraction add(Fraction f1,Fraction f2)
    {
        int newNum=f1.numerator*f2.denominator + f1.denominator*f2.numerator;
        int newDen=f1.denominator*f2.denominator;
        Fraction f3=new Fraction(newNum,newDen);
        return f3;
    }
}
