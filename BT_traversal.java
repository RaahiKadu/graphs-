wimport java.util.LinkedList;
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
        char dir,ch;
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
                    // accept direction to insert Node
                    System.out.print("Which direction of node with data '" + ptr.data + "' to add the node(l/r)? : ");
                    dir = sc.next().charAt(0);
                    if (dir == 'L' || dir == 'l'){
                        // if l=null insert new node there, else add ptr at l
                        if (ptr.l == null){
                            ptr.l = temp;
                            System.out.println("Node added!!");
                            break;
                        }
                        else{
                            ptr = ptr.l;
                        }
                    }
                    else{ //dir==r
                        // if r=null insert newl node there, else add ptr at r
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

    //Inorder Recursive
    void inOrderRecursive(node localRoot){
        if (localRoot != null){
            inOrderRecursive(localRoot.l);
            System.out.print(localRoot.data + " ");
            inOrderRecursive(localRoot.r);
        } 
    }
    
    //Preorder Recursive
    void preOrderRecursive(node localRoot){
        if (localRoot != null){
            System.out.print(localRoot.data + " ");
            preOrderRecursive(localRoot.l);
            preOrderRecursive(localRoot.r);
        }
    }
    
    //Postorder Recursive
    void postOrderRecursive(node localRoot){
        if (localRoot != null){
            postOrderRecursive(localRoot.l);
            postOrderRecursive(localRoot.r);
            System.out.print(localRoot.data + " ");
        }
    }
    
    //Inorder Non-recursive
    void inOrderNonRecursive(){
        Stack<node> s = new Stack<node>();
        node ptr = root;
        node popped;
        if (root == null){
            System.out.println("Empty tree!!");
            return;
        }
        while (true){
            while (ptr != null){
                s.push(ptr);
                ptr = ptr.l;
            }
            if (!s.empty()){
                popped = s.pop();
                ptr = popped;
                System.out.print(popped.data + " ");
                ptr = ptr.r;
            }
            else
                break;
        }
    } 

    //Preorder Non-recursive
    void preOrderNonRecursive(){
        Stack<node> s = new Stack<node>();
        node ptr = root; 
        node popped;
        if (root == null){
            System.out.println("Empty tree!!");
            return;
        }
        while (true){
            while (ptr != null){
                System.out.print(ptr.data + " ");
                s.push(ptr);
                ptr = ptr.l;
            }
            if (!s.empty()){
                popped =s.pop();
                ptr = popped;
                ptr = ptr.r;
            }
            else
                break;
        }
    }
    
    //Postorder Non-recursive
    void postOrderNonRecursive(){
        Stack<node> s1 = new Stack<node>();
        Stack<Character> s2 = new Stack<>();
        node ptr = root;
        node popped;
        char poppedFlag;
        if (root == null){
            System.out.println("Tree is Empty!!");
            return;
        }
        while (true){
            while (ptr != null){
                s1.push(ptr);
                s2.push('L');
                ptr = ptr.l;
            }
            if (!s1.empty()){
                popped = s1.pop();
                ptr = popped;
                poppedFlag = s2.pop();
                if (poppedFlag == 'L'){
                    s1.push(ptr); 
                    s2.push('R');
                    ptr = ptr.r;
                }
                else{
                    System.out.print(ptr.data + " ");
                    ptr = null;
                }
            }
            else
                break;
        }
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
            System.out.print(ptr.data + " ");
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
}//btree ends


public class Main{
	public static void main(String[] args) {
	    int op;
	    bt b=new bt();
	    Scanner sc=new Scanner(System.in);
	    do{
            System.out.println("**************MENU*********************");;
            System.out.println("1.Create a Binary Tree");
            System.out.println("Display using:");
            System.out.println("  2.Recursive Inorder");
            System.out.println("  3.Recursive Preorder");
            System.out.println("  4.Recursive Postorder");
            System.out.println("  5.Non-recursive Inorder");
            System.out.println("  6.Non-recursive Preorder");
            System.out.println("  7.Non-recursive Postorder");
            System.out.println("  8.Level order");
            System.out.println("9.Exit");
            System.out.println("*************************************");
            System.out.print("Enter your choice: ");
            op=sc.nextInt();
            switch(op){
                case 1:
                    b.create();
                    break;
                    
                case 2:
                    System.out.println("\nThe Recursive Inorder is: ");
                    if (b.root == null)
                        System.out.print("Tree Empty!!");
                    else
                        b.inOrderRecursive(b.root);
                    System.out.println("");
                    break;
                    
                case 3:
                    System.out.println("\nThe Recursive Preorder is: ");
                    if (b.root == null)
                        System.out.print("Tree Empty!!");
                    else
                        b.preOrderRecursive(b.root);
                    System.out.println("");
                    break;

                case 4:
                    System.out.println("\nThe Recursive Postorder is: ");
                    if (b.root == null)
                        System.out.print("Tree Empty!!");
                    else
                        b.postOrderRecursive(b.root);
                    System.out.println("\n");
                    break;
    
                case 5:
                    System.out.println("\nThe Non-recursive Inorder is: ");
                    b.inOrderNonRecursive();
                    System.out.println(""); 
                    break;
                    
                case 6:
                    System.out.println("\nThe Non-recursive Preorder is: ");
                    b.preOrderNonRecursive();
                    System.out.println("");
                    break;
            
                case 7:
                    System.out.println("\nThe Non-recursive Postorder is: ");
                    b.postOrderNonRecursive();
                    System.out.println("");
                    break;
                 
                case 8:
                     System.out.println("\nThe Level order is: ");
                    if (b.root == null)
                        System.out.print("Tree Empty!!");
                    else
                        b.levelOrder(b.root);
                    System.out.println("");
                    break;

                case 9:
                    System.out.println("Exited");
                    break;
                    
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }while (op!=9);
	}
}

