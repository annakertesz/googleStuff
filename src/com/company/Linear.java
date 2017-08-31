package com.company;

import java.util.List;

/**
 * Created by akertesz on 2017.08.31..
 */
public class Linear
{
    public static List<Integer>[] calc(List<Integer> array)
    {
        int[][] minMap = getMinMap(array);
        int[][] maxMap = getMaxMap(array);

        if ((min(minMap))[2] < max(maxMap)[1])
        {
            return new List[] { array.subList(min(minMap)[1], min(minMap)[2] + 1), array.subList(max(maxMap)[1], max(maxMap)[2] + 1) };
        }
        else
        {
            return null;
        }
    }

    private static int[][] getMaxMap(List<Integer> array)
    {
        int[][] maxMap = new int[array.size()][3];

        maxMap[0][0] = array.get(0);
        maxMap[0][1] = 0;
        maxMap[0][2] = 0;
        for (int i = 1; i < array.size(); i++)
        {
            maxMap[i] = (maxMap[i - 1][0] > 0) ? new int[] { maxMap[i - 1][0] + array.get(i), maxMap[i - 1][1], i } : new int[]
                {
                    array.get(i), i, i
                };
        }

        return maxMap;
    }

    private static int[][] getMinMap(List<Integer> array)
    {
        int[][] minMap = new int[array.size()][3];

        minMap[0][0] = array.get(0);
        minMap[0][1] = 0;
        minMap[0][2] = 0;
        for (int i = 1; i < array.size(); i++)
        {
            minMap[i] = (minMap[i - 1][0] < 0) ? new int[] { minMap[i - 1][0] + array.get(i), minMap[i - 1][1], i } : new int[]
                {
                    array.get(i), i, i
                };
        }

        return minMap;
    }

    private static int[] max(int[][] array)
    {
        int[] max = array[0];

        for (int i = 1; i < array.length; i++)
        {
            if (array[i][0] > max[0])
            {
                max = array[i];
            }
        }

        return max;
    }

    private static int[] min(int[][] array)
    {
        int[] min = array[0];

        for (int i = 1; i < array.length; i++)
        {
            if (array[i][0] < min[0])
            {
                min = array[i];
            }
        }

        return min;
    }
}
