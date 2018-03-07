package com.sakuray.code.practice.leetcode;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
   If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
   The replacement must be in-place, do not allocate extra memory.
   Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
		1,2,3 → 1,3,2
		3,2,1 → 1,2,3
		1,1,5 → 1,5,1
   排列（Arrangement），简单讲是从N个不同元素中取出M个，按照一定顺序排成一列，通常用A(M,N)表示。当M=N时，称为全排列（Permutation）。从数学角度讲，全排列的个数A(N,N)=(N)*(N-1)*...*2*1=N!，但从编程角度，如何获取所有排列？那么就必须按照某种顺序逐个获得下一个排列，通常按照升序顺序（字典序）获得下一个排列。
   例如对于一个集合A={1,2,3,}，首先获取全排列a1: 1,2,3,；然后获取下一个排列a2: 1,3,2,；按此顺序，A的全排列如下：
  a1: 1,2,3;　　a2: 1,3,2;　　a3: 2,1,3;　　a4: 2,3,1;　　a5: 3,1,2;　　a6: 3,2,1;　　共6种。
  https://www.cnblogs.com/eudiwffe/p/6260699.html
  a1的下一个排列就是a2
 */
public class _031_NextPermutation {

	public static void main(String[] args) {
//		nextPermutation(new int[] {1,2,3});
//		nextPermutation(new int[] {3,2,1});
//		nextPermutation(new int[] {1,1,5});
//		nextPermutation(new int[] {1,2,4,3,5});
//		nextPermutation(new int[] {2,3,1});
//		nextPermutation(new int[] {1,3,2});
		nextPermutation(new int[] {5,4,7,5,3,2});
	}
	
	/**
	 * 1.倒序遍历数组找到i < j n[i] <n[j]的i  j 值
	 * 2.[j,end)中找到最小的值  满足 n[i] < n[k]  k 最小
	 * 3.交换i和k
	 * 4.逆序[j, end)
	 * @param nums
	 */
	public static void nextPermutation(int[] nums) {
        int m = -1, n = 0;
        for(int i = nums.length - 1; i > 0; i--) {
        	if(nums[i - 1] < nums[i]) {
        		m = i -1;
        		n = i;
        		break;
        	}
        }
        if(m != -1) {
        	int k = -1;
        	for(int i = nums.length - 1; i >= n; i--) {
        		if(nums[m] < nums[i]) {
        			k = i;
        			break;
        		}
        	}
        	int tmp = nums[m];
        	nums[m] = nums[k];
        	nums[k] = tmp;
        }
        for(int i = n, j = nums.length - 1; i < j; i++, j--) {
        	int tmp = nums[i];
        	nums[i] = nums[j];
        	nums[j] = tmp;
        }
    }
	
	public void nextPermutation_S(int[] num) {
	    int n=num.length;
	    if(n<2)
	        return;
	    int index=n-1;        
	    while(index>0){
	        if(num[index-1]<num[index])
	            break;
	        index--;
	    }
	    if(index==0){
	        reverseSort(num,0,n-1);
	        return;
	    }
	    else{
	        int val=num[index-1];
	        int j=n-1;
	        while(j>=index){
	            if(num[j]>val)
	                break;
	            j--;
	        }
	        swap(num,j,index-1);
	        reverseSort(num,index,n-1);
	        return;
	    }
	}

	public void swap(int[] num, int i, int j){
	    int temp=0;
	    temp=num[i];
	    num[i]=num[j];
	    num[j]=temp;
	}

	public void reverseSort(int[] num, int start, int end){   
	    if(start>end)
	        return;
	    for(int i=start;i<=(end+start)/2;i++)
	        swap(num,i,start+end-i);
	}
}
