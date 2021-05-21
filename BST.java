/*
1. Create a BST
2. Find Maximum and Minimum value node
3. Level wise traversal
4. Display contents in descending order
5.Calculate leaf nodes
*/

import java.util.*;
import java.lang.*;
class Node
{
 int data;
 Node lc, rc;
 Node (int d)
 {
 data = d;
 lc = null;
 rc = null; }
}
class BST
{
 Node root;
 int count;
 BST ()
 {
 root = null;
 count = 0;
 }
 Scanner sc = new Scanner (System.in);
 public void create ()
 {
 int d, ch;
 do
 {
  System.out.println ("Enter the data: ");
  d = sc.nextInt ();
  Node temp = new Node (d);
  if (root == null)
  {
   root = temp;
  }
  else
  {
  Node ptr = root;
  while (ptr != null)
  {
  if (temp.data < ptr.data)
  {
   if (ptr.lc == null)
   {
    ptr.lc = temp;
    break;
   }
   else {
    ptr = ptr.lc;
   }
  }
 else
 {
  if (ptr.rc == null)
  {
   ptr.rc = temp;
   break;
  }
 else
 {
  ptr = ptr.rc;
 }
 }
 }
}
System.out.println ("Node inserted");
System.out.println ("Do you want to add more nodes? 1. Yes 2. No");
ch = sc.nextInt ();
 }
 while (ch == 1);
 }
 public void maximum ()
 {
 Node ptr;
 ptr = root;
 if (root == null)
 {
System.out.println ("BST is empty");
 }
 while (ptr.rc != null)
 {
 ptr = ptr.rc; }
 System.out.println ("\nMaximum value present is= " + ptr.data);
 }
 public void minimum ()
 {
 Node ptr;
 ptr = root;
 if (root == null)
 {
System.out.println ("BST is empty");
 }
 while (ptr.lc != null)
 {
 ptr = ptr.lc;
 }
 System.out.println ("Minimum value present is = " + ptr.data);
 }
 public void levelOrder (Node root)
 {
 Queue < Node > q1 = new LinkedList < Node > ();
 Node temp;
 if (root != null)
 {
 System.out.print (root.data + " ");
 }
 Node ptr = root;
 while (true)
 {
if (ptr.lc != null)
 {
 q1.add (ptr.lc);
 temp = ptr.lc;
 System.out.print (temp.data + " "); }
if (ptr.rc != null)
 {
 q1.add (ptr.rc);
 temp = ptr.rc;
 System.out.print (temp.data + " ");
 }
if (q1.isEmpty ())
 {
 break;
 }
else
 {
 ptr = q1.remove ();
 }
 }
 System.out.println (); 
 }
 public void descending ()
 {
 int arr[] = new int[50];
 Stack < Node > st = new Stack < Node > ();
 Node ptr = root;
 int i, j;
 i = 0;
 do
 {
while (ptr != null)
 {
 st.push (ptr); ptr = ptr.lc;
 }
ptr = st.pop ();
arr[i] = ptr.data;
i++;
ptr = ptr.rc;
 }
 while (ptr != null || !st.empty ());
 
 System.out.print("In descending order: ");
 for (j = i - 1; j >= 0; j--)
 {
System.out.print (arr[j] + " ");
 }
 System.out.println ();
 } 
 public int leafNodes (Node root)
 {
 if (root.lc == null && root.rc == null)
 {
count++;
 }
 if (root.lc != null)
 {leafNodes (root.lc);
 }
 if (root.rc != null)
 {
leafNodes (root.rc);
 }
 return count;
 }
}
public class Main
{
 public static void main (String[]args)
 {
 Scanner in = new Scanner (System.in);
 BST tree = new BST ();
 int ch, say;
 int ht;
 int leaf;
  do{
 System.out.println("M E N U");
 System.out.print("1. Create a BST\n2. Find Maximum and Minimum value node\n3. Level wise traversal");
 System.out.print("\n4. Display contents in descending order");
 System.out.println("\n5.Calculate leaf nodes");
 System.out.println("Enter your choice: ");
 ch = in.nextInt();
 
 switch(ch){
 case 1: tree.create ();
 break;
 
 case 2: tree.maximum ();
 tree.minimum ();
 break;
  case 3: System.out.print("Level order traversal: ");
 tree.levelOrder (tree.root);
 break;
 
 case 4: tree.descending ();
 break;
 
 case 5: leaf = tree.leafNodes (tree.root);
 System.out.println ("No. of leaf nodes = " + leaf);
 break;
  default: System.out.println("INVALID!");
 break;
 
 }
 System.out.println("\nDo you want to continue? 1.yes 2.no");
 say = in.nextInt();
 
 }while(say==1);
 
 }
}

