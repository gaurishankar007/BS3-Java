package tester;
import java.util.*;

public class MaxMinEffort {
	int graph [] [] = {{1,3,8,9},{8,7,2,6},{13,3,6,4},{13,1,5,3}};
	
	public int rightIndex(int sright, int dright) {
		if(sright==dright) {
			return sright;
		}		
		else {
			return sright+1;
		}
	}
	
	public int bottomIndex(int sbottom, int dbottom) {
		if(sbottom==dbottom) {
			return sbottom;
		}		
		else {
			return sbottom+1;
		}
	}
	
	public int maximumEffort(int sourceB, int sourceR, int destinationB, int destinationR) {
		int bottom=sourceB;
		int right=sourceR;
		ArrayList<Integer> maxEfforts = new ArrayList<>();
		
		while(bottom+right!=destinationB+destinationR) {
			int startPoint = graph[bottom][right];
			int rightPoint = graph[bottom][rightIndex(right, destinationR)];
			int bottomPoint = graph[bottomIndex(bottom, destinationB)][right];
			
			int rightDif = rightPoint-startPoint;			
			int bottomDif = bottomPoint-startPoint;
			
			if(rightDif<=-1 && bottomDif<=-1) {
				if((-1*rightDif)>(-1*bottomDif)) {
					right=rightIndex(right, destinationR);
					maxEfforts.add(rightDif);
				}
				else {
					bottom=bottomIndex(bottom, destinationB);
					maxEfforts.add(bottomDif);
				}
			}
			else if(rightDif>bottomDif) {
				if (right!=rightIndex(right, destinationR)) {
					right=rightIndex(right, destinationR);
					maxEfforts.add(rightDif);
				}
				else {
					bottom=bottomIndex(bottom, destinationB);
					maxEfforts.add(bottomDif);
				}
			}
			else {
				if (bottom!=bottomIndex(bottom, destinationB)) {
					bottom=bottomIndex(bottom, destinationB);
					maxEfforts.add(bottomDif);
				}
				else {
					right=rightIndex(right, destinationR);
					maxEfforts.add(rightDif);
				}
			}
		}
		System.out.println("Maximum Efforts: "+ maxEfforts);
		return Collections.max(maxEfforts);
	}
	
	public int minimumEffort(int sourceB, int sourceR, int destinationB, int destinationR) {
		int bottom=sourceB;
		int right=sourceR;
		ArrayList<Integer> minEfforts = new ArrayList<>();
		
		while(bottom+right!=destinationB+destinationR) {
			int startPoint = graph[bottom][right];
			int rightPoint = graph[bottom][rightIndex(right, destinationR)];
			int bottomPoint = graph[bottomIndex(bottom, destinationB)][right];
			
			int rightDif = rightPoint-startPoint;			
			int bottomDif = bottomPoint-startPoint;
			
			if(rightDif<=-1 && bottomDif<=-1) {
				if((-1*rightDif)<(-1*bottomDif)) {
					right=rightIndex(right, destinationR);
					minEfforts.add(rightDif);
				}
				else {
					bottom=bottomIndex(bottom, destinationB);
					minEfforts.add(bottomDif);
				}
			}
			else if(rightDif<bottomDif) {
				if (right!=rightIndex(right, destinationR)) {
					right=rightIndex(right, destinationR);
					minEfforts.add(rightDif);
				}
				else {
					bottom=bottomIndex(bottom, destinationB);
					minEfforts.add(bottomDif);
				}
			}
			else {
				if (bottom!=bottomIndex(bottom, destinationB)) {
					bottom=bottomIndex(bottom, destinationB);
					minEfforts.add(bottomDif);
				}
				else {
					right=rightIndex(right, destinationR);
					minEfforts.add(rightDif);
				}
			}
		}
		System.out.println("Minimum Efforts: "+minEfforts);
		return Collections.max(minEfforts);
	}
	
	public static void main(String[] args) {
		MaxMinEffort obj = new MaxMinEffort();
		ArrayList<Integer> efforts = new ArrayList<>();;
		efforts.add(obj.maximumEffort(0, 0, 3, 3));
		efforts.add(obj.minimumEffort(0, 0, 3, 3));
		System.out.println("Final Maximum and Minimum Effort: "+efforts);
	}
}
