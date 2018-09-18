package my.practice.arrays;

public class MissingAndRepeating {
	
	static void printTwoElements(int arr[], int size)
	{
	    int i;
	    System.out.println("size:" + size);
	    for(i = 0; i < size; i++)
	    {
//	    	arr[Math.abs(arr[i])-1]
	    	
//	    	System.out.print("arr[i]: " + arr[i] + ", ");
//	    	System.out.println("arr[" + (Math.abs(arr[i])-1) + "]: " + arr[Math.abs(arr[i])-1]);
	        if(arr[Math.abs(arr[i])-1] > 0) {
	        	System.out.println("arr[Math.abs(arr["+i+"])-1]:" + arr[Math.abs(arr[i])-1]);
	            arr[Math.abs(arr[i])-1] = -arr[Math.abs(arr[i])-1];
	        }
	        else
	            System.out.println("The repeating element is " + Math.abs(arr[i]));
	    }
	 
	    System.out.print("And the missing element is ");
	    for(i = 0; i < size; i++)
	    {
	        if(arr[i] > 0)
	            System.out.println(i + 1);
	        /*else 
	        	System.out.print(arr[i] + " ");*/
	    }
	}
	 
	/* Driver program to test above function */
	public static void main(String[] args)
	{
	    int arr[] = {7, 1, 4, 5, 4, 6, 2};
	    int n = arr.length;
	    printTwoElements(arr, n);
	}
}
