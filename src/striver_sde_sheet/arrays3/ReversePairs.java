package striver_sde_sheet.arrays3;

public class ReversePairs {

    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int l = left;
        int r = mid + 1;
        int index = 0;
        while (l <= mid && r <= right) {
            if (nums[l] <= nums[r]) {
                temp[index++] = nums[l++];
            } else {
                temp[index++] = nums[r++];
            }
        }
        while (l <= mid) {
            temp[index++] = nums[l++];
        }
        while (r <= right) {
            temp[index++] = nums[r++];
        }
        for (int i = left; i <= right; i++) {
            nums[i] = temp[i - left];
        }
    }

    private int countPairs(int[] nums, int left, int mid, int right) {
        int count = 0;
        int l = left;
        int r = mid + 1;
        while (l <= mid) {
            while (r <= right && nums[l] > (long)2 * nums[r]) {
                r++;
            }
            count += r - (mid + 1);
            l++;
        }
        return count;
    }

    private int mergeSort(int[] nums, int left, int right) {
        int count = 0;
        if (left >= right)
            return count;
        int mid = left + (right - left) / 2;
        count += mergeSort(nums, left, mid);
        count += mergeSort(nums, mid + 1, right);
        count += countPairs(nums, left, mid, right);
        merge(nums, left, mid, right);
        return count;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
//        int[] nums = {1,3,2,3,1};
        int[] nums = {2,4,3,5,1};

        ReversePairs reversePairs = new ReversePairs();
        int paris = reversePairs.reversePairs(nums);
        System.out.println(paris);
    }
}

