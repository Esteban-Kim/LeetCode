class Solution {
    public int longestMountain(int[] arr) {
        int length = arr.length;
        int[] left = new int[length], right = new int[length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for (int index = 1; index < length; index++) {
            if (arr[index] > arr[index-1]) {
                left[index] = left[index-1]+1;
            }
        }

        for (int index = length-2; index >= 0; index--) {
            if (arr[index] > arr[index+1]) {
                right[index] = right[index+1]+1;
            }
        }

        int longestMountain = 0;

        for (int index = 1; index < length-1; index++) {
            if (left[index] > 1 && right[index] > 1) {
                longestMountain = Math.max(longestMountain, left[index-1]+right[index+1]+1);
            }
        }

        return longestMountain;
    }
}