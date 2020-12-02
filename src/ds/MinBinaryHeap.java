package ds;

import java.util.Scanner;

public class MinBinaryHeap {

	public void menu() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("1. Insert");
		System.out.println("2. Display");
		System.out.println("3. Exit");
		System.out.print("Input : ");
		
		int choice = scan.nextInt();
		System.out.println("");
		switch(choice) {
		  case 1:
			  System.out.print("Input number to insert : ");
			  int num = scan.nextInt();
			  insertElement(num);
		      break;
		  case 2:
			  System.out.println("Here is the Binary Heap Tree : ");
			  displayElements();
			  break;
		  case 3:
			  System.out.println("Exiting... ");
			  System.exit(0);
			  break;
		  default:
			  System.out.println("Invalid Choice.. Try again... ");
		}
		menu();
	}
	
	public static void main(String[] args) {
		MinBinaryHeap obj = new MinBinaryHeap(15);
		obj.menu();
	}

	private int MAX_HEAP_SIZE;
	private int CURRENT_HEAP_SIZE = 0;
	private int heap[];
	
	MinBinaryHeap(int max_size) {
		MAX_HEAP_SIZE = max_size;
		heap = new int[max_size];
	}
	
	private int getParent(int k) {
		return (k-1)/2;
	}
	
	private int getLeftChild(int k) {
		return (2*k)+1;
	}
	
	private int getRightChild(int k) {
		return (2*k)+2;
	}
	
	public boolean insertElement(int k) {
		if (CURRENT_HEAP_SIZE == MAX_HEAP_SIZE) {
			System.out.println("Heap size exhausted....");
			return false;
		}
		heap[CURRENT_HEAP_SIZE++] = k;
		
		int i=CURRENT_HEAP_SIZE-1;
		while(i>0 && heap[getParent(i)] > heap[i]) {
			int tmp = heap[i];
			heap[i] = heap[getParent(i)];
			heap[getParent(i)] = tmp;
			i = getParent(i);
		}
		System.out.println("Inserted " + k + " successfully...");
		return true;
	}
	
	public void displayElements() {
		if (CURRENT_HEAP_SIZE == 0) {
			System.out.println("Binary Heap is empty...");
		}
		else {
			int s=0, e=0;
			while(s<=e) {
				int e1 = e;
				for(int i=s; i<=e1; i++) {
					System.out.print(heap[i] + "   ");
					if (getLeftChild(i) < CURRENT_HEAP_SIZE) {
						e++;
					}
					if (getRightChild(i) < CURRENT_HEAP_SIZE) {
						e++;
					}
				}
				System.out.println("");
				s = e1 + 1;
			}
		}
	}
}
