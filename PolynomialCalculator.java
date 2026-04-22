import java.util.*;
class Polynomial {


    /* This function sets coefficient for a particular degree value, if degree is not there in the polynomial
     *  then corresponding term with specified degree and value is added int the polynomial. If the degree
     *  is already present in the polynomial then previous coefficient is replaced by
     *  new coefficient value passed as function argument
     */
    private int degCoeff[];
    public Polynomial()
    {
        degCoeff=new int[10];
    }

    public void setCoefficient(int degree, int coeff){
        if(degree>=degCoeff.length)
        {
            incDegCoeff(degree);
        }
        degCoeff[degree]=degCoeff[degree]+coeff;
    }

    private void  incDegCoeff(int degree)
    {
        int temp[]=degCoeff;
        degCoeff=new int[degree+1];
        for(int i=0;i<temp.length;i++)
        {
            degCoeff[i]=temp[i];
        }
    }

    // Prints all the terms(only terms with non zero coefficients are to be printed) in increasing order of degree.
    public void print(){
        for(int i=0;i<degCoeff.length;i++)
        {
            if(degCoeff[i]!=0)
            {
                System.out.print(degCoeff[i]+"x"+i+" ");
            }
        }
        System.out.println();
    }


    // Adds two polynomials and returns a new polynomial which has result
    public Polynomial add(Polynomial p){
        Polynomial res=new Polynomial();
        int i=0,j=0;
        while(i<this.degCoeff.length  &&  j<p.degCoeff.length)
        {
            res.setCoefficient(i,this.degCoeff[i]+p.degCoeff[j]);
            i++;
            j++;
        }
        while(i<this.degCoeff.length)
        {
            res.setCoefficient(i,this.degCoeff[i]);
            i++;
        }
        while(j<p.degCoeff.length)
        {
            res.setCoefficient(j,p.degCoeff[j]);
            j++;
        }
        return res;
    }

    // Subtracts two polynomials and returns a new polynomial which has result
    public Polynomial subtract(Polynomial p){
        Polynomial res=new Polynomial();
        int i=0,j=0;
        while(i<this.degCoeff.length  &&  j<p.degCoeff.length)
        {
            res.setCoefficient(i,this.degCoeff[i]-p.degCoeff[j]);
            i++;
            j++;
        }
        while(i<this.degCoeff.length)
        {
            res.setCoefficient(i,this.degCoeff[i]);
            i++;
        }
        while(j<p.degCoeff.length)
        {
            res.setCoefficient(j,0-p.degCoeff[j]);
            j++;
        }
        return res;
    }

    // Multiply two polynomials and returns a new polynomial which has result
    public Polynomial multiply(Polynomial p){
        Polynomial res=new Polynomial();
        int i=0;
        while(i<this.degCoeff.length)
        {
            while(i<this.degCoeff.length && this.degCoeff[i]==0)
            {
                i++;
            }
            if(i==this.degCoeff.length)
            {
                break;
            }
            for(int j=0;j<p.degCoeff.length;j++)
            {
                if(p.degCoeff[j]!=0)
                {
                    res.setCoefficient(i+j ,this.degCoeff[i]*p.degCoeff[j]);
                }
            }
            i++;
        }
        return res;
    }
}
public class PolynomialCalculator
{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int degree1[] = new int[n];
        for(int i = 0; i < n; i++){
            degree1[i] = s.nextInt();
        }
        int coeff1[] = new int[n];
        for(int i = 0; i < n; i++){
            coeff1[i] = s.nextInt();
        }
        Polynomial first = new Polynomial();
        for(int i = 0; i < n; i++){
            first.setCoefficient(degree1[i],coeff1[i]);
        }
        n = s.nextInt();
        int degree2[] = new int[n];
        for(int i = 0; i < n; i++){
            degree2[i] = s.nextInt();
        }
        int coeff2[] = new int[n];
        for(int i = 0; i < n; i++){
            coeff2[i] = s.nextInt();
        }
        Polynomial second = new Polynomial();
        for(int i = 0; i < n; i++){
            second.setCoefficient(degree2[i],coeff2[i]);
        }
        int choice = s.nextInt();
        Polynomial result;
        switch(choice){
            // Add
            case 1:
                result = first.add(second);
                result.print();
                break;
            // Subtract
            case 2 :
                result = first.subtract(second);
                result.print();
                break;
            // Multiply
            case 3 :
                result = first.multiply(second);
                result.print();
                break;
        }

    }
}

