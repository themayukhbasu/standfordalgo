import java.io.*;
import java.util.*;

/* Java program for Merge Sort */
class CountInversionStatic
{
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    public static long merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
        long countInv=0;
        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];
 
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];
 
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                countInv += n1-i;
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }

        return countInv;
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    public static long sort(int arr[], int l, int r)
    {
        long x=0,y=0,z=0;
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;
 
            // Sort first and second halves
            x=sort(arr, l, m);
            y=sort(arr , m+1, r);
 
            // Merge the sorted halves
            z=merge(arr, l, m, r);
        }
        return x+y+z;
    }
 
    /* A utility function to print array of size n */
    public static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 
    // Driver method
    public static void main(String args[]) throws IOException
    {
        int arr[] = new int[100000];
        int k=0; 
        Scanner s = new Scanner(new File("input.txt"));
        while(s.hasNextInt()){
            arr[k++]=s.nextInt();           
        }

        //System.out.println("Given Array");
        //printArray(arr);
 
       
        long countInv = sort(arr, 0, arr.length-1);
 
        System.out.println("\nNo. of Inversions = " + countInv);

        //System.out.println("\nSorted array");
        //printArray(arr);
    }
}