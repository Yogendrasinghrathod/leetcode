//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s = in.readLine();

            Solution ob = new Solution();
            out.println(ob.decodeString(s));

            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends


class Solution {
    static String decodeString(String s) {
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');  
            } else if (c == '[') {
                numStack.push(num);
                strStack.push(currStr.toString());
                currStr = new StringBuilder();
                num = 0;
            } else if (c == ']') {
                StringBuilder temp = new StringBuilder(strStack.pop());
                int repeat = numStack.pop();
                temp.append(currStr.toString().repeat(repeat));
                currStr = temp;
            } else {
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}
