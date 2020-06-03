package com.rephilo.luandun.leetcode._733;

public class Solution {
    /**
     * 733
     *
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] != newColor) {
            doFloodFill(image, sr, sc, newColor, image[sr][sc]);
        }
        return image;
    }

    public static void doFloodFill(int[][] image, int i, int j, int newColor, int currColor) {
        if (i >= image.length || i < 0) {
            return;
        }

        if (j >= image[0].length || j < 0) {
            return;
        }

        if (image[i][j] == currColor) {
            image[i][j] = newColor;
            doFloodFill(image, i + 1, j, newColor, currColor);
            doFloodFill(image, i - 1, j, newColor, currColor);
            doFloodFill(image, i, j + 1, newColor, currColor);
            doFloodFill(image, i, j - 1, newColor, currColor);
        }
    }
}
