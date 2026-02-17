class Solution {
    public int findTheWinner(int n, int k) {
        return recursive(n, k)+1;
    }
    public int recursive(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (recursive(n-1, k)+k)%n;
    }
}