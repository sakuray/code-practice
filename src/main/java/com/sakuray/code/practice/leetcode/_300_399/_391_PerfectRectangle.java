package com.sakuray.code.practice.leetcode._300_399;

import java.util.HashSet;
import java.util.Set;

import com.sakuray.code.practice.leetcode.Tools;

/**
 * Given an array rectangles where rectangles[i] = [xi, yi, ai, bi] represents an axis-aligned rectangle.
 * The bottom-left point of the rectangle is (xi, yi) and the top-right point of it is (ai, bi).
 * Return true if all the rectangles together form an exact cover of a rectangular region.
 * <p>
 * Input: rectangles = [[1,1,3,3],[3,1,4,2],[3,2,4,4],[1,3,2,4],[2,3,3,4]]
 * Output: true
 * Explanation: All 5 rectangles together form an exact cover of a rectangular region.
 * <p>
 * Input: rectangles = [[1,1,2,3],[1,3,2,4],[3,1,4,2],[3,2,4,4]]
 * Output: false
 * Explanation: Because there is a gap between the two rectangular regions.
 * <p>
 * Input: rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[2,2,4,4]]
 * Output: false
 * Explanation: Because two of the rectangles overlap with each other.
 */
public class _391_PerfectRectangle {

    public static void main(String[] args) {
        System.out.println(isRectangleCover(Tools.build2Array(4, 1, 1, 3, 3, 3, 1, 4, 2, 3, 2, 4, 4, 1, 3, 2, 4, 2, 3, 3, 4)));
        System.out.println(isRectangleCover(Tools.build2Array(4, 1, 1, 2, 3, 1, 3, 2, 4, 3, 1, 4, 2, 3, 2, 4, 4)));
        System.out.println(isRectangleCover(Tools.build2Array(4, 1, 1, 3, 3, 3, 1, 4, 2, 1, 3, 2, 4, 2, 2, 4, 4)));
        System.out.println(isRectangleCover(Tools.build2Array(4, 0,0,4,1,7,0,8,2,6,2,8,3,5,1,6,3,4,0,5,1,6,0,7,2,4,2,5,3,2,1,4,3,0,1,2,2,0,2,2,3,4,1,5,2,5,0,6,1)));
    }

    /**
     * 判断多个矩形是否能拼出一个矩形，没有重叠和缺少。
     * 判断拼出来的矩形左上和右下节点，计算矩形面积。如果面积相等，且没有重叠，则是完美矩形
     * 判断有没有重叠，判断每个矩形的顶点即可。1个点最多出现4次，超过4次就重叠了。低于四次还需要判断顶点个数。
     * 只有点位出现1次或者3次，其才是顶点。也就是奇数次
     */
    public static boolean isRectangleCover(int[][] rectangles) {
        int[] maxRectangles = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        int area = 0;
        Set<String> points = new HashSet<>();
        for (int[] rectangle : rectangles) {
            area += getArea(rectangle);
            maxRectangles[0] = Math.min(maxRectangles[0], rectangle[0]);
            maxRectangles[1] = Math.min(maxRectangles[1], rectangle[1]);
            maxRectangles[2] = Math.max(maxRectangles[2], rectangle[2]);
            maxRectangles[3] = Math.max(maxRectangles[3], rectangle[3]);
            String p1 = rectangle[0] + "," + rectangle[1];
            String p2 = rectangle[0] + "," + rectangle[3];
            String p3 = rectangle[2] + "," + rectangle[1];
            String p4 = rectangle[2] + "," + rectangle[3];
            for (String p : new String[]{p1, p2, p3, p4}) {
                if (points.contains(p)) {
                    points.remove(p);
                } else {
                    points.add(p);
                }
            }
        }
        if (points.size() != 4) {
            return false;
        }
        String[] ps = new String[]{
                maxRectangles[0] + "," + maxRectangles[1],
                maxRectangles[0] + "," + maxRectangles[3],
                maxRectangles[2] + "," + maxRectangles[1],
                maxRectangles[2] + "," + maxRectangles[3]
        };
        for (String p : ps) {
            if (!points.contains(p)) {
                return false;
            }
        }
        return area == getArea(maxRectangles);
    }

    private static int getArea(int[] rectangle) {
        return (rectangle[2] - rectangle[0]) * (rectangle[3] - rectangle[1]);
    }
}
