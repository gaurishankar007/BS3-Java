package classwork;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		System.out.print("Enter the number of points: ");
		Scanner sc= new Scanner(System.in);
		int total_point= sc.nextInt();
		
		Coordinate point[] = new Coordinate[total_point];
		
		System.out.print("Auto Generated Points: ");
		for(int i=0; i<total_point; i++) {
			point[i]=new Coordinate(RandomPoint.pointX(), RandomPoint.pointY());
			System.out.print("("+point[i].x+", "+point[i].y+"), ");
		}
		
		int n=point.length;
		GiftWrapping gfw=new GiftWrapping();
		gfw.convexHull(point, n);
	}
}
