import java.util.Scanner;

public class DynamicArrayUse
{
    public static void main(String[] args)
    {
         DynamicArray d=new DynamicArray();
         for(int i=1;i<10;i++)
         {
             d.addLast(100+i);
         }
         System.out.println(d.size());
         System.out.println(d.get(5));
         d.set(3,170);
         System.out.println(d.get(3));
         d.add(9,110);
         System.out.println(d.size());

        while(!d.isEmpty())
         {
             System.out.println(d.removeLast());
             System.out.println("Size_"+d.size());
         }

    }
}
class DynamicArray
{
    private int data[];
    private int nextElementIndex;
    public DynamicArray()
    {
        data=new int[5];
        nextElementIndex=0;
    }
    public int size()
    {
        return nextElementIndex;
    }
    public int get(int index)
    {
        if(index>=nextElementIndex)
        {
            return -1;
        }
         return data[index];
    }
    public boolean isEmpty()
    {
         if(nextElementIndex==0)
         {
             return true;
         }
         return false;
    }
    //Add Element at Last
    public void addLast(int ele)
    {
         if(nextElementIndex==data.length)
         {
             doubleCapacity();
         }
         data[nextElementIndex]=ele;
         nextElementIndex++;
    }
    private void doubleCapacity()
    {
        int temp[]=data;
        data=new int[2*temp.length];
        for(int i=0;i<temp.length;i++)
        {
            data[i]=temp[i];
        }
    }
    //Change the element at specific index
    public void set(int index,int ele)
    {
        if(index>=nextElementIndex)
        {
            return;
        }
        data[index]=ele;
    }
    //Remove element at last
    public int removeLast()
    {
        if(nextElementIndex==0)
        {
            return -1;
        }
        int temp=data[nextElementIndex-1];
        data[nextElementIndex-1]=0;
        nextElementIndex--;
        return temp;
    }
    //Add element at specific index
    public void add(int index,int ele)
    {
        if(index > nextElementIndex)
        {
            return;
        }
        if(nextElementIndex==data.length)
        {
            doubleCapacity();
        }
        for(int i=nextElementIndex-1;i>=index;i--)
        {
            data[i+1]=data[i];
        }
        data[index]=ele;
        nextElementIndex++;
    }
    //remove element at specific index
    public int remove(int index)
    {
       if(index+1==nextElementIndex)
       {
           return removeLast();
       }
       if(index>=nextElementIndex)
       {
           return -1;
       }
       int temp=data[index];
       for(int i=index+1;i<nextElementIndex;i++)
       {
           data[i-1]=data[i];
       }
       data[nextElementIndex-1]=0;
       nextElementIndex--;
       return temp;
    }
}
