/******************************************************************************


Assignment 2

Write a program to create a BST and perform following operations 
Find minimum or  maximum node in a tree
Display tree level wise
Display tree in descending order 
Count no. of leaf nodes recursive
(Extra operations: height, parent)

2359 C22019221361 Raahi Kadu 

*******************************************************************************/

//CODE:

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack; 


class node{
    node l,r;
    int data;
    
    public node(int d){
        l=null;
        r=null;
        data=d;
    }
}

class bt{
    node root;
    Scanner sc=new Scanner(System.in);
    
    public bt(){
        root=null;
    }

    void create(){
        int d;
        char ch;
        bt tree = new bt();
        do{
            // accept data
            System.out.print("Enter data : ");
            d = sc.nextInt();
            //create node
            node temp= new node(d);
            
            //btree is empty
            if(root==null){
                root = temp;
                System.out.println("Root node added!");
            }
            //btree isn't empty,a root node exists
            else{
                node ptr;
                ptr = root;
                while (ptr != null){
                    System.out.println("Current node Data : " + ptr.data);
                    if(ptr.data> d){
                        if (ptr.l == null){
                            ptr.l = temp;
                            System.out.println("Node added!!");
                            break;
                        }
                        else{
                            ptr = ptr.l;
                        }
                    }
                    else{
                        if (ptr.r == null){
                            ptr.r = temp;
                            System.out.println("Node added!!");
                            break;
                        }
                        else{
                            ptr = ptr.r;
                        }
                    }
                    
                }
            }
            System.out.print("\nDo you want to add more nodes ?(y/n) : ");
            ch = sc.next().charAt(0);
            System.out.println("");
        }while (ch != 'N' && ch != 'n');
    }//create ends
    
    //Maximum node
    void max_node(node localRoot){
        node ptr= root;
        while(ptr.l!=null){
            ptr=ptr.r;
        }
        System.out.print(ptr.data + " ");
    }
    
    //Minimum node
    void min_node(node localRoot){
        node ptr= root;
        while(ptr.l!=null){
            ptr=ptr.l;
        }
        System.out.print(ptr.data + " ");
    }
    
    //Level-order
    void levelOrder(node localRoot){
        Queue<node> q = new LinkedList<>();
        node ptr = root;
        if (root == null){
            System.out.println("Tree Empty!!");
            return;
        }
        while (ptr != null){
            System.out.print(ptr.data + "  ");
            if (ptr.l!= null)
                q.add(ptr.l);
                
            if (ptr.r!= null)
                q.add(ptr.r);
                
            if (q.isEmpty())
                ptr = null;
                
            else
                ptr = q.remove();
        }
    }
    
    //Display in descending order
    void desc(node localroot){
        if(localroot!=null){
            desc(localroot.r);
            System.out.print(localroot.data + "  ");
            desc(localroot.l);
        }
    }
    
    //Count number of leaves
    int count_leaves(node localroot){
        if (localroot.l ==null && localroot.r==null){
            return 1;
        }
        return  ( count_leaves(localroot.l) + count_leaves(localroot.r) ); 
        
    }
    
    //Find height
    int find_height(node localroot){
        int lh, rh;
        // left
        if(localroot.l==null){
            lh=0;
        }
        else{
            lh=1+find_height(localroot.l);
        }
        //right
        if(localroot.r==null){
            rh=0;
        }
        else{
            rh=1+find_height(localroot.r);
        }
        // return height
        if(lh>rh)
            return lh;
        else
            return rh;
    }
    
    //Find parent
    void searchparent(node localroot) {
        int key;
        System.out.print("Enter data of the node to search it's parent: ");
        key = sc.nextInt();
        
		if(localroot.data==key) {
			System.out.println("Parent of root does not exist");
			//return null;
		}
		node parent = null;
		node ptr = root;
		int flag=0;
		while(ptr!=null) {
			if(ptr!=null && key==ptr.data) {
				flag = 1;
				break;
			}
			if(ptr!=null && key<ptr.data) {
				parent = ptr;
				ptr = ptr.l;
			}
			if(ptr!=null && key>ptr.data) {
				parent = ptr;
				ptr = ptr.r;
			}
		}
		if(flag==0) {
			System.out.println("Node not found!");

		}
		else {
			System.out.print("The parent of "+ key+" is: ");
			System.out.print(parent.data);
		}
	}
   
}//btree ends




public class Main{
	public static void main(String[] args) {
		int op;
	    bt b=new bt();
	    Scanner sc=new Scanner(System.in);
	    do{                       
            System.out.println("\n----------------MENU------------------");;
            System.out.println("1.Create a Binary Tree");
            System.out.println("2.Find Maximum node");
            System.out.println("3.Find Minimum node");
            System.out.println("4.Display tree level-wise");
            System.out.println("5.Display tree in descending order");
            System.out.println("6.Count no. of leaf nodes (recursively)");
            System.out.println("7.Find height of the tree");
            System.out.println("8.Find parent of the node");
            System.out.println("0.Exit");
            System.out.println("------------------------------------------");
            System.out.print("Enter your choice: ");
            op=sc.nextInt();
            switch(op){
                case 1:
                    b.create();
                    break;
                    
                case 2:
                    System.out.print("\nThe Maximum node is: ");
                    if (b.root == null)
                        System.out.print("Tree Empty!!");
                    else
                        b.max_node(b.root);
                    System.out.println("");
                    break;
                    
                case 3:
                    System.out.print("\nThe Minimum node is: ");
                    if (b.root == null)
                        System.out.print("Tree Empty!!");
                    else
                        b.min_node(b.root);
                    System.out.println("");
                    break;

                case 4:
                    System.out.println("\nThe btree in Level order is: ");
                    if (b.root == null)
                        System.out.print("Tree Empty!!");
                    else
                        b.levelOrder(b.root);
                    System.out.println("");
                    break;
    
                case 5:
                    System.out.println("\nThe btree in descending order is: ");
                    if (b.root == null)
                        System.out.print("Tree Empty!!");
                    else
                        b.desc(b.root);
                    System.out.println("");
                    break;
                    
                case 6:
                    System.out.print("\nThe number of leaves are: ");
                    if (b.root == null)
                        System.out.print("Tree Empty!!");
                    else{
                        int c= b.count_leaves(b.root);
                        System.out.print(c);
                    }
                    System.out.println("");
                    break;
            
                case 7:
                    System.out.print("\nThe height of btree is: ");
                    if (b.root == null)
                        System.out.print("Tree Empty!!");
                    else{
                        int h = b.find_height(b.root);
                        System.out.print(h);
                    }    
                    System.out.println("");
                    break;
                 
                case 8:
                    //System.out.println("\nThe parent of node is: ");
                    if (b.root == null)
                        System.out.print("Tree Empty!!");
                    else
                        b.searchparent(b.root);
                    System.out.println("");
                    break;
                    

                case 0:
                    System.out.println("Exited");
                    break;
                    
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }while (op!=0);
	}
}




/*
OUTPUT:


----------------MENU------------------
1.Create a Binary Tree
2.Find Maximum node
3.Find Minimum node
4.Display tree level-wise
5.Display tree in descending order
6.Count no. of leaf nodes (recursively)
7.Find height of the tree
8.Find parent of the node
0.Exit
------------------------------------------
Enter your choice: 1
Enter data : 5
Root node added!

Do you want to add more nodes ?(y/n) : y

Enter data : 2
Current node Data : 5
Node added!!

Do you want to add more nodes ?(y/n) : y

Enter data : 21
Current node Data : 5
Node added!!

Do you want to add more nodes ?(y/n) : y

Enter data : -4
Current node Data : 5
Current node Data : 2
Node added!!

Do you want to add more nodes ?(y/n) : y

Enter data : 3
Current node Data : 5
Current node Data : 2
Node added!!

Do you want to add more nodes ?(y/n) : y

Enter data : 19
Current node Data : 5
Current node Data : 21
Node added!!

Do you want to add more nodes ?(y/n) : y

Enter data : 25
Current node Data : 5
Current node Data : 21
Node added!!

Do you want to add more nodes ?(y/n) : n


----------------MENU------------------
1.Create a Binary Tree
2.Find Maximum node
3.Find Minimum node
4.Display tree level-wise
5.Display tree in descending order
6.Count no. of leaf nodes (recursively)
7.Find height of the tree
8.Find parent of the node
0.Exit
------------------------------------------
Enter your choice: 2

The Maximum node is: 25 

----------------MENU------------------
1.Create a Binary Tree
2.Find Maximum node
3.Find Minimum node
4.Display tree level-wise
5.Display tree in descending order
6.Count no. of leaf nodes (recursively)
7.Find height of the tree
8.Find parent of the node
0.Exit
------------------------------------------
Enter your choice: 3

The Minimum node is: -4 

----------------MENU------------------
1.Create a Binary Tree
2.Find Maximum node
3.Find Minimum node
4.Display tree level-wise
5.Display tree in descending order
6.Count no. of leaf nodes (recursively)
7.Find height of the tree
8.Find parent of the node
0.Exit
------------------------------------------
Enter your choice: 4

The btree in Level order is: 
5  2  21  -4  3  19  25  

----------------MENU------------------
1.Create a Binary Tree
2.Find Maximum node
3.Find Minimum node
4.Display tree level-wise
5.Display tree in descending order
6.Count no. of leaf nodes (recursively)
7.Find height of the tree
8.Find parent of the node
0.Exit
------------------------------------------
Enter your choice: 5

The btree in descending order is: 
25  21  19  5  3  2  -4  

----------------MENU------------------
1.Create a Binary Tree
2.Find Maximum node
3.Find Minimum node
4.Display tree level-wise
5.Display tree in descending order
6.Count no. of leaf nodes (recursively)
7.Find height of the tree
8.Find parent of the node
0.Exit
------------------------------------------
Enter your choice: 6

The number of leaves are: 4

----------------MENU------------------
1.Create a Binary Tree
2.Find Maximum node
3.Find Minimum node
4.Display tree level-wise
5.Display tree in descending order
6.Count no. of leaf nodes (recursively)
7.Find height of the tree
8.Find parent of the node
0.Exit
------------------------------------------
Enter your choice: 7

The height of btree is: 2

----------------MENU------------------
1.Create a Binary Tree
2.Find Maximum node
3.Find Minimum node
4.Display tree level-wise
5.Display tree in descending order
6.Count no. of leaf nodes (recursively)
7.Find height of the tree
8.Find parent of the node
0.Exit
------------------------------------------
Enter your choice: 8
Enter data of the node to search it's parent: -4
The parent of -4 is: 2

----------------MENU------------------
1.Create a Binary Tree
2.Find Maximum node
3.Find Minimum node
4.Display tree level-wise
5.Display tree in descending order
6.Count no. of leaf nodes (recursively)
7.Find height of the tree
8.Find parent of the node
0.Exit
------------------------------------------
Enter your choice: 8
Enter data of the node to search it's parent: 2
The parent of 2 is: 5

----------------MENU------------------
1.Create a Binary Tree
2.Find Maximum node
3.Find Minimum node
4.Display tree level-wise
5.Display tree in descending order
6.Count no. of leaf nodes (recursively)
7.Find height of the tree
8.Find parent of the node
0.Exit
------------------------------------------
Enter your choice: 0
Exited

*/

/*

TIME COMPLEXITIES:

create tree: O(n^2)
Find maximum: O(n)
Find minimum: O(n)
level order traversal: O(n)
Display in descending order: O(n)
Find height of bst: O(n)
Count number of leaves: O(n)
Find parent: O(n)

*/
