//https://www.geeksforgeeks.org/find-subarray-with-given-sum/
// https://www.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1
//Indexes of Subarray Sum
//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        StringBuilder sb = new StringBuilder();
        for (int e : a) sb.append(e + " ");
        System.out.println(sb);
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String str[] = br.readLine().trim().split(" ");

            int n = Integer.parseInt(str[0]);
            int s = Integer.parseInt(str[1]);

            int[] arr = IntArray.input(br, n);

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(arr, n, s);

            IntArray.print(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> res=new  ArrayList<Integer>();
        // code here
        if(n==0 || (n==1 && arr[0]!=s))
        {
            res.add(-1);
            return res;
        }
        
        
        if(n==1 && arr[0]==s)
        {
            res.add(1);
            res.add(1);
            return res;
        }
        int sum=0, start=0, last=0;
        boolean flag= false;
         
        for(int i=0;i<n;i++)
        {
            sum+=arr[i];
            if(sum>=s){
                last =i;
                while(sum>s && start<last){
                    sum-=arr[start];
                    ++start;
                }
                if(sum == s)
                {
                    res.add(start+1);
                    res.add(last+1);
                    flag=true;
                    break;
                }
                
            }
            
        }
        if(!flag)
        {
            res.add(-1);
            return res;
        }
        return res;
    }
}
