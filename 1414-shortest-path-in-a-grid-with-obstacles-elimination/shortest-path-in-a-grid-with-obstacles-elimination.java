class Solution {
    public int shortestPath(int[][] grid, int k) {
        Set<Position> visited = new HashSet<>();
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 0, 0, k));
        visited.add(new Position(0, 0, 0, k));
        int[][] directions = {{-1,0}, {0,-1}, {0,1}, {1,0}};
        int rowLength = grid.length, columnLength = grid[0].length;

        while (!queue.isEmpty()) {
            Position temp = queue.poll();
            if (temp.row == rowLength-1 && temp.column == columnLength-1) {
                return temp.steps;
            }
            for (int[] direction : directions) {
                int newRow = direction[0]+temp.row, newColumn = direction[1]+temp.column, newSteps = temp.steps+1;
                if (newRow >= 0 && newRow < rowLength && newColumn >= 0 && newColumn < columnLength && temp.k-grid[newRow][newColumn] >= 0 && !visited.contains(new Position(newRow, newColumn, newSteps, temp.k-grid[newRow][newColumn]))) {
                    visited.add(new Position(newRow, newColumn, newSteps, temp.k-grid[newRow][newColumn]));
                    queue.add(new Position(newRow, newColumn, newSteps, temp.k-grid[newRow][newColumn]));
                }
            }
        }

        return -1;
    }
}

class Position {
    int row, column, steps, k;
    public Position(int row, int column, int steps, int k) {
        this.row = row;
        this.column = column;
        this.steps = steps;
        this.k = k;
    }

    @Override
    public int hashCode() {
        return (this.row+1)*(this.column+1)*this.k;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Position)) {
            return false;
        }
        Position temp = (Position)object;
        return temp.row == this.row && temp.column == this.column && temp.k == this.k;
    }
}