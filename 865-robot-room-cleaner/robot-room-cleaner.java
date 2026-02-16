/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    public void cleanRoom(Robot robot) {
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        visited.add(new Pair(0, 0));
        clean(robot, 0, 0, 0, visited);
    }

    public void clean(Robot robot, int x, int y, int d, Set<Pair<Integer, Integer>> visited) {
        robot.clean();
        // up, right, down, left
        int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};

        for (int index = 0; index < directions.length; index++) {
            int newDirection = (d+index)%4;
            int newX = directions[newDirection][0]+x;
            int newY = directions[newDirection][1]+y;
            if (!visited.contains(new Pair(newX, newY)) && robot.move()) {
                visited.add(new Pair(newX, newY));
                clean(robot, newX, newY, newDirection, visited);
                goBack(robot);
            }
            robot.turnRight();
        }
    }

    public void goBack(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}