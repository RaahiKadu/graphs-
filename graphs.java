/*
Raahi Kadu 
C22019221361
assignment 4
*/
package graph;
import java.util.*;
class node
{
	int house;
	int dist;
	node next;
	
	node()
	{
		house=0;
		next=null;
	}
	
	node(int house,int dist)
	{
		this.house=house;
		this.dist=dist;
	}
	
        node(int house)
        {
            this.house=house;
        }
	void display()
	{
		System.out.println("House Number:"+house);
		System.out.println("Distance:"+dist);
	}
}

class grh
{
	int v;
	int e;
	int adjMat[][];
	node head[];
	
	grh()
	{
		v=0;
		e=0;
	}

	void adjmat()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter the number of vertices");
		v=sc.nextInt();
		System.out.println("Enter the adjacency matrix");
		adjMat=new int[v][v];
		for(int i=0;i<v;i++)
		{
			for(int j=0;j<v;j++)
			{
				System.out.println("Enter the value for ("+(i+1)+","+(j+1)+")");
				adjMat[i][j]=sc.nextInt();
			}
		}
		
	}
	
	void adjlist()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter the number of vertices");
		v=sc.nextInt();
		System.out.println("\nEnter the number of Edges");
		e=sc.nextInt();
		head=new node[v];
		for(int i=0;i<v;i++)
		{
			head[i]=new node();
			head[i]=null;
		}
		
		for(int i=0;i<e;i++)
		{
			System.out.println("Enter the source:");
			int source=sc.nextInt();
			System.out.println("Enter the destination:");
			int dest=sc.nextInt();
			System.out.println("\n\tEnter the distance");
			int dist = sc.nextInt();
			insert(source,dest,dist);
			insert(dest,source,dist);
		}
	}
	
	void insert(int source,int dest,int dist)
	{
		node temp=new node(dest,dist);
		if(head[source-1]==null)
		{
			head[source-1]=temp;
		}
		
		else
		{ 
			node ptr=head[source-1];
			
			while(ptr.next!=null)
			{
                            ptr=ptr.next;
				
			}
                        ptr.next=temp;
		}
	}
        
        void dispadjmat()
        {
            for(int i=0;i<v;i++)
            {
                for(int j=0;j<v;j++)
                {
                    System.out.print(adjMat[i][j]+"\t");
                }
                System.out.println();
            }
        }
        
        void dispadjlist()
        {
            for(int i=0;i<v;i++)
            {
                System.out.println("From house number"+(i+1)+": ");
                if(head[i]==null)
                {
                    System.out.println("\nEmpty"); 
                }
                else
                {
                    node ptr=head[i];
                    while(ptr!=null)
                    {
                        ptr.display();
                        ptr=ptr.next;
                    }
                }
                System.out.println();
            }
        }
        
        void bfs()
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("\n\tEnter the starting vertex");
            int start = sc.nextInt();
            boolean[] visited = new boolean[v]; 
            visited[start - 1] = true;
            Queue<Integer> q=new LinkedList<Integer>();
            q.add(start); 
            while(!q.isEmpty())
            {
                int a=q.poll();
                System.out.print(a+" ");
                for(int i=0;i<v;i++)
                {
                    if(adjMat[a-1][i]==1 && visited[i]==false)
                    {
                        q.add(i+1);
                        visited[i]=true;
                    }
                }
            }
        }
        
        void dfs()
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("\n\tEnter the starting vertex");
            int start=sc.nextInt();
            //node temp=new node(start);
            boolean[] visited = new boolean[v]; 
            visited[start - 1] = true;
            Stack<Integer> s=new Stack<Integer>();
            s.push(start);
            while(!s.empty())
            {
                int a=s.pop();
                System.out.print(a+" ");
                if(head[a-1].next!=null)
                {
                    node ptr=head[a-1];
                   while(ptr!=null )
                   {
                       
                       if(visited[(ptr.house-1)]==false)
                       {
                           s.push(ptr.house);
                            int v=ptr.house;
                            visited[v-1]=true;
                       }
                       ptr=ptr.next;
                   }
                    
                }
            }
        }
}
public class Graph 
{
    public static void main(String srgs[])
    {
        Scanner sc=new Scanner(System.in);
        int ch=0;
        grh g=new grh();
        do
        {
            System.out.println("\n\tChoose any 1 option");
            System.out.println("\n\t1.Adjacency Matrix");
            System.out.println("\n\t2.Adjacency List");
            System.out.println("\n\t3.Exit");
            ch = sc.nextInt();
            switch(ch)
            {
                case 1:
                        g.adjmat();
                        System.out.println("\n\tDisplay:");
                        g.dispadjmat();
                        System.out.println("BFS : ");
                        g.bfs();
                        break;
                    
                case 2:
                        g.adjlist();
                        System.out.println("\n\tDisplay:");
                        g.dispadjlist();
                        System.out.println("DFS : ");
                        g.dfs();
                        break;
                case 3:
                        System.exit(0);
            }
        }while(ch!=3);
    }
}

/*
OUTPUT:
run:

	Choose any 1 option

	1.Adjacency Matrix

	2.Adjacency List

	3.Exit
1

Enter the number of vertices
4
Enter the adjacency matrix
Enter the value for (1,1)
0
Enter the value for (1,2)
1
Enter the value for (1,3)
0
Enter the value for (1,4)
1
Enter the value for (2,1)
1
Enter the value for (2,2)
0
Enter the value for (2,3)
0
Enter the value for (2,4)
0
Enter the value for (3,1)
0
Enter the value for (3,2)
1
Enter the value for (3,3)
0
Enter the value for (3,4)
1
Enter the value for (4,1)
1
Enter the value for (4,2)
0
Enter the value for (4,3)
1
Enter the value for (4,4)
0

	Display:
0	1	0	1	
1	0	0	0	
0	1	0	1	
1	0	1	0	

	Enter the starting vertex
1
BFS :
1 2 4 3 
	Choose any 1 option

	1.Adjacency Matrix

	2.Adjacency List

	3.Exit
2

Enter the number of vertices
4

Enter the number of Edges
4
Enter the source:
1
Enter the destination:
2

	Enter the distance
1
Enter the source:
2
Enter the destination:
3

	Enter the distance
1
Enter the source:
3
Enter the destination:
4

	Enter the distance
1
Enter the source:
4
Enter the destination:
1

	Enter the distance
1

	Display:
From house number1: 
House Number:2
Distance:1
House Number:4
Distance:1

From house number2: 
House Number:1
Distance:1
House Number:3
Distance:1

From house number3: 
House Number:2
Distance:1
House Number:4
Distance:1

From house number4: 
House Number:3
Distance:1
House Number:1
Distance:1


	Enter the starting vertex
1
DFS :
1 4 3 2 



*/
