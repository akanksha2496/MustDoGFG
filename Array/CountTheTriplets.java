//Count the triplet
//https://www.geeksforgeeks.org/problems/count-the-triplets4615/1
//https://www.geeksforgeeks.org/count-triplets-such-that-sum-of-any-two-number-is-equal-to-third-set-2/
//
//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG 
{
    public static void main(String args[]) throws IOException 
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            int n = Integer.parseInt(read.readLine());
            String input[] = read.readLine().split(" ");
            
            int arr[] = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = Integer.parseInt(input[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.countTriplet(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//Time O(n2). space: O(n).
class Solution {
    int countTriplet(int arr[], int n) {
        // code here
        if(n<3)
        return 0;
        
        HashSet<Integer> hm=new HashSet<Integer>();
        int count=0;
        for(int i=0;i<n;i++){
            hm.add(arr[i]);
        }
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(hm.contains(arr[i]+arr[j]))
               { ++count;}
            }
        }
        return count;
            
    }
}
