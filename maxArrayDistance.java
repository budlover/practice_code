// get the max distance (i - j). st. array[i] > array[j]

import java.util.ArrayList;
import java.lang.Math;

public class maxArrayDistance {
    public static void main(String args[]) {
        int arr[] = {10,9,8,1,2,3,4,6,5};

        System.out.println(maxdist(arr));
    }

    public static int maxdist(int arr[]) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int min = 9999;
        int max = 1;

        // find all possible starting points
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                list.add(i);
            }
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < list.size(); j++) {
                if (i == list.get(j))
                    break;

                if (arr[i] > arr[list.get(j)]) {
                    if (i - j > max) {
                        // System.out.println(i + ", " + j);
                        max = i - list.get(j);
                    }
                }

            }

        }

        return max;
    }
}
