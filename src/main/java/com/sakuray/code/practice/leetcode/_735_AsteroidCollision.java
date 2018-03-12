package com.sakuray.code.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * We are given an array asteroids of integers representing asteroids in a row.
   For each asteroid, the absolute value represents its size, and the sign represents its direction 
   (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
   Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. 
   If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
	Example 1:
		Input: asteroids = [5, 10, -5]
		Output: [5, 10]
	Explanation: 
		The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
	Example 2:
		Input: asteroids = [8, -8]
		Output: []
	Explanation: 
		The 8 and -8 collide exploding each other.
	Example 3:
		Input: asteroids = [10, 2, -5]
		Output: [10]
	Explanation: 
		The 2 and -5 collide resulting in -5.  The 10 and -5 collide resulting in 10.
	Example 4:
		Input: asteroids = [-2, -1, 1, 2]
		Output: [-2, -1, 1, 2]
	Explanation: 
		The -2 and -1 are moving left, while the 1 and 2 are moving right.
		Asteroids moving the same direction never meet, so no asteroids will meet each other.
	Note:
		The length of asteroids will be at most 10000.
		Each asteroid will be a non-zero integer in the range [-1000, 1000]..
 */
public class _735_AsteroidCollision {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(asteroidCollision(new int[] {5, 10, -5})));
		System.out.println(Arrays.toString(asteroidCollision(new int[] {8, -8})));
		System.out.println(Arrays.toString(asteroidCollision(new int[] {10, 2, -5})));
		System.out.println(Arrays.toString(asteroidCollision(new int[] {-2, -1, 1, 2})));
		System.out.println(Arrays.toString(asteroidCollision(new int[] {-2,-2, 1,-2})));
		System.out.println(Arrays.toString(asteroidCollision(new int[] {1,-2,-2,-2})));	// -2,-2,-2
		System.out.println(Arrays.toString(asteroidCollision(new int[] {10,2,-5})));
	}
	
	public static int[] asteroidCollision(int[] asteroids) {
		List<Integer> result = new ArrayList<>();
		boolean flag = false;
		for(int i = 0; i < asteroids.length; i++) {
			if(!flag) {
				if(asteroids[i] > 0) {
					flag = true;
				}
				result.add(asteroids[i]);
			} else {
				if(asteroids[i] > 0) {
					result.add(asteroids[i]);
				} else { // 小于0 进行碰撞
					int n = Math.abs(asteroids[i]);
					boolean exist = true;
					while(!result.isEmpty()) {
						int last = result.get(result.size() - 1);
						if(last > 0) {
							if(last > n) {
								exist = false;
								break;
							} else {
								result.remove(result.size() - 1);
								if(n == last) {
									exist = false; break;
								}
							}
						} else {
							break; // 小于0 不可能碰撞
						}
					}
					if(exist) {
						result.add(asteroids[i]);
					}
				}
			}
		}
		int[] r = new int[result.size()];
		for(int i = 0; i < result.size(); i++) {
			r[i] = result.get(i);
		}
        return r;
    }
	
	public int[] asteroidCollision_S(int[] asteroids) {
        int[] mono = new int[asteroids.length];
        int idx = 0;
        for (int aster: asteroids){
            if (idx == 0 || aster > 0 || (aster < 0 && mono[idx - 1] < 0)){
                mono[idx++] = aster;
                continue;
            }
            if (aster < 0){
                while (idx>0 && mono[idx - 1] > 0 && mono[idx - 1] < -aster){
                    idx--;
                }
                if (idx > 0 && mono[idx - 1] > -aster){
                    continue;
                }
                if (idx > 0 && mono[idx - 1] == -aster){
                    idx--;
                    continue;
                }
                if (idx == 0 || mono[idx - 1] < 0){
                        mono[idx++] = aster;
                }

            }
        }
        return Arrays.copyOfRange(mono,0,idx);
    }
}
