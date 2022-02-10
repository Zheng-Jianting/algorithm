import java.util.TreeSet;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> treeSet = new TreeSet<>(); // 保存当前遍历元素的前面 k 个元素
        for(int i = 0; i < nums.length; i++) {
            Integer ceiling = treeSet.ceiling(nums[i]);
            if(ceiling != null && (long) ceiling - (long) nums[i] <= t) {
                return true;
            }

            Integer floor = treeSet.floor(nums[i]);
            if(floor != null && (long) nums[i] - (long) floor <= t) {
                return true;
            }

            treeSet.add(nums[i]);
            if(i >= k) {
                treeSet.remove(nums[i - k]);
            }
        }
        return false;
    }
}