package com.lookcc.DST;

import org.springframework.util.Assert;

/**
 * @author Tioc
 * created on 2017/12/13
 * @apiNote 排序
 */
public class Sort {

    /**
     * @param arr 无序数组
     * @return 有序数组
     * @apiNote 冒泡排序 O(n^2)
     */
    int[] bubbleSort(int[] arr) {
        Assert.notNull(arr, "arr can not be null");

        boolean flag = true;
        for (int i = 0; i < arr.length && flag; i++) {
            flag = false;
            for (int j = arr.length - 1; j >= i; j--) {
                if (arr[j] > arr[j + 1]) {
                    this.swap(arr[j], arr[j + 1]);
                    flag = true;
                }
            }
        }
        return arr;
    }

    /**
     * @param arr 无序数组
     * @return 有序数组
     * @apiNote 简单选择排序 O(n^2)
     */
    int[] selectSort(int[] arr) {
        Assert.notNull(arr, "arr can not be null");

        int min;
        for (int i = 0; i < arr.length; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (i != min) {
                this.swap(arr[i], arr[min]);
            }
        }
        return arr;
    }

    /**
     * @param arr 无序数组
     * @return 有序数组
     * @apiNote 直接插入排序 O(n^2)
     */
    int[] insertSort(int[] arr) {
        Assert.notNull(arr, "arr can not be null");

        int temp, i, j;
        for (i = 1; i <= arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                temp = arr[i];
                for (j = i - 1; arr[j] > temp; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = temp;
            }
        }
        return arr;
    }

    /**
     * @param arr 无序数组
     * @return 有序数组
     * @apiNote 希尔排序 O(n^ 3/2)
     */
    int[] shellSort(int[] arr) {
        Assert.notNull(arr, "arr can not be null");

        int increment = arr.length;
        int temp, i, j;
        do {
            increment = increment / 3 + 1;
            for (i = increment + 1; i <= arr.length; i++) {
                if (arr[i] < arr[i - increment]) {
                    temp = arr[i];
                    for (j = i - increment; j > 0 && temp < arr[j]; j -= increment) {
                        arr[j + increment] = arr[j];
                    }
                    arr[j + increment] = temp;
                }
            }

        } while (increment > 1);
        return arr;
    }

    /**
     * @param arr 无序数组
     * @return 有序数组
     * @apiNote 堆排序 O(n*log n)
     */
    int[] heapSort(int[] arr) {
        Assert.notNull(arr, "arr can not be null");

        int i;
        for (i = arr.length / 2; i > 0; i--) {
            this.heapAdjust(arr, i, arr.length);
        }
        for (i = arr.length; i > 1; i--) {
            this.swap(arr[0], arr[i]);
            this.heapAdjust(arr, 1, i - 1);
        }
        return arr;
    }

    /**
     * @apiNote 构建堆
     */
    void heapAdjust(int[] arr, int s, int m) {
        int temp, j;
        temp = arr[s];
        for (j = 2 * s; j <= m; j *= 2) {
            if (j < m && arr[j] < arr[j + 1]) ++j;
            if (temp >= arr[j]) break;
            arr[s] = arr[j];
            s = j;
        }
        arr[s] = temp;
    }

    /**
     * @param arr 无序数组
     * @return 有序数组
     * @apiNote 归并排序 O(n*log n)
     */
    int[] mergeSort(int[] arr) {
        Assert.notNull(arr, "arr can not be null");

        return arr;
    }

    /**
     * @param arr 无序数组
     * @return 有序数组
     * @apiNote 快速排序 O(n*log n)
     */
    int[] quickSort(int[] arr) {
        Assert.notNull(arr, "arr can not be null");

        this.QSort(arr, 1, arr.length);

        return arr;
    }

    void QSort(int[] arr, int low, int high) {
        int pivot;
        if (low < high) {
            pivot = Partition(arr, low, high);
            QSort(arr, low, pivot - 1);
            QSort(arr, pivot + 1, high);
        }
    }

    int Partition(int[] arr, int low, int high) {
        int pivotkey = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivotkey)
                high--;
            swap(arr[low], arr[high]);
            while (low < high && arr[low] <= pivotkey)
                low++;
            swap(arr[low], arr[high]);
        }
        return low;
    }

    /**
     * @apiNote 交换两个int值
     */
    void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }


}