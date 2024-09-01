// https://www.geeksforgeeks.org/problems/equilibrium-point-1587115620/1
//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Long> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Long.parseLong(token));
            }

            long[] arr = new long[array.size()];
            int idx = 0;
            for (long i : array) arr[idx++] = i;

            Solution obj = new Solution();

            // calling maxSubarraySum() function
            System.out.println(obj.equilibriumPoint(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    // arr: input array
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long arr[]) {
        // Your code here
        int n=arr.length;
        // long[] left=new long[n];
        // long[] right=new long[n];
        // for(int i=0;i<n-1;i++)
        // {
        //     left[i+1]=arr[i]+left[i];
        // }
        // for(int i=n-1;i>0;i--)
        // {
        //     right[i-1]=arr[i]+right[i];
        // }
        // for(int i=0;i<n;i++)
        // {
        //     if(left[i]==right[i])
        //     return i+1;
        // }
        int pivot=0, right=0,left=0;
        for(int i=1;i<n;i++)
        right+=arr[i];
        
        while(pivot<n-1 && left!=right){
            ++pivot;
            right-=arr[pivot];
            left+=arr[pivot-1];
        }
        return left==right ? pivot+1 :-1;
    }
}
