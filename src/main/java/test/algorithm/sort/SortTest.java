package test.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

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

    // 插入排序
    private static void insertSort() {
        ArrayList<Integer> copy = Lists.newArrayList(TEST_NUMBER);

        for (int i = 0; i < copy.size(); i++) {
            for (int j = i + 1; j > 0; j++) {

            }
        }
    }

    // 归并
    private static void mergeSort() {
        ArrayList<Integer> copy = Lists.newArrayList(TEST_NUMBER);
    }

    // 块排
    private static void quickSort() {
        ArrayList<Integer> copy = Lists.newArrayList(TEST_NUMBER);
    }

    // 堆排序
    private static void heapSort() {
        ArrayList<Integer> copy = Lists.newArrayList(TEST_NUMBER);
    }

    /**
     * 交换i/j的值
     */
    private static void switchValue(int i, int j, List<Integer> copy) {
        int iValue = copy.get(i);
        int jValue = copy.get(j);

        copy.set(i, jValue);
        copy.set(j, iValue);
    }

}
