
public class ArrayInsertion {
	
	public static void main(String args[]) {
		int array [] = new int[50];
		array[0]=3;
		array[1]=2;
		array[2]=7;
		array[3]=9;
		array[4]=5;
		
		int size = 5;
		System.out.print("Array before inserting: " );
		for(int i=0; i<size; i++) {
			System.out.print(array[i] + ",");
		}
		
		ArrayInsertion obj = new ArrayInsertion();
		System.out.println("");
		System.out.print("Array after inserting: " );
		obj.insert(array, size, 3, 11);
		
	}
	
	public void insert(int newArray[], int size, int position, int value) {
		for(int i=size-1; i>position; i--) {
			newArray[i+1]=newArray[i];
		}
		newArray[position-1]=value;
		size++;
		for(int i=0; i<size; i++) {
			System.out.print(newArray[i] + ",");
		}
	}
}