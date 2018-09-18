package my.practice.arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrayLargestValue {

	private void printLargestValue(int[] arr) {
		List<String> list = new ArrayList<>();
		for(int i : arr) {
			list.add(String.valueOf(i));
		}
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				String x = a+b;
				String y = b+a;
				return x.compareTo(y) > 0 ? -1 : 1;
			}
		});
		System.out.print("Largest value: ");
		for (String element : list) {
			System.out.print(element);
		}
	}
	
	public static void main(String[] args) {
//		int[] arr = new int[] {54, 546, 548, 60};
		int[] arr = new int[] {1, 34, 3, 98, 9, 76, 45, 4};
		ArrayLargestValue arrayValue = new ArrayLargestValue();
		arrayValue.printLargestValue(arr);
	}

}
