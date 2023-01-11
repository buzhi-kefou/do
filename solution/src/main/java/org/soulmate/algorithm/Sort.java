package org.soulmate.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Sort {

    public static void main(String[] args) {
        Random random = new Random(System.currentTimeMillis());
        int bound = 1024, length = 1000, checkSize = 100;

        int[] array = new int[length];
        for (int j = 0; j < checkSize; j++) {
            for (int i = 0; i < array.length; i++)
                array[i] = random.nextInt(bound);

            BubbleSort(array);
            SelectionSort(array);
            InsertionSort(array);

            ShellSort(array);
            MergeSort(array, 0, array.length - 1);
            QuickSort(array, 0, array.length - 1);

            array = CountingSort(array);
            array = RadixSort(array);
            BucketSort(array);
            Heapsort(array);

            check(array);
        }
        System.out.println("finish");
    }

    private static boolean check(int[] array, int[] copy) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != copy[i]) {
                System.out.println(Arrays.toString(array));
                return false;
            }
        }
        return true;
    }

    private static boolean check(int[] array) {
        int len = array.length;
        for (int i = 0, j = 1; j < len; i++, j++) {
            if (array[i] > array[j]) {
                System.out.println(Arrays.toString(array));
                return false;
            }
        }
        return true;
    }

    /**
     * 每次找出第i小的元素，然后将这个元素与数组第i个位置上的元素交换
     */

    private static void SelectionSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            int ptr = i;
            for (int j = i + 1; j < len; j++) {
                if (array[ptr] > array[j]) {
                    ptr = j;
                }
            }
            if (ptr != i) {
                swap(array, i, ptr);
            }
        }
    }

    /**
     * 在算法的执行过程中，较小的元素慢慢移到数列的顶端
     */

    private static void BubbleSort(int[] array) {
        int len = array.length, swap;
        do {
            swap = 0;
            for (int i = 0, j = 1; j < len; i++, j++) {
                if (array[i] > array[j]) {
                    swap(array, i, j);
                    swap++;
                }
            }
        } while (swap > 0);
    }

    /**
     * 将元素划分为「已排序」和「未排序」两部分，每次从「未排序」元素中选择一个插入到「已排序」元素中的正确位置
     */

    private static void InsertionSort(int[] array) {
        int len = array.length;
        for (int i = 1; i < len; i++) {
            int key = array[i], j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    /**
     * 计数、前缀和
     */

    private static int[] CountingSort(int[] array) {
        int len = array.length;
        int[] count = new int[1024];
        for (int i = 0; i < len; i++) {
            count[array[i]]++;
        }

        len = count.length;
        for (int i = 1; i < len; i++) {
            count[i] += count[i - 1];
        }

        len = array.length;
        int[] sorted = new int[len];
        while (len-- > 0) {
            int val = array[len], ptr = --count[val];
            sorted[ptr] = val;
        }
        return sorted;
    }

    /**
     * 基数排序
     */

    private static int[] RadixSort(int[] array) {
        int mod = 1, len = array.length, max = Integer.MIN_VALUE;
        int[] count, sorted = new int[len];
        boolean flag = true;

        while (flag || max >= mod) {
            count = new int[10];
            mod *= 10;

            for (int i = 0; i < len; i++) {
                count[radix(array[i], mod)]++;
                if (flag && max < array[i])
                    max = array[i];
            }

            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }

            for (int i = len - 1; i >= 0; i--) {
                int ptr = --count[radix(array[i], mod)];
                sorted[ptr] = array[i];
            }

            if (flag) flag = false;

            int[] temp = array;
            array = sorted;
            sorted = temp;

        }
        return array;
    }

    private static int radix(int val, int mod) {
        return val / (mod / 10) % 10;
    }

    private static void QuickSort(int[] array, int l, int r) {
        if (l < r) {
            int h = l, t = r, key = array[l];
            while (h <= t) {
                // 小于等于key
                while (h <= t && array[h] <= key) {
                    h++;
                }
                // 严格大于key
                while (array[t] > key) {
                    t--;
                }
                if (h <= t) swap(array, h++, t--);
            }
            if (key > array[t]) swap(array, l, t);

            // 右区域严格大于key,不会越界
            QuickSort(array, l, --t);
            QuickSort(array, h, r);
        }
    }

    private static int quickSelect(int[] array, int l, int r, int ptr) {
        int left = l, right = r, key = array[l];
        while (left <= right) {
            while (left <= right && array[left] <= key)
                left++;
            while (array[right] > key)
                right--;
            if (left <= right) swap(array, left++, right--);
        }
        if (array[right] < key) swap(array, right, l);

        if (right == ptr)
            return array[right];

        if (right > ptr) {
            return quickSelect(array, l, right - 1, ptr);
        } else {
            return quickSelect(array, right + 1, r, ptr);
        }
    }

    static int[] temp = null;
    private static void MergeSort(int[] array, int l, int r) {
        if (temp == null)
            temp = new int[array.length];

        if (l < r) {
            int m = (r - l) / 2 + l;
            MergeSort(array, l, m);
            MergeSort(array, m + 1, r);

            int ptr = l, left = l, right = m + 1;
            while (left <= m && right <= r) {
                if (array[left] <= array[right]) {
                    temp[ptr++] = array[left++];
                } else {
                    temp[ptr++] = array[right++];
                }
            }
            while (left <= m) {
                temp[ptr++] = array[left++];
            }
            while (right <= r) {
                temp[ptr++] = array[right++];
            }

            ptr = l;
            while (ptr <= r) {
                array[ptr] = temp[ptr];
                ptr++;
            }
        }
    }

    private static void Heapsort(int[] array) {
        int[] heap = array;
        // left 2*x+1 right 2*x+2
        heapBuild(heap);
        int len = heap.length;
        while (len > 0) {
            heapRemove(heap, --len);
        }
    }

    private static void heapBuild(int[] heap) {
        int last = heap.length - 1;

        while (last != 0) {
            if (last % 2 == 0) {//right
                int p = (last - 2) / 2, l = last - 1;
                // 需要上移
                if (heap[p] < heap[l] || heap[p] < heap[last]) {
                    int s = heap[l] > heap[last] ? l : last;
                    heapUp(heap, p, s, heap.length - 1);
                }
            } else {//left
                int p = (last - 1) / 2;
                if (heap[p] < heap[last])
                    heapUp(heap, p, last, heap.length - 1);
            }
            last--;
        }
    }

    private static void heapUp(int[] heap, int f, int s, int r) {
        int tmp = heap[f];
        heap[f] = heap[s];
        heap[s] = tmp;
        heapCheck(heap, s, r);
    }

    private static void heapCheck(int[] heap, int x, int r) {
        int sl = 2 * x + 1, sr = 2 * x + 2;
        if (sl > r) return;
        // two
        if (sr <= r) {
            if (heap[x] < heap[sl] || heap[x] < heap[sr])
                heapDown(heap, x, heap[sl] > heap[sr] ? sl : sr, r);
            // one
        } else {
            if (heap[x] < heap[sl])
                heapDown(heap, x, sl, r);
        }
    }

    private static void heapDown(int[] heap, int f, int s, int r) {
        int tmp = heap[f];
        heap[f] = heap[s];
        heap[s] = tmp;
        heapCheck(heap, s, r);
    }

    private static void heapRemove(int[] heap, int size) {
        if (size == 0)
            return;
        int temp = heap[size];
        heap[size] = heap[0];
        heap[0] = temp;
        heapCheck(heap, 0, --size);
    }

    private static void BucketSort(int[] array) {
        ArrayList<Integer>[] buckets = new ArrayList[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList();
        }

        int maxValue = 1024;
        for (int i = 0; i < array.length; i++) {
            buckets[array[i] * buckets.length / maxValue].add(array[i]);
        }

        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            buckets[i].sort((x, y) -> x - y);
            for (Integer integer : buckets[i]) {
                array[index++] = integer;
            }
        }
    }

    private static void ShellSort(int[] array) {
        int len = array.length, gap = len / 2;
        while (gap != 0) {
            for (int i = gap; i < len; i++) {
                int key = array[i], j = i;
                for (; j >= gap && array[j - gap] > key; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = key;
            }
            gap--;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
