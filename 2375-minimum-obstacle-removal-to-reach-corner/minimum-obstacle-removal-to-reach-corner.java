class Solution {
    public int minimumObstacles(int[][] grid) {
        int rowLength = grid.length, columnLength = grid[0].length;
        boolean[][] visited = new boolean[rowLength][columnLength];

        PriorityQueue<Position> pQueue = new PriorityQueue<>((a, b) -> {
            return a.removed-b.removed;
        });
        pQueue.add(new Position(0, 0, grid[0][0] == 0 ? 0 : 1));
        visited[0][0] = true;

        int[][] directions = new int[][]{{-1,0},{0,-1},{0,1},{1,0}};

        while (!pQueue.isEmpty()) {
            Position position = pQueue.poll();
            if (position.row == rowLength-1 && position.column == columnLength-1) {
                return position.removed;
            }
            for (int[] direction : directions) {
                int newRow = position.row+direction[0], newColumn = position.column+direction[1];
                if (newRow >= 0 && newRow < rowLength && newColumn >= 0 && newColumn < columnLength && !visited[newRow][newColumn]) {
                    visited[newRow][newColumn] = true;
                    pQueue.add(new Position(newRow, newColumn, grid[newRow][newColumn] == 1 ? position.removed+1 : position.removed));
                }
            }
        }

        return -1;
    }
}

class Position {
    int row;
    int column;
    int removed;
    public Position(int row, int column, int removed) {
        this.row = row;
        this.column = column;
        this.removed = removed;
    }
}