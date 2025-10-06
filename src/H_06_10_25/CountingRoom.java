//You are given a map of a building, and your task is to count the number of its rooms. The size of the map is n \times m squares, and each square is either floor or wall. You can walk left, right, up, and down through the floor squares.
//        Input
//The first input line has two integers n and m: the height and width of the map.
//Then there are n lines of m characters describing the map. Each character is either . (floor) or # (wall).
//Output
//Print one integer: the number of rooms.
//Constraints
//
//1 \le n,m \le 1000
//
//Example
//Input:
//        5 8
//        ########
//        #..#...#
//        ####.#.#
//        #..#...#
//        ########
//
//Output:
//        3

//package H_06_10_25;
import java.util.*;

public class CountingRoom {
    private static void bfs(char[][] grid, int startX, int startY) {
        int n = grid.length;
        int m = grid[0].length;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startX, startY});
        grid[startX][startY] = '#';

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int x = cell[0], y = cell[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && grid[nx][ny] == '.') {
                    grid[nx][ny] = '#';
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = sc.nextLine().toCharArray();
        }

        int rooms = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '.') {
                    bfs(grid, i, j);
                    rooms++;
                }
            }
        }

        System.out.println(rooms);
    }
}
