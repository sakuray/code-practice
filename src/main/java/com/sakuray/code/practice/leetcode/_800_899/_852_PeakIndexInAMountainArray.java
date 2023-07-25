package com.sakuray.code.practice.leetcode._800_899;

/**
 * An array arr a mountain if the following properties hold:
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
 * You must solve it in O(log(arr.length)) time complexity.
 * <p>
 * Input: arr = [0,1,0]
 * Output: 1
 * <p>
 * Input: arr = [0,2,1,0]
 * Output: 1
 * <p>
 * Input: arr = [0,10,5,2]
 * Output: 1
 */
public class _852_PeakIndexInAMountainArray {

    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[] {0,1,0}));
        System.out.println(peakIndexInMountainArray(new int[] {0,2,1,0}));
        System.out.println(peakIndexInMountainArray(new int[] {0,10,5,2}));
    }


    /**
     * 简单来说就是一组高度，形成一座山，△，找到山尖的下标
     * 初步判断就是二分法，二分位移条件？
     * l,r,m。如果判断l,r和m的关系，行不通，比如m在山的右边，l 在山的左边，l < m，里面上要l = m，这样就越过了山尖。
     * 如何确保不出现大幅度的跨越？m-1 m m+1进行对比。临近两点判断趋势，向上趋势，移动左边，向下趋势移动右边
     */
    public static int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] < arr[m + 1]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}
