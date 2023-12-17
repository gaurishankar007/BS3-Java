package tester;

public class StackPopper {	
	public int popChecker(int a[], int b[], int x) {
		int bIndx = 0;
		int sum = 0;
		while(bIndx < b.length && sum + b[bIndx] <= x) {
			sum += b[bIndx];
			bIndx++;
		}
		
		int maxPop = bIndx;
		for(int aIndx = 1; aIndx <= a.length; aIndx++) {
			sum += a[aIndx - 1];
			
			while(sum > x && bIndx > 0) {
				bIndx--;
				sum -= b[bIndx];
			}
			if(sum > x) {
				break;
			}
			maxPop = Math.max(maxPop, aIndx+bIndx);
		}
		return maxPop;
	}

	public static void main(String[] args) {
		StackPopper obj = new StackPopper();
		int stackA[] = {4, 3, 6, 7, 9};
		int stackB[] = {1, 2, 9, 5};
		System.out.println(obj.popChecker(stackA, stackB, 11));
	}
}
