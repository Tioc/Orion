package com.lookcc.DST;

import org.springframework.util.Assert;

/**
 * @author Tioc
 * created on 2017/12/12
 * @apiNote 查找
 */
public class Search {

    /**
     * @param arr 有序int数组(由小到大)
     * @param key 查找元素
     * @return key在arr中的index
     * @apiNote 二分查找 O(log n)
     */
    int binarySearch(int[] arr, int key) {
        Assert.notNull(arr, "arr can not be null");

        int low = 0,
                high = arr.length - 1,
                mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (key < arr[mid]) {
                high = mid - 1;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return 0;
    }

    /**
     * @param arr 有序int数组(由小到大)
     * @param key 查找元素
     * @return key在arr中的index
     * @apiNote 插值查找 O(log n)
     */
    int interpolationSearch(int[] arr, int key) {
        Assert.notNull(arr, "arr can not be null");

        int low = 0,
                high = arr.length - 1,
                mid;

        while (low <= high) {
            mid = low + (key - arr[low]) / (arr[high] - arr[low]) * (high - low);
            if (key < arr[mid]) high = mid - 1;
            else if (key > arr[mid]) low = mid + 1;
            else return mid;
        }
        return 0;
    }

    /**
     * @param arr 有序int数组(由小到大)
     * @param key 查找元素
     * @return key在arr中的index
     * @apiNote 斐波那契查找 O(log n)
     */
    int fibonacciSearch(int[] arr, int key) {
        Assert.notNull(arr, "arr can not be null");

        final int[] F = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
        int low = 0,
                high = arr.length - 1,
                mid,
                i,
                k = 0;

        while (arr.length > F[k]) {
            k++;
        }
        for (i = arr.length - 1; i < F[k] - 1; i++) {
            arr[i] = arr[arr.length - 1];
        }
        while (low <= high) {
            mid = low + F[k - 1] - 1;
            if (key < arr[mid]) {
                high = mid - 1;
                k = k - 1;
            } else if (key > arr[mid]) {
                low = mid + 1;
                k = k - 2;
            } else {
                if (mid <= arr.length - 1) {
                    return mid;
                } else {
                    return arr.length - 1;
                }
            }
        }
        return 0;
    }

}