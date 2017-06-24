import java.io.*;
import java.util.*;

class CountInversion{

	public static void main(String[] args) throws IOException {
		System.out.println("Starting ...");
		System.out.println();
		/* Reading Inputs from File*/
		Scanner s = new Scanner(new File("input.txt"));
		Vector arr = new Vector(); // The inputs will be stored in arr
		while(s.hasNextInt()){
			arr.add(s.nextInt());			
		}
		long countInv = count_inv(arr,0,arr.size()-1);
		System.out.println();
		System.out.println("No. of Inversions = "+countInv);
		System.out.println("End ...");
	}

	public static long count_inv(Vector arr,int start, int end){
		long x=0,y=0,z=0;
		if(start<end){
			int mid = (start+end)/2;
			x = count_inv(arr,start,mid);
			y = count_inv(arr,mid+1,end);
			z = count_merge(arr,start,mid,end);
		}
		System.out.print("-");
		return x+y+z;
	}

	public static long count_merge(Vector arr,int start,int mid,int end){
		// Find sizes of two subarrays to be merged
      	long countInv=0;
        int n1 = mid - start + 1;
        int n2 = end - mid;
		Vector left = new Vector();
		Vector right = new Vector();
		
		/*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            left.add(arr.get(start + i));
        for (int j=0; j<n2; ++j)
            right.add(arr.get(mid + 1+ j));
        int i=0,j=0,k=start;
        
        while (i < n1 && j < n2){
            int x = (int)left.get(i);
        	int y = (int)right.get(j);
        	if(x < y){
        		
        		arr.set(k,x);
        		i++;
        	}
        	else if (y < x){
        		
        		arr.set(k,y);
        		countInv += n1-i;
        		j++;
        	}
        	k++;
        	
        }

        /* Copy remaining elements if any */
        while (i < n1)
        {
            arr.set(k++,(int)left.get(i));
            i++;
        }
 
        /* Copy remaining elements if any */
        while (j < n2)
        {
            arr.set(k++,(int)right.get(j));
            j++;
        }
    	return countInv;
	}

}