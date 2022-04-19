package com.quan.leetcode.question.binarysearch;

/**
 * @author Force-oneself
 * @description S_540
 * @date 2022-04-19
 */
public class S_540 {

    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] == nums[mid ^ 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}
