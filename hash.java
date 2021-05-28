/*
RAAHI KADU
C22019221361
2359
ASSIGNMENT-HASH
*/
package hash;
import java.util.*;

class node//to store the elements
{
    int cl_no;//for clint number
    long ph_no;//for clint phone number
    node next;
    
    node(int cl_no,long ph_no)
    {
        this.cl_no=cl_no;
        this.ph_no=ph_no;
        next=null;     
    }
}
class chaining
{
    
    Scanner sc = new Scanner(System.in);
    node head[]=new node[10];
   
    void insert(int max)//to insert the elements
    {
        System.out.println("Enter the Clint Number");
        int c=sc.nextInt();
        System.out.println("Enter the Phone Number");
        long p=sc.nextLong();
        
        node temp=new node(c,p);//new node initialized
        int hv = c % max;//the hash function
        node ptr;
        if(head[hv]==null)//if head is null then insert at firdt position
        {
            head[hv]=temp;
        }
        else
        {
            ptr=head[hv];
            while(ptr.next!=null)//else traverse upto the last node
            {
                ptr=ptr.next;
            }
            ptr.next=temp;//then insert next to it
        }
    }
    
    void search(int max)//to search an element
    {
        int tc=0;
        System.out.println("Enter the Clint Number you want to search");
        tc=sc.nextInt();//temperory clint number
        int thv=0;
        thv = tc % max;//temporary hash function
        node ptr=head[thv];
        int flag=0;
        while(ptr!=null)//traverse entire list
        {
            if(ptr.cl_no==tc)//if we get the clint number
            {
                flag=1;//set flag as 1
                System.out.println("Clint Number is Found");
                System.out.println("Clint Phone Number is : "+ptr.ph_no);
                
            }
            ptr=ptr.next;
        }
        if(flag==0)
        {
            System.out.println("No Clint of searched Number is Present");
        }
        
    }
    
    void display(int max)//to display the entire list
    {
        node ptr;
        for(int i=0;i<max;i++)
        {
            ptr=head[i];
            System.out.print("   "+i+"-->");
            
            //System.out.println("---------------------------------------------");
            while(ptr!=null)
            {
                System.out.print("\t  [Clint No."+ptr.cl_no+",Phone No."+ptr.ph_no+"]");
           
                ptr=ptr.next;
            }
            System.out.println();
            //System.out.println("---------------------------------------------");
        }
    }
    
    void delete(int max)//to delete an element
    {
        System.out.println("Enter the Clint Number you want to delete");
        int tc=sc.nextInt();//temporary clint number
        int thv=tc % max;//the hash value
        node ptr=head[thv];//check the list of that hash value
        if(ptr.cl_no==tc)//if its start of the list
        {
            head[thv]=head[thv].next;
        }
        ptr=ptr.next;
        node prev=head[thv];
        while(ptr!=null)//traverse whole list
        {
            if(ptr.cl_no==tc)//if we get the clint number
            {
                prev.next=ptr.next;
            }
            prev=ptr;//store the previous node
            ptr=ptr.next;
        }
    }
}
public class Hash
{
    public static void main(String[] args)
    {
        int n=0;
        Scanner sc = new Scanner(System.in);
        int ch=0;
        System.out.println("Enter the number of elements");
        n=sc.nextInt();
        
        chaining c=new chaining();
        System.out.println("Enter the Table Size");
        int max=sc.nextInt();
        do
        {
            System.out.println("MENU");
            System.out.println("1.Insert The Elements in The Hash Table");
            System.out.println("2.Display The Hash Table");
            System.out.println("3.Search An Element");
            System.out.println("4.Delete An Element");
            System.out.println("Enter your Choice");
            ch=sc.nextInt();
            switch(ch)
            {
                case 1:
                    for(int i=0;i<n;i++)
                    {
                        c.insert(max);
                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.println("-----------------------------------------");
                    System.out.println("Location  [Clint Number,Phone Number]");
                    c.display(max);
                    System.out.println("------------------------------------------");
                    System.out.println();
                    break;
                case 3:
                    c.search(max);
                    System.out.println();
                    break;
                case 4:
                    c.delete(max);
                    System.out.println("-----------------------------------------");
                    System.out.println("Location  [Clint Number,Phone Number]");
                    c.display(max);
                    System.out.println("------------------------------------------");
                    System.out.println();
                    break;
                default:
                    System.out.println("Thank You!");
                    break;
            }
        }while(ch>=1 && ch<=4);     
    }
}

/*
Output:
Enter the number of elements
11
Enter the Table Size
10
MENU
1.Insert The Elements in The Hash Table
2.Display The Hash Table
3.Search An Element
4.Delete An Element
Enter your Choice
1
Enter the Clint Number
12
Enter the Phone Number
9876543210
Enter the Clint Number
89
Enter the Phone Number
9638527410
Enter the Clint Number
78
Enter the Phone Number
9856320147
Enter the Clint Number
58
Enter the Phone Number
8569741230
Enter the Clint Number
31
Enter the Phone Number
7894561230
Enter the Clint Number
88
Enter the Phone Number
8569741230
Enter the Clint Number
56
Enter the Phone Number
7894561230
Enter the Clint Number
37
Enter the Phone Number
8956230147
Enter the Clint Number
45
Enter the Phone Number
8520369741
Enter the Clint Number
3
Enter the Phone Number
7896325410
Enter the Clint Number
62
Enter the Phone Number
7897854632

MENU
1.Insert The Elements in The Hash Table
2.Display The Hash Table
3.Search An Element
4.Delete An Element
Enter your Choice
2
-----------------------------------------
Location  [Clint Number,Phone Number]
   0-->
   1-->	  [Clint No.31,Phone No.7894561230]
   2-->	  [Clint No.12,Phone No.9876543210]	  [Clint No.62,Phone No.7897854632]
   3-->	  [Clint No.3,Phone No.7896325410]
   4-->
   5-->	  [Clint No.45,Phone No.8520369741]
   6-->	  [Clint No.56,Phone No.7894561230]
   7-->	  [Clint No.37,Phone No.8956230147]
   8-->	  [Clint No.78,Phone No.9856320147]	  [Clint No.58,Phone No.8569741230]	  [Clint No.88,Phone No.8569741230]
   9-->	  [Clint No.89,Phone No.9638527410]
------------------------------------------

MENU
1.Insert The Elements in The Hash Table
2.Display The Hash Table
3.Search An Element
4.Delete An Element
Enter your Choice
3
Enter the Clint Number you want to search
37
Clint Number is Found
Clint Phone Number is : 8956230147

MENU
1.Insert The Elements in The Hash Table
2.Display The Hash Table
3.Search An Element
4.Delete An Element
Enter your Choice
4
Enter the Clint Number you want to delete
58
-----------------------------------------
Location  [Clint Number,Phone Number]
   0-->
   1-->	  [Clint No.31,Phone No.7894561230]
   2-->	  [Clint No.12,Phone No.9876543210]	  [Clint No.62,Phone No.7897854632]
   3-->	  [Clint No.3,Phone No.7896325410]
   4-->
   5-->	  [Clint No.45,Phone No.8520369741]
   6-->	  [Clint No.56,Phone No.7894561230]
   7-->	  [Clint No.37,Phone No.8956230147]
   8-->	  [Clint No.78,Phone No.9856320147]	  [Clint No.88,Phone No.8569741230]
   9-->	  [Clint No.89,Phone No.9638527410]
------------------------------------------

MENU
1.Insert The Elements in The Hash Table
2.Display The Hash Table
3.Search An Element
4.Delete An Element
Enter your Choice
5
Thank You!

*/
