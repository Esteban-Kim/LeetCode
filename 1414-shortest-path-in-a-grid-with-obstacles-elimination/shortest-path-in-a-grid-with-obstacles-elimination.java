class Solution {
    public int shortestPath(int[][] grid, int k) {
        // row = 0, column = 1, steps = 2, k = 3

        Queue<State> queue = new LinkedList<>();
        Set<State> visited = new HashSet<>();
        queue.add(new State(0, 0, 0, k));
        visited.add(new State(0, 0, 0, k));

        int[][] directions = {{-1,0},{0,-1},{1,0},{0,1}};
        int rowLength = grid.length, columnLength = grid[0].length;

        while (!queue.isEmpty()) {
            State next = queue.poll();
            if (rowLength-1 == next.row && columnLength-1 == next.column) {
                return next.steps;
            }
            for (int[] direction : directions) {
                int newRow = direction[0]+next.row, newColumn = direction[1]+next.column;
                if (newRow >= 0 && newRow < rowLength && newColumn >= 0 && newColumn < columnLength) {
                    State newState = new State(newRow, newColumn, next.steps+1, next.k-grid[newRow][newColumn]);
                    if (next.k-grid[newRow][newColumn] >= 0 && !visited.contains(newState)) {
                        visited.add(newState);
                        queue.add(newState);
                    }
                } 
            }
        }

        return -1;
    }
}

class State {
    int row;
    int column;
    int steps;
    int k;
    public State(int row, int column, int steps, int k) {
        this.row = row;
        this.column = column;
        this.steps = steps;
        this.k = k;
    }

    @Override
    public boolean equals(Object state) {
        if (!(state instanceof State)) {
            return false;
        }
        State temp = (State)state;
        return (temp.row == this.row) && (temp.column == this.column) && (temp.k == this.k);
    }

    @Override
    public int hashCode() {
        return (this.row+1)*(this.column+1)*this.k;
    }
}