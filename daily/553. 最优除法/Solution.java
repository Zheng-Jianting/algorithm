class Solution {
    public String optimalDivision(int[] nums) {
        StringBuilder sb = new StringBuilder();
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        else if (nums.length == 2) {
            return String.valueOf(nums[0]) + "/" + String.valueOf(nums[1]);
        }
        else {
            sb.append(String.valueOf(nums[0]) + "/(" + String.valueOf(nums[1]));
            for (int i = 2; i < nums.length; i++) {
                sb.append("/");
                sb.append(String.valueOf(nums[i]));
            }
            sb.append(")");
        }
        return sb.toString();
    }
}