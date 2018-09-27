package test.algorithm.sort;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * @author cf.cao
 * @desc 排序算法测试
 */
public class SortTest {

    private static final List<Integer> TEST_NUMBER = Lists.newArrayList(10, 8, 9, 7, 4, 3, 2, 1, 0, 6, 5);

    public static void main(String[] args) {
        bubbleSort();
        selectSort();
        insertSort();

        mergeSort();
        quickSort();
        heapSort();
    }

    // 冒泡排序
    private static void bubbleSort() {
        ArrayList<Integer> copy = Lists.newArrayList(TEST_NUMBER);
        for (int i = 0; i < copy.size(); i++) {
            for (int j = copy.size() - 1; j > i; j--) {
                if (copy.get(j) < copy.get(j - 1)) {
                    switchValue(j, j - 1, copy);
                }
            }
        }

        System.out.println("bubble:" + copy);
    }

    // 选择排序
    private static void selectSort() {
        ArrayList<Integer> copy = Lists.newArrayList(TEST_NUMBER);
        for (int i = 0; i < copy.size(); i++) {
            int tempIdx = i;
            int smallest = copy.get(i);
            for (int j = i + 1; j < copy.size(); j++) {
                Integer jValue = copy.get(j);
                if (smallest > jValue) {
                    smallest = jValue;
                    tempIdx = j;
                }
            }
            switchValue(i, tempIdx, copy);
        }
        System.out.println("select:" + copy);
    }

    // 插入排序,使用链表， 不需要移动顺序
    private static void insertSort() {
        LinkedList<Integer> copy = Lists.newLinkedList(TEST_NUMBER);

        for (int i = 0; i < copy.size(); i++) {
            int value = copy.remove(i);
            // 选择一个位置直接插入
            for (int j = i - 1; j >= -1; j--) {
                if (j == -1 || value >= copy.get(j)) {
                    copy.add(j + 1, value);
                    break;
                }
            }
        }

        System.out.println("insert:" + copy);
    }

    // 归并
    private static void mergeSort() {
        ArrayList<Integer> copy = Lists.newArrayList(TEST_NUMBER);


    }

    private static void merge(ArrayList<Integer> value, int start, int start2, int end) {
        ArrayList<Integer> result = Lists.newArrayList();

        int i = start, j = start2;
        for (; i <= start2 && j <= end; ) {
            if (value.get(i) < value.get(j)) {
                result.add(value.get(i));
                i++;
            } else {
                result.add(value.get(j));
                j++;
            }
        }

        while (i < start2) {
            result.add(i++);
        }

        while (j < end) {
            result.add(j++);
        }

        // 最后把结果复制过去
        for (int idx = start; idx <= end; idx++) {
            value.set(idx, result.get(idx));
        }
    }

    // 块排
    private static void quickSort() {
        ArrayList<Integer> copy = Lists.newArrayList(TEST_NUMBER);

        int length = copy.size() - 1;
        quickSort(copy, 0, length);

        System.out.println("quickSort:" + copy);
    }

    private static void quickSort(ArrayList<Integer> value, int start, int end) {
        if (start >= end) {
            return;
        }

        int i = start;
        int j = end;
        int sortValue = value.get(start);
        while (i < j) {
            while (sortValue > value.get(i) && i < j) {
                i++;
            }

            while (sortValue < value.get(j) && i < j) {
                j--;
            }

            switchValue(i, j, value);
        }

        quickSort(value, start, i - 1);
        quickSort(value, i + 1, end);
    }

    // 堆排序
    private static void heapSort() {
        ArrayList<Integer> copy = Lists.newArrayList(TEST_NUMBER);
    }

    private static void buildHead(ArrayList<Integer> value) {
        for (int i = 0; i < value.size() >> 1; i++) {

        }
    }


    /**
     * 交换i/j的值
     */
    private static void switchValue(int i, int j, List<Integer> copy) {
        if (i == j) {
            return;
        }
        int iValue = copy.get(i);
        int jValue = copy.get(j);

        copy.set(i, jValue);
        copy.set(j, iValue);
    }

}
