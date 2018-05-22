package com.sakuray.code.practice.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

public class SortTest {
	
	private int[] array = new int[]{21,12,11,53,73,97,84,61,96};
	
	// 插入排序
	@Test
	public void testInsertSort() {
		InsertSort.sortAsc(array);
		System.out.println(Arrays.toString(array));
		System.out.println("----------------------");
		InsertSort.sortDesc(array);
		System.out.println(Arrays.toString(array));
	}
	
	// 归并排序
	@Test
	public void testMergeSort() {
		MergeSort.sort(array);
		System.out.println("----------------------");
	}
	
	// 冒泡排序
	@Test
	public void testBubbleSort() {
		// 注释打印的数组，IO会造成计时误差
		int[] input1 = expand(array,500);
		int[] input2 = expand(array,500);
		long start = System.currentTimeMillis();
		BubbleSort.sort(input1);
		long start2 = System.currentTimeMillis();
		BubbleSort.sort2(input2);
		System.out.println("----------------------" + (start2 - start));
		System.out.println("----------------------" + (System.currentTimeMillis() - start2));
	}
	
	// 插入排序
	@Test
	public void testSelectSort() {
		SelectSort.sort(array);
		System.out.println("----------------------");
	}
	
	// 快速排序
	@Test
	public void testQuickSort() {
		QuickSort.sort(array);
		System.out.println("----------------------");
	}
	
	// 堆排序
	@Test
	public void testHeapSort() {
		HeapSort.sort(array);
		System.out.println("----------------------");
	}
	
	// 基数排序
	@Test
	public void testRadixSort() {
		RadixSort.sort(array, 2);
		System.out.println("----------------------");
	}
	
	
	@Test
	public void testShellSort() {
		ShellSort.sort(array);
		System.out.println("----------------------");
	}
	
	// 扩充排序的数组
	private int[] expand(int[] obj, int multiple) {
		int max = 0x100000; // 1024 * 1024;
		int aim = obj.length * multiple;
		if(aim > max) {
			System.out.println("数组扩充过大");
		}
		int[] result = new int[aim];
		for(int i = 0; i < multiple; i++) {
			for(int j = 0; j < obj.length; j++) {
				result[i * obj.length + j] = obj[j];
			}
		}
		return result;
	}
}
