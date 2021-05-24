/* 
Raahi Kadu 
C2201922361
*/
import java.util.*;
class Node //person class
{
    Node root=null;
    Node left=null;
    Node right=null;
    String name,telephone;
    int h;                          
    Node(String n,String t)         
    {
        name=n;
        telephone=t;
        left=right=null;
        h=0;
    }
    Node()                          
    {
        root=left=right=null;
        h=0;
    }
}
class AVL 
{
    Node root;
    AVL()
    {
        root=null;
    }
    int height(Node n)              
    {
        if (n == null)
            return 0;
        return n.h;
    }
    int max(int a, int b)           
    {
        return (a > b) ? a : b;
    }
    
    int balanceFactor(Node N)
    {
        if (N == null)
            return 0;
 
        return (height(N.left) - height(N.right));
    } 
    
    int ASCII(char c)               
    {
        return (int) c;
    }
    
    Node LL(Node ptr)
    {
        Node y = ptr.right;
        Node T = y.left;
 
        // Perform rotation
        y.left = ptr;
        ptr.right = T;
 
        //  Update heights
        ptr.h = max(height(ptr.left), height(ptr.right)) + 1;
        y.h = max(height(y.left), height(y.right)) + 1;
 
        // Return new root
        return y;
    }
    Node RR(Node ptr)
    {
        Node x = ptr.left;
        Node T2 = x.right;
 
        // Perform rotation
        x.right = ptr;
        ptr.left = T2;
 
        // Update heights
        ptr.h = max(height(ptr.left), height(ptr.right)) + 1;
        x.h = max(height(x.left), height(x.right)) + 1;
 
        // Return new root
        return x;
    }
    Node LR(Node root)
    {
        root.left=RR(root.left);
        root=LL(root);
        return root;
    }
    Node RL(Node root)
    {
        root.right=LL(root.right);
        root=RR(root);
        return root;
    }
    
    Node insert(Node root,Node temp)
    {   
        int flag=0,balance;
        if (root == null)
            return temp;
            
        for(int i=0;i<temp.name.length();i++)          
        {   
            
            if(ASCII(temp.name.charAt(i)) == ASCII(root.name.charAt(i)))   
            {

            }
             if(ASCII(temp.name.charAt(i)) < ASCII(root.name.charAt(i)))
            {
                root.left = insert(root.left, temp);
                balance=balanceFactor(root);
                if(balance==2)
                {
                    if(ASCII(temp.name.charAt(i)) < ASCII(root.left.name.charAt(i)))
                        root=LL(root);
                    else
                        root=LR(root);
                }
                flag=1;                 
                break;
            }
            else if(ASCII(temp.name.charAt(i)) > ASCII(root.name.charAt(i)))
            {
                root.right = insert(root.right, temp);
                balance=balanceFactor(root);
                if(balance==2)
                {
                    if(ASCII(temp.name.charAt(i)) > ASCII(root.right.name.charAt(i)))
                        root=RR(root);
                    else
                        root=RL(root);
                }
                flag=1;
                break;
            }
          
        }
        if(flag==0)                                     
        {
            return root;
        }
     
        root.h = max(height(root.left),height(root.right));   
        return root;
        
    }
    
    void create()                        
    {
        Scanner sc=new Scanner(System.in);
        String name, telephone;
        char ans;
        do
        {
            System.out.println("Enter the name: ");
            name=sc.next();
            System.out.println("Enter the telephone number: ");
            telephone=sc.next();
            Node temp=new Node(name,telephone);
            root=insert(root,temp);
            System.out.println("Do you want to continue?(y/n)");
            ans=sc.next().charAt(0);
        }
        while(ans=='y'||ans=='Y');
    }
    
    void display(Node node)             
    {
        if (node == null)
        { 
            return;
        }
        display(node.left);
        System.out.println("------------------------------------");
        System.out.println("NAME: "+node.name+"\nTelephone no: " + node.telephone);
        //System.out.println("-----------------------------------");
        display(node.right);         
    }
}
public class Main
{
	public static void main(String[] args) 
	{
	    AVL record=new AVL();
	    Scanner sc = new Scanner(System.in);
	    int choice;
	    do {
	    	System.out.println("*******MENU******");
	    	System.out.println("0.EXIT");
	    	System.out.println("1.Create");
	    	System.out.println("2.Display");
	    	System.out.println("Enter your choice:");
	    	choice = sc.nextInt();
	    	switch(choice)
	    	{
	    	case 0:
	    		System.out.println("Exited");
	    		break;
	    	case 1:record.create();
	    	      break;
	    	case 2:
	    		System.out.println("*****CONTACTS*****");
	    	    record.display(record.root);
	    	    System.out.println("************");
	    	    break;
	    	 default:
	    		 System.out.println("Invalid choice");
	    		 break;
	    	}
	    }while(choice != 0);
	    
	}
}
/*
*******MENU******
0.EXIT
1.Create
2.Display
Enter your choice:
1
Enter the name: 
raahi
Enter the telephone number: 
78888 033387
Do you want to continue?(y/n)
y
Enter the name: 
anshika
Enter the telephone number: 
46581793802
Do you want to continue?(y/n)
y
Enter the name: 
rucha
Enter the telephone number: 
4568219068
Do you want to continue?(y/n)
y
Enter the name: 
sejal
Enter the telephone number: 
7629493063
Do you want to continue?(y/n)
y
Enter the name: 
grishma
Enter the telephone number: 
837419280587
Do you want to continue?(y/n)
y
Enter the name: 
sai
Enter the telephone number: 
4386190021085
Do you want to continue?(y/n)
y
Enter the name: 
saavi
Enter the telephone number: 
3478853290
Do you want to continue?(y/n)
n
*******MENU******
0.EXIT
1.Create
2.Display
Enter your choice:
2
*****CONTACTS*****
------------------------------------
NAME: anshika
Telephone no: 46581793802
------------------------------------
NAME: grishma
Telephone no: 837419280587
------------------------------------
NAME: raahi
Telephone no: 7888033387
------------------------------------
NAME: rucha
Telephone no: 4568219068
------------------------------------
NAME: saavi
Telephone no: 3478853290
------------------------------------
NAME: sai
Telephone no: 4386190021085
------------------------------------
NAME: sejal
Telephone no: 7629493063
************
*******MENU******
0.EXIT
1.Create
2.Display
Enter your choice:
k 0
Exited
*/
