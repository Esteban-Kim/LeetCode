class SparseVector {
    Map<Integer, Integer> mapping;
    
    SparseVector(int[] nums) {
        mapping = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != 0) {
                mapping.put(index, nums[index]);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int dotProduct = 0;

        Map<Integer, Integer> v2Mapping = vec.mapping;

        for (Map.Entry<Integer, Integer> entry : v2Mapping.entrySet()) {
            dotProduct += (entry.getValue()*mapping.getOrDefault(entry.getKey(), 0));
        }

        return dotProduct;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);