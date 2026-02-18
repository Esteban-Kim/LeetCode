class Solution {
    public int minSideJumps(int[] obstacles) {
        int[] jumps = {1, 0, 1};

        for (int obstacle : obstacles) {
            if (obstacle > 0) {
                jumps[obstacle-1] = 1000000;
            }
            for (int index = 0; index < 3; index++) {
                int firstJumpIndex = (index+1) % 3;
                int secondJumpIndex = (index+2) % 3;
                int firstValue = jumps[firstJumpIndex], secondValue = jumps[secondJumpIndex];

                if (obstacle-1 != index) {
                    jumps[index] = Math.min(jumps[index], Math.min(firstValue, secondValue)+1);
                }
            }
        }

        return Math.min(jumps[0], Math.min(jumps[1], jumps[2]));
    }
}