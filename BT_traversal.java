// BT WITH AND WITHOUT RECURRSION 
package norecursion;
import java.util.Scanner;
import  java.util.Stack;


//import tree.Node;

class Node //Node class
{
	int data;
	Node left;
	Node right;
	public Node(int data) //constructor
	{
		this.data = data;
		right = null;
		left = null;
	}
}

class Binaryoperations {
       

	 Node root = null; //root node
	Scanner scan = new Scanner(System.in);
	public void create()
	{
	int data;
	Node ptr,temp;
	String choice ,dir;

		do {
			System.out.println("ENTER THE DATA:");
			data = scan.nextInt();
			scan.nextLine();
		    temp = new Node(data);
			
			//temp.data = data;
			//temp.right = temp.left = null;
			if(root == null) //check if root is null
			{
				root = temp;
			}
			else
			{
				ptr = root;
				while(ptr!= null)
				{
					System.out.println(ptr.data +" ");
					System.out.println("ENTER THE DIRECTION:(left/right)");
					dir = scan.nextLine();
					if(dir.equalsIgnoreCase("left")) //go to left 
					{
						if(ptr.left == null)
						{
							ptr.left = temp;
							break;
						}
						else
						{
							ptr = ptr.left;
						}
					}
					else 
					{
						if(ptr.right == null) //go to right 
						{
							ptr.right = temp;
							break;
						}
						else
						{
							ptr = ptr.right;
						}
					}
				}
			}System.out.println("DO YOU WANT TO CONTINUE ? 1.YES(y) 2.NO(n)");
			choice = scan.nextLine();
			}while(choice.equals("y") || choice.equals("Y"));

        }
        
        public void inorder(Node node) //non recursive inorder
        {
        	Stack<Node> s = new Stack<Node>(); //stack s
        	Node ptr = root;
        	do
        	{
        	while(ptr != null) {
        		
        		s.push(ptr);
        		ptr = ptr.left;
        	}
        	if(!s.empty())
        	{
        		ptr = s.pop();
        		System.out.println(ptr.data +" ");
        		ptr= ptr.right;
        	}
        }while(!s.empty() || ptr!=null);
}
        	
        public void preorder(Node node) //non recursive preorder
        {
        	Stack<Node> s = new Stack<Node>(); //stack s
        	Node ptr = root;
        	do
        	{
        		while(ptr != null)
        		{
        			System.out.println(ptr.data +" ");
        			s.push(ptr);
        			ptr = ptr.left;
        		}
        		if(!s.empty())
        		{
        			ptr = s.pop();
        			ptr = ptr.right;
        			
        		}
        	}while(!s.empty() || ptr!=null);
        	
        }

        
        public void postorder(Node node) //non recursive postorder
        {
        	Stack<Node> s1 = new Stack<Node>(); 
        	Stack<Character> s2 = new Stack<Character>();
        	Node ptr = root;
        	do
        	{
        		while(ptr != null)
        		{
     
        				s1.push(ptr);
        				s2.push('L');
        				ptr = ptr.left;
        		
        		}
                 ptr = s1.pop();
        			if(s2.pop() == 'L')
        			{
        				s1.push(ptr);
        				s2.push('R');
        				ptr = ptr.right;
        			}
        			else
            			{
            				System.out.println(ptr.data +" ");
            				ptr = null;
            			}
        				
        			
       }while(!s1.empty() || ptr!=null || !s2.empty());
        	
        }
        public void Preorder(Node node)//recursive preorder
    	{
    		if(node != null) {
    		
    			System.out.println(node.data +" ");
    			preorder(node.left);
    			preorder(node.right);
    		}
    			
    	}
    	
    	public void Inorder(Node node)//recursive inorder
    	{
    		if(node!= null)
    		{
    			
    			inorder(node.left);
    			System.out.println(node.data +" ");
    			inorder(node.right);
    		}
    	}
    	
    	public void Postorder(Node node)//recursive postorder
    	{
    		if(node !=null)
    	{
    			
    		postorder(node.left);
    		postorder(node.right);
    		System.out.println(node.data +" ");
    	}
    	}
        public static void main(String[] args) { //main class
    		// TODO Auto-generated method stub
        	
        	int choice , ch;
        	Scanner scan = new Scanner(System.in);
        	Binaryoperations t1 = new Binaryoperations();
        	do
        	{
        		System.out.println("******MENU******");
            	System.out.println("1.CREATION OF TREE");
            	System.out.println("2.INORDER TRAVERSAL");
            	System.out.println("3.PREORDER TRAVERSAL");
            	System.out.println("4.POSTORDER TRAVERSAL");
            	System.out.println("5.EXIT");
            	System.out.println("ENTER YOUR CHOICE:");
            	choice = scan.nextInt();
        	switch(choice)
        	{
        	
        	case 1: 
        		   t1.create(); //call create 
        	        break;
        	case 2: 
        		   System.out.println("(NON RECURSION) INORDER IS :");
     		       t1.inorder(t1.root);
     		       System.out.println("(RECURSION) INORDER IS :");
     		       t1.inorder(t1.root);
     	            break;
        	case 3:
        		   System.out.println("(NON RECURSION) PREORDER IS :");
    		       t1.preorder(t1.root);
    		       System.out.println("(RECURSION) PREORDER IS :");
    		       t1.preorder(t1.root);
    	           break;
        	case 4:
        		   System.out.println("(NON RECURSION) POSTORDER IS :");
    		       t1.postorder(t1.root);
    		       System.out.println("(RECURSION) POSTORDER IS :");
    		       t1.postorder(t1.root);
    	           break;
            case 5:	
        		   System.out.println("EXIT");
        	        break;
        	        
        	 default : System.out.println("INVALID CHOICE");
        	           break;
        	}
        	   System.out.println("DO YOU WANT TO CONTINUE(menu) ? 1(continue) OR 0(stop) ");
        	   ch = scan.nextInt();
        	}while(ch !=0);
        }
}
