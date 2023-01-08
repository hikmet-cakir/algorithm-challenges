class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] cleanedNums1 = new int[m];
        int index = 0;
        while (index < m) {
            cleanedNums1[index] = nums1[index];
            index++;
        }

        int i = 0;
        int j = 0;
        while(i + j < nums1.length) {
            if(j == nums2.length || (i < cleanedNums1.length && cleanedNums1[i] < nums2[j])) nums1[i + j] = cleanedNums1[i++];
            else nums1[i + j] = nums2[j++];
        }
    }
}