//Time limit: 1.00 s
//Memory limit: 512 MB
//
//You are given an n \times n grid representing the map of a forest. Each square is either empty or contains a tree. The upper-left square has coordinates (1,1), and the lower-right square has coordinates (n,n).
//Your task is to process q queries of the form: how many trees are inside a given rectangle in the forest?
//Input
//The first input line has two integers n and q: the size of the forest and the number of queries.
//Then, there are n lines describing the forest. Each line has n characters: . is an empty square and * is a tree.
//        Finally, there are q lines describing the queries. Each line has four integers y_1, x_1, y_2, x_2 corresponding to the corners of a rectangle.
//        Output
//Print the number of trees inside each rectangle.
//Constraints
//
//1 \le n \le 1000
//        1 \le q \le 2 \cdot 10^5
//        1 \le y_1 \le y_2 \le n
//1 \le x_1 \le x_2 \le n
//
//Example
//Input:
//        4 3
//        .*..
//        *.**
//        **..
//        ****
//        2 2 3 4
//        3 1 3 1
//        1 1 2 2
//
//Output:
//        3
//        1
//        2
package H_08_10_25;

import java.io.*;
import java.util.*;

public class ForestQueries {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine().toCharArray();
        }
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int val = (grid[i - 1][j - 1] == '*') ? 1 : 0;
                dp[i][j] = val + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }

        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int startI = Integer.parseInt(st.nextToken());
            int startJ = Integer.parseInt(st.nextToken());
            int endI = Integer.parseInt(st.nextToken());
            int endJ = Integer.parseInt(st.nextToken());

            int result = dp[endI][endJ] - dp[startI - 1][endJ] - dp[endI][startJ - 1] + dp[startI - 1][startJ - 1];
            sb.append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
