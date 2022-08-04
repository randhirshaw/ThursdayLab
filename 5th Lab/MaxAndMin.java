package array;
import java.util.Arrays;
public class MaxAndMin {
	public static void main(String[] args) {
//1.wap to find out maximum and minimum number in array.
		int[] arr = { 5, 7, 2, 4, 9, 6 };
		int max=0,min=arr[0];
		for(int i=0;i<arr.length;i++) {
            // if the current element is greater than the maximum found so far
            if(arr[i]>max)  max=arr[i];
            // if the current element is smaller than the minimum found so far
            else if(arr[i]<min)  min=arr[i];
        }
		System.out.println("\nThe minimum array element is " + min);
        System.out.println("\nThe maximum array element is " + max);
        System.out.println("\n***********************************************************************");
//2.wap to copy all elements from an array to another array.
      //Create another array arr2 with size of arr1  
        int arr2[] = new int[arr.length];  
        //Copying all elements of one array into another
        System.out.println("\nElements of array 2: ");  
        for (int i=0;i<arr.length;i++) {   
            arr2[i] = arr[i];
            System.out.print(arr2[i] + " ");  
        } 
        System.out.println("\n\n***********************************************************************");
//3.wap to merger two array in to another array.      
        int arr3[] = {2, 4, 6, 8,3,7};
        int merge=arr.length+arr3.length;
        int[] arr4 = new int[merge];
        int pos = 0;  
        for (int copy : arr) { //copying elements of secondArray using for-each loop   
        	arr4[pos] = copy;  
        	pos++;              //increases position by 1  
        }  
        for (int copy : arr3) { //copying elements of firstArray using for-each loop    
        	arr4[pos] = copy;  
        	pos++; 
        }  
        System.out.println("\nArray after merging "+Arrays.toString(arr4));   //prints the resultant array 
        System.out.println("\n***********************************************************************");
//4.wap to add two array elements and store it in different array.
        int add[]=new int[arr.length];
        System.out.println("\nSum of two array: ");
        for(int i=0;i<arr.length;i++) {
        	add[i]=arr[i]+arr3[i]; //adding and storing
        	System.out.print(add[i]+" ");
        }
	}
}