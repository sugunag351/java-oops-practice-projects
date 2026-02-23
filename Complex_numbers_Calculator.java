package Complex_Number_Calculator;
import java.util.Scanner;
public class Complex_numbers_Calculator
{
      public static void main(String[] args)
      {
          Scanner s=new Scanner(System.in);
          int real1=s.nextInt();
          int imaginary1=s.nextInt();

          int real2=s.nextInt();
          int imaginary2=s.nextInt();

          ComplexNumbers c1=new ComplexNumbers(real1,imaginary1);
          ComplexNumbers c2=new ComplexNumbers(real2,imaginary2);

          int choice=s.nextInt();

          if(choice==1)
          {
              //Add
              c1.plus(c2);
              c1.print();
          }
          else if(choice==2)
          {
              //Multiply
              c1.multiply(c2);
              c1.print();
          }


      }
}
class ComplexNumbers
{
    int real;
    int imaginary;
    public ComplexNumbers(int real,int imaginary)
    {
        this.real=real;
        this.imaginary=imaginary;
    }
    public void plus(ComplexNumbers c2)
    {
        this.real=this.real+c2.real;
        this.imaginary=this.imaginary+c2.imaginary;
    }
    public void print()
    {
        System.out.println(this.real+" "+"+"+" "+"i"+this.imaginary);
    }
    public void multiply(ComplexNumbers c2)
    {
        int a=this.real;
        int b=this.imaginary;
        int c=c2.real;
        int d=c2.imaginary;

        this.real= a*c - b*d;
        this.imaginary=a*d + b*c;
    }
}
