class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if (grid[row][column] == '1') {
                    islands++;
                    convert(grid, row, column);
                }
            }
        }

        return islands;
    }

    public void convert(char[][] grid, int row, int column) {
        int[][] directions = new int[][]{{-1,0},{0,-1},{0,1},{1,0}};
        int rowLength = grid.length, columnLength = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, column});
        grid[row][column] = '0';

        while (!queue.isEmpty()) {
            int[] next = queue.poll();
            int currentRow = next[0], currentColumn = next[1];

            for (int[] direction : directions) {
                int newRow = currentRow+direction[0], newColumn = currentColumn+direction[1];
                if (newRow >= 0 && newRow < rowLength && newColumn >= 0 && newColumn < columnLength && grid[newRow][newColumn] == '1') {
                    grid[newRow][newColumn] = '0';
                    queue.add(new int[]{newRow, newColumn});
                }
            }
        }
    }
}