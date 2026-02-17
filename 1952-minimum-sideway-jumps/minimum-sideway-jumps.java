class Solution {
    public int minSideJumps(int[] obstacles) {
        int[] jumps = {1, 0, 1};

        for (int obstacle : obstacles) {
            if (obstacle > 0) {
                jumps[obstacle-1] = 1000000;
            }
            for (int index = 0; index < 3; index++) {
                if (obstacle-1 != index) {
                    int firstJumpIndex = (index+1)%3, secondJumpIndex = (index+2)%3;
                    int firstJumpValue = jumps[firstJumpIndex], secondJumpValue = jumps[secondJumpIndex];
                    jumps[index] = Math.min(jumps[index], Math.min(firstJumpValue, secondJumpValue)+1);
                }
            }
        }

        return Math.min(jumps[0], Math.min(jumps[1], jumps[2]));
    }
}