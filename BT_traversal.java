import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.lang.Math;
public class one{
 static Scanner s=null;
	public static void main(String[] args) {
		// binary tree creation
		s=new Scanner(System.in);
		node root=create();
		//System.out.println(root.data);
		System.out.print(height(root));
		System.out.println();
		inOrder(root);
		System.out.println();
		preOrder(root);
		System.out.println();
		postOrder(root);
		System.out.println();
		inOrderNR(root);
		System.out.println();
		preOrderNR(root);
		System.out.println();
		bfsRecursive(root);
		System.out.println();
		bfsNR(root);
		// TODO Auto-generated method stub

	}
	public static node create() {
		node root=null;
		System.out.println("enter data: ");
		int data=s.nextInt();
		if(data==-1)
			return null;
		root=new node(data);
		System.out.println("enter data to left of: "+data);
		root.left=create();
		System.out.println("enter data to right of: "+data);
		root.right=create();
		return root;
	}
	static void inOrder(node root) {
		if(root == null) return;
		
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	
	static void preOrder(node root) {
		if(root == null) return;
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	static void postOrder(node root) {
		if(root == null) return;
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
	}


static void inOrderNR(node root) {
	if (root == null) 
        return;
	 Stack<node> stack = new Stack<node>();
	 while (true)
	    {
	        while (root != null)
	        {
	            stack.push(root);
	            root = root.left;
	        }
	        if (stack.isEmpty())
	            break;
	        root = stack.pop();
	        System.out.print(root.data);
	        root=root.right;
	    }
}
static void preOrderNR(node root)
{
    if (root == null) 
        return;
    
    Stack<node> stack = new Stack<node>();
    stack.push(root);

    while (!stack.empty()) {
       root = stack.pop();
        System.out.print(root.data);
        if (root.right != null) 
            stack.push(root.right);
        
        if (root.left != null) 
            stack.push(root.left);
         }
}
static void bfsNR(node root) {
	Queue<node> q=new LinkedList<node>();
	q.add(root);
	 node curr=null;
	while(!q.isEmpty()) {
		curr = q.poll();
        System.out.print(curr.data + " ");
        if (curr.left!= null) 
            q.add(curr.left);
        
        if (curr.right != null) 
            q.add(curr.right);
        
	}
}
static int height(node root) {
	if(root==null)
		return 0;
	int left=height(root.left);
	int right=height(root.right);
	return Math.max(left,right)+1;
}

static void bfsRecursive(node root) {
	for(int level=0;level<height(root);level++) {
		printlevel(root,level);
	}
	
}
static void printlevel(node root,int level) {
	if (root==null)
	       return;
	    else if (level == 0)
	       System.out.print(root.data+" ");
	    else if (level > 0)
	    {
	        printlevel(root.left, level-1);
	        printlevel(root.right, level-1);
	    }
}
}
class node{
	int data;
	node right,left;
	
	public node(int data) {
		this.data=data;
	}
}
