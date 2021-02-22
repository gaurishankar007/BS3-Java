package convexHall;

import java.util.*;
public class GiftWrapping {
	
	public void convexHull(Coordinate point[], int n) {
		Stack<Coordinate> stack = new Stack<Coordinate>();
		
		int left = 0;
		
		for(int i=1; i<n; i++) {
			if(point[i].x < point[left].x) {
				left=i;
			}
		}
		
		int p=left;
		do {
			stack.add(point[p]);
			int q = (p+1) % n;
			for(int r=0; r<n; r++) {
				if(direction(point[p], point[q], point[r])>0) {
					q=r;
				}
			}
			p=q;
		}while(p!=left);
		stack.add(point[p]);
		
		
		//Display
		System.out.print("Coordinates for the Convex Hall: ");
		for(Coordinate i:stack) {
			System.out.print("("+i.x+", "+i.y+"), ");
		}
	}
	
	public int direction(Coordinate p, Coordinate q, Coordinate r) {
		int area=((q.x-p.x)*(r.y-q.y))-((q.y-p.y)*(r.x-q.x));
		return area;
	}

}
