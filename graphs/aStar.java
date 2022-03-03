package graphs;

import java.util.*;

public class aStar extends Graph{
	
	private static int size;
	private static int mat[][];
	private static LinkedList<Integer>[] list;
	ArrayList<Integer> openList = new ArrayList<>();
	ArrayList<Integer> closedList = new ArrayList<>();

	aStar(int v) {
		super(v);
		mat = getAdjMatrix();
		list = getAdjList();
		size = getVertice();
	}
	
	public void astar(int start, int goal, int[] h) {
		openList.add(start);
		int temp = 0;
		while(!openList.isEmpty()) {
			if(openList.size()==1) {
				temp = openList.remove(0);
				closedList.add(temp);
				if(temp==goal) {
					System.out.println("Success! Path is: ");
					System.out.println(closedList);
				}
				else {
					neighbours(temp);
				}
			}
			else {
				int n = temp;
				int min = 100;
				int f = 0;
				for(int item : openList) {
					if(!closedList.contains(item)) {
						f = h[item] + mat[item][temp];
						if(f<min) {
							min=f;
							n=item;
						}
					}
				}
				int index = openList.indexOf(n);
				temp = openList.remove(index);
				closedList.add(temp);
				openList.clear();
				if(temp==goal) {
					System.out.println("Success! Path is: ");
					System.out.println(closedList);
				}
				else {
					neighbours(temp);
				}
			}
		}
	}

	private void neighbours(int temp) {
		for(int item : list[temp]) {
			openList.add(item);
		}
	}

	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("Enter number of nodes: ");
//		int n = sc.nextInt();
//		System.out.println("Enter number of edges: ");
//		int e = sc.nextInt();
//		
//		aStar g = new aStar(n);
//		
//		for(int i=0; i<e; i++) {
//			System.out.println("Enter source node: ");
//			int src = sc.nextInt();
//			System.out.println("Enter destination node: ");
//			int des = sc.nextInt();
//			System.out.println("Enter weight of edge between these two nodes: ");
//			int weight = sc.nextInt();
//			g.addEdge(src, des, weight);
//		}
		
		aStar g = new aStar(6);
		
		g.addEdge(1, 2, 2);
		g.addEdge(1, 4, 3);
		g.addEdge(2, 3, 1);
		g.addEdge(3, 0, 1);
		g.addEdge(3, 4, 2);
		g.addEdge(4, 0, 4);
		
		int h[] = {0, 4, 2, 1, 3};
		
		g.astar(1, 0, h);
		
	}

}
