class Solution {
    public int findTheWinner(int n, int k) {
        return findWinner(n, k)+1;
    }

    public int findWinner(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (findWinner(n-1, k)+k) % n;
    }
}