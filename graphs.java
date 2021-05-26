import java.util.*;
class node
{
    int house; //house no.
    node next;
    node()
    {
        house=0;
        next=null;
    }
    node(int a)
    {
        house=a;
    }
    void display_details()
    {
        System.out.print("house no."+house);
    }
}
class graph 
{   
   Scanner sc=new Scanner(System.in) ;   
   int v;       //vertices
   int e;       //edges
   int[][] adj_m;    //adjacency matrix
   node head_list[]=new node[20];       //head f LL storing house details
   graph()
   {
       v=e=0;
   }
   
   void create_adj_m()
   {
       System.out.println("enter no. of vertices");
       v=sc.nextInt();
       adj_m=new int[v][v];
       System.out.println("enter Adjacency Matrix");
       for(int i=0;i<v;i++)
       {
          for(int j=0;j<v;j++)
         {
           if( j>=i)
           {
               System.out.println("Enter (1/0) for adj matrix of houses "+ (i+1)+", "+(j+1));
               adj_m[j][i]=adj_m[i][j]=sc.nextInt();
           }
         } 
       }
   }
   
   void display_adj_m()
   {    
       System.out.print("   ");
       for(int x=0;x<v;x++)
        {
            System.out.print((x+1)+"\t");
        }
       System.out.println();
       for(int i=0;i<v;i++)
       {    
          System.out.print(i+1+": "); 
          for(int j=0;j<v;j++)
         {
           System.out.print(adj_m[i][j]+"\t");
         }
         System.out.println();
       }
   }
   void bfs()               //using queue
   {
       System.out.println("Enter starting house no.");
       int start=sc.nextInt();
       boolean visited[]=new boolean[v];             //linear boolean matrix to show visited vertices
       visited[start-1]=true;                       //always visits the start node
       Queue<Integer> q=new LinkedList<Integer>();
       q.add(start);
       while(!q.isEmpty())
       {
           int a= q.poll();
           System.out.print(a+"->");
           for(int j=0;j<v;j++)
           {
               if(adj_m[a-1][j]==1&&visited[j]==false)
               {
                   q.add(j+1);
                   visited[j]=true;
               }
           }
       }
       System.out.print("end");
   }
   void dfs()               //using stack
   {    
       int flag=0,j;
       System.out.println();
       System.out.println("Enter starting house no.");
       int start=sc.nextInt();
       boolean visited[]=new boolean[v];             //linear boolean matrix to show visited vertices
       boolean printed[]=new boolean[v]; 
       visited[start-1]=true;                       //always visits the start node
       Stack<Integer> s=new Stack<Integer>();
       s.push(start);
       while(!s.isEmpty())
       {
            
        int a=s.peek(); 
        if(visited[a-1]==true&&printed[a-1]==false)  
                 System.out.print(a+"->");
                 printed[a-1]=true;
        for(j=0;j<v;j++)
           {    
               flag=0;
               
               if(adj_m[a-1][j]==1&&visited[j]==false)
               {
                   visited[j]=true;
                   flag=1;
                   s.push(j+1);
                   break;
               }
           }
          if(flag==0)
          {
              s.pop();
          }
       }
        System.out.print("end");
   }
   
   void accept_list()
   {
       int source,destination;
       int j;
       char ans;
       System.out.println("enter no. of vertices");
       v=sc.nextInt();
       System.out.println("enter no. of edges");
       e=sc.nextInt();
       for(int i=0;i<v;i++)
       {
           head_list[i]=new node();
           head_list[i]=null;
       }
       for(int i=0;i<e;i++)
       {
           System.out.println((i+1)+"\n"+"enter source");
           source=sc.nextInt();
           System.out.println("enter destination");
           destination=sc.nextInt();
           insert(source,destination);
           insert(destination,source);
       }
   } 
       
    void display_list()
    {
        //display list
       node ptr2=new node();
       for(int i=0;i<v;i++)
       {    
           System.out.print("house no. " +(i+1)+"-");
           ptr2=head_list[i];
           while(ptr2!=null)
           {
              	ptr2.display_details();
              	System.out.print("-");
              	ptr2=ptr2.next;
           }
           System.out.println("end");
       } 
       
   }
   void insert(int i,int d)
    {   
        node temp=new node(d);
        if(head_list[i-1]==null)
        {  
          head_list[i-1]=temp;
        }
        else 
        {
            node ptr=head_list[i-1];
            while(ptr.next!=null)
            {
             ptr=ptr.next;
            }
            ptr.next=temp;
        }
    }
    
   
   void bfs_list()
   {
       System.out.println("Enter starting house no.");
       int start=sc.nextInt();
       node ptr=new node();
       boolean visited[]=new boolean[v];
       visited[start-1]=true;
       Queue<Integer> q=new LinkedList<Integer>();
       q.add(start);
       while(!q.isEmpty())
       {
           int a=q.poll();
           //node temp=new node(a);
           System.out.print("house no."+a+"-> ");
           int i=a;
           ptr=head_list[i-1];
           while(ptr!=null)
               {  
                 i=ptr.house; 
                 if(visited[i-1]==false)
                 {
                    q.add(i);
                    visited[i-1]=true;
                 }
                 
                 ptr=ptr.next; 
                 
               }
           
       }System.out.println("end");
   }
   
   void dfs_list()
   {
       System.out.println("\nEnter starting house no.");
       int start=sc.nextInt();
       node ptr=new node();
       boolean visited[]=new boolean[v];
       boolean printed[]=new boolean[v];
       visited[start-1]=true;
       Stack<Integer>s=new Stack<Integer>();
       s.push(start);
       while(!s.empty())
       {
                int a=s.pop();
                if(printed[a-1]==false)
                {
                    System.out.print("house no."+a+"-> ");
                    printed[a-1]=true;
                }
                
                ptr=head_list[a-1];
                if(ptr.next!=null)
                {
                   node temp=head_list[a-1];
                   while(temp!=null )
                   {
                       
                       if(visited[(temp.house-1)]==false)
                       {
                           s.push(temp.house);
                            int v=ptr.house;
                            visited[v-1]=true;
                       }
                       temp=temp.next;
                   }
                    
                }
           
           
       }System.out.println("end");
   }
}
public class Main
{
	public static void main(String[] args) 
	{   
	    int ch;
	    Scanner sc=new Scanner(System.in);
	    graph g=new graph();
	    do
	    {
        System.out.println("***MENU***");
        System.out.println("\n1.Adjacency Matrix");
        System.out.println("\n2.Adjacency List");
        System.out.println("\n3.Exit");
            System.out.println("\nChoose any 1 option");
            ch = sc.nextInt();
            switch(ch)
            {
                case 1:
                    g.create_adj_m();
                    g.display_adj_m();
                    do{
                    System.out.println("\nChoose any 1 option\n1.bfs\n2.dfs");
                    int opt = sc.nextInt();
                    if(opt==1)
                    {
                       g.bfs(); 
                    }
                    else if(opt==2)
                    {
                       g.dfs();
                    }
                    }while(opt!=3)
                break;    
                
                case 2:
                    g.accept_list();
                    g.display_list(); 
                    do{
                    System.out.println("\nChoose any 1 option\n1.bfs\n2.dfs");
                    int opt2 = sc.nextInt();
                    if(opt2==1)
                    {
                       g.bfs_list(); 
                    }
                    else if(opt2==2)
                    {
                       g.dfs_list();
                    }
                    while(opt2!=3)
                break;
                
                case 3:
                System.out.println("EXIT");    
            }
        }while(ch!=3);
	}
}

/*
***MENU***

1.Adjacency Matrix

2.Adjacency List

3.Exit

Choose any 1 option
1
enter no. of vertices
5
enter Adjacency Matrix
Enter (1/0) for adj matrix of houses 1, 1
0
Enter (1/0) for adj matrix of houses 1, 2
1
Enter (1/0) for adj matrix of houses 1, 3
0
Enter (1/0) for adj matrix of houses 1, 4
1
Enter (1/0) for adj matrix of houses 1, 5
0
Enter (1/0) for adj matrix of houses 2, 2
0
Enter (1/0) for adj matrix of houses 2, 3
1
Enter (1/0) for adj matrix of houses 2, 4
1
Enter (1/0) for adj matrix of houses 2, 5
0
Enter (1/0) for adj matrix of houses 3, 3
0
Enter (1/0) for adj matrix of houses 3, 4
1
Enter (1/0) for adj matrix of houses 3, 5
0
Enter (1/0) for adj matrix of houses 4, 4
0
Enter (1/0) for adj matrix of houses 4, 5
1
Enter (1/0) for adj matrix of houses 5, 5
0
   1	2	3	4	5	
1: 0	1	0	1	0	
2: 1	0	1	1	0	
3: 0	1	0	1	0	
4: 1	1	1	0	1	
5: 0	0	0	1	0	

Choose any 1 option
1.bfs
2.dfs
1
Enter starting house no.
2
2->1->3->4->5->end
Choose any 1 option
2
enter no. of vertices
5
enter no. of edges
5
1
enter source
1
enter destination
2
2
enter source
1
enter destination
4
3
enter source
3
enter destination
2
4
enter source
2
enter destination
4
5
enter source
4
enter destination
5
house no. 1-house no.2-house no.4-end
house no. 2-house no.1-house no.3-house no.4-end
house no. 3-house no.2-end
house no. 4-house no.1-house no.2-house no.5-end
house no. 5-house no.4-end

Choose any 1 option
1.bfs
2.dfs
2

Enter starting house no.
2
house no.2-> house no.4-> house no.5-> house no.3-> house no.1-> end

Choose any 1 option
3

EXIT

TIME COMPLEXITIES 

DFS bfs -O(n) 

 accept display -O(n^2)

*/
