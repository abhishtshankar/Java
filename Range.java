import java.util.*;
public class Range{
    public static int range(int arr[]){
        int min=arr[0];
        int max=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min=arr[i];
            }
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return (max-min);
    }
    public static void main (String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter array ["+i+"] :");
            arr[i]=sc.nextInt();
        }
        sc.close();
        System.out.println("Range of array :"+(range(arr)));
    }
}
