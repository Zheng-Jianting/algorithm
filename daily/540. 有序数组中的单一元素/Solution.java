class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        if((nums.length % 2) == 1 && nums[nums.length / 2] != nums[nums.length / 2 - 1] && nums[nums.length / 2] != nums[nums.length / 2 + 1]) {
            return nums[nums.length / 2];
        }
        int i = 0, j = nums.length - 1;
        for(; i <= j; i++, j--) {
            if(nums[i] + nums[j] == nums[i + 1] + nums[j - 1]) {
                i++;
                j--;
                continue;
            }
            break;
        }
        return nums[i] != nums[i + 1] ? nums[i] : nums[j];
    }

    // 如果元素都出现两次, 那么 nums[i] == nums[i+1], 当 i 为偶数; nums[i] == nums[i-1], 当 i 为奇数
    // i ^= 1 当 i 为偶数时 i + 1, 当 i 为奇数时 i -1
    public int singleNonDuplicateOptimize(int[] nums) {
        int l = 0, r = nums.length - 1;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] == nums[mid ^ 1]) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        return nums[l];
    }
}