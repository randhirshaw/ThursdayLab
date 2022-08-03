package array;
/*
 * @randhirshaw
 */
//import java.util.Scanner;
public class ArrayExample {
	public static void main(String[] args) {
		int[] arr= {12,3,4,-8,4,2,7,3,-5};
		int sum=0, even=0,odd=0,neg=0,cnt=0;
		System.out.println("Repeated elements are: ");
		//System.out.println("\nNegative Numbers are: ");
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
			if(arr[i]%2==1) {
				odd++;
			}
			else if(arr[i]<0) {
				neg++;
				//System.out.print(+arr[i]+" ");
			}
			else {
				even++;
			} 
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]==arr[j]) {
					System.out.print(arr[i]+" ");
					cnt++;
					break;
				}
			}
		}
/*		*For User Input*

 		Scanner s= new Scanner(System.in);
		System.out.println("Enter the required size of the array :");
	    int size = s.nextInt();
	    int arr[] = new int [size];
		System.out.println("Enter the Numbers: ");    
		for(int i=0;i<size;i++){
		    arr[i]=s.nextInt();
		}  */
	
/*	@For Each loop	
		for(int var:arr) {
			//var=s.nextInt();   
			sum+=var;
			if(var%2==1) {
				odd++;
			}
			else if(var<0) {
				neg++;
				System.out.print(var+" ");
			}
			else {
				even++;
			} 
		}     */
		System.out.println("\nTotal Sum is :"+sum);
		System.out.println("Total Odd Numbers: "+odd);
		System.out.println("Total Even Numbers: "+even);
		System.out.println("Total Negative Numbers: "+neg);
		System.out.println("Total Duplicate Numbers: "+cnt);
	}
}
