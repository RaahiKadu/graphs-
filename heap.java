/*
C n o= C22019221361
Roll No = 2359
Name = Raahi Kadu
*/
package heap;
import java.util.*;
import java.lang.*;
class solution
{
    int size;
    int maxsize;
    int h[];
    public solution(int maxsize)
    {
        this.maxsize=maxsize;
        this.size=0;
        this.h=new int[this.maxsize+1];
        h[0]=Integer.MAX_VALUE;
    }
   
    int parent(int pos)
    {
        return pos/2;
    }
   
    int leftchild(int pos)
    {
        return(2*pos);
    }
   
    int rightchild(int pos)
    {
        return ((2*pos)+1);
    }
    void insert(int b)
    {
        h[++size]=b;
        int current=size;
        while(h[current]>h[parent(current)])
        {
            swap(current,parent(current));
            current=parent(current);
        }
    }
   
    void print(int n)
    {
        int a=0;
        for(int i=1;i<=(size/2);i++)
        {
            if((size%2)==0 && i==((size/2)))
            {
                System.out.println(" PARENT : " + h[i] + " LEFT CHILD : " +
                      h[2 * i]);
                 
            }
            else
            {
                System.out.println(" PARENT : " + h[i] + " LEFT CHILD : " +
                      h[2 * i] + " RIGHT CHILD :" + h[2 * i + 1]);
                a=a+2;
            }
           
        }
    }
   
    void swap(int c,int d)
    {
        int temp;
        temp=h[c];
        h[c]=h[d];
        h[d]=temp;
    }
   
    void delete(int n)
    {
        int last=h[n];
        h[1]=last;
       
        size=size-1;
        del(n,1);
    }
   
    void del(int n,int i)
    {
        int root=i;
        int left=2*i;
        int right=((2*i)+1);
        if(left<n && h[left]>h[root])
        {
            root=left;
        }
        if(right<n && h[right]>h[root])
        {
            root=right;
        }
        if(root!=i)
        {
            int temp=h[i];
            h[i]=h[root];
            h[root]=temp;
            del(n,root);
        }
    }
   
   
    void printl(int n)
    {
        for(int i=1;i<n;i++)
        {
            System.out.print(h[i]+" ");
        }
        System.out.println();
    }
    void sort(int n)
    {
       int last=n-1;
       int first=1;
       swap(first,last);
       
       last=last-1;
       
       while(last>1)
       {
           size=0;
           for(int i=1;i<=last;i++)
           {
               insert(h[i]);
           }
           swap(first,last);
           last=last-1;
       }
     
    }
}



public class Heap
{

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of numbers you want to enter");
        int n=sc.nextInt();
        int a[]=new int[n];
        int ch=0;
        System.out.println("Enter the numbers");
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        solution s=new solution(n);
        do
        {
            System.out.println("Menu");
            System.out.println("1.Build a heap");
            System.out.println("2.Delete an element");
            System.out.println("3.Sort an array");
            System.out.println("Enter the choice");
            ch=sc.nextInt();
            switch(ch)
            {
                case 1:
                    for(int i=0;i<n;i++)
                    {
                        s.insert(a[i]);
                    }
                    System.out.println("Max Heap is :");
                    s.print(n);
                    System.out.println("=====================");
                    break;
                case 2:
                    s.delete(n);
                    s.print(n);
                    System.out.println("=====================");
                    break;
                case 3:
                    System.out.println("The Sorted Array is  :");
                    s.sort(n);
                    s.printl(n);
                    System.out.println("=====================");
                    break;
                   
            }
        }while(ch>=1 && ch<=3);
   
    }
   
}

/*

OUTPUT:
run:
Enter the number of numbers you want to enter
9
Enter the numbers
5
3
17
10
84
19
6
22
9
Menu
1.Build a heap
2.Delete an element
3.Sort an array
Enter the choice
1
Max Heap is :
 PARENT : 84 LEFT CHILD : 22 RIGHT CHILD :19
 PARENT : 22 LEFT CHILD : 17 RIGHT CHILD :10
 PARENT : 19 LEFT CHILD : 5 RIGHT CHILD :6
 PARENT : 17 LEFT CHILD : 3 RIGHT CHILD :9
=====================
Menu
1.Build a heap
2.Delete an element
3.Sort an array
Enter the choice
2
 PARENT : 22 LEFT CHILD : 17 RIGHT CHILD :19
 PARENT : 17 LEFT CHILD : 9 RIGHT CHILD :10
 PARENT : 19 LEFT CHILD : 5 RIGHT CHILD :6
 PARENT : 9 LEFT CHILD : 3
=====================
Menu
1.Build a heap
2.Delete an element
3.Sort an array
Enter the choice
3
The Sorted Array is  :
3 5 6 9 10 17 19 22 
=====================



*/
