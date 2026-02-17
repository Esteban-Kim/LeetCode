class Solution {
    public int minSideJumps(int[] obstacles) {
        int[] jumps = {1,0,1};
        for (int obstacle : obstacles) {
            if (obstacle > 0) {
                jumps[obstacle-1] = 1000000;
            }
            for (int i = 0; i < 3; i++) {
                if (obstacle-1 != i) {
                    int firstJump = (i+1) % 3;
                    int secondJump = (i+2) % 3;
                    int firstValue = jumps[firstJump];
                    int secondValue = jumps[secondJump];

                    jumps[i] = Math.min(jumps[i], Math.min(firstValue, secondValue)+1);
                }
            }
        }

        return Math.min(jumps[0], Math.min(jumps[1], jumps[2]));
    }
}