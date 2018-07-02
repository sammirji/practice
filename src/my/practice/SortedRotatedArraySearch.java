package my.practice;

public class SortedRotatedArraySearch {
	static int search(int a[], int low, int high, int key) {
		if (low > high) 
			return -1;
		
		int mid = (high + low)/2;
		
		if (a[mid] == key)
			return mid;
		
		// If a[low...mid] is sorted
		if (a[low] <= a[mid]) {
			/* As this sub-array is sorted, we 
               can quickly check if key lies in 
               half or other half */
			if (a[low] <= key && a[mid] >= key) {
				return search(a, low, mid-1, key);
			} else {
				return search(a, mid+1, high, key);
			}
		} 
		
		/* If a[low..mid] is not sorted, 
           then a[mid... high] must be sorted */
		if (a[mid] <= key && a[high] >= key) {
			return search(a, mid+1, high, key);
		}
		return search(a, low, mid-1, key);
	}
	
	public static void main(String args[])
    {
        int arr[] = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        int n = arr.length;
        int key = 9;
        int i = search(arr, 0, n-1, key);
        if (i != -1) 
            System.out.println("Index: " + i);
        else
            System.out.println("Key not found");
    }
}
