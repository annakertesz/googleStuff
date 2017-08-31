package com.company;

import java.util.List;

/**
 * Created by akertesz on 2017.08.31..
 */
public class Expontential
{
    public static List<Integer>[] calculate(List<Integer> array)
    {
        int maxDiff = 0;
        List<Integer>[] soluton = new List[0];
        int len = array.size();

        for (int i = 1; i < len; i++)
        {
            List<Integer> a = minSubArray(array.subList(0, i));
            List<Integer> b = maxSubArray(array.subList(i, len));

            if (getDiff(a, b) > maxDiff)
            {
                soluton = new List[] { a, b };
                maxDiff = getDiff(a, b);
            }

            a = maxSubArray(array.subList(0, i));
            b = minSubArray(array.subList(i, len));
            if (getDiff(a, b) > maxDiff)
            {
                soluton = new List[] { a, b };
                maxDiff = getDiff(a, b);
            }
        }

        return soluton;
    }

    private static int getDiff(List<Integer> a, List<Integer> b)
    {
        int sumA = 0;
        int sumB = 0;

        for (int num : a)
        {
            sumA += num;
        }

        for (int num : b)
        {
            sumB += num;
        }

        return (sumA < sumB) ? (sumB - sumA) : (sumA - sumB);
    }

    private static List<Integer> maxSubArray(List<Integer> array)
    {
        int maxSum = array.get(0);
        int lastSum = array.get(0);
        int[] maximumArrayIndex = { 0, 0 };
        int[] lastArrayIndex = { 0, 0 };

        for (int i = 1; i < array.size(); i++)
        {
            if (lastSum > 0)
            {
                lastSum += array.get(i);
                lastArrayIndex[1] = i;
            }
            else
            {
                lastSum = array.get(i);
                lastArrayIndex[0] = i;
                lastArrayIndex[1] = i;
            }

            if (lastSum > maxSum)
            {
                maxSum = lastSum;
                maximumArrayIndex[0] = lastArrayIndex[0];
                maximumArrayIndex[1] = lastArrayIndex[1];
            }
        }

        return array.subList(maximumArrayIndex[0], maximumArrayIndex[1] + 1);
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

    private static List<Integer> minSubArray(List<Integer> array)
    {
        int minSum = array.get(0);
        int lastSum = array.get(0);
        int[] minimumArrayIndex = { 0, 0 };
        int[] lastArrayIndex = { 0, 0 };

        for (int i = 1; i < array.size(); i++)
        {
            if (lastSum < 0)
            {
                lastSum += array.get(i);
                lastArrayIndex[1] = i;
            }
            else
            {
                lastSum = array.get(i);
                lastArrayIndex[0] = i;
                lastArrayIndex[1] = i;
            }

            if (lastSum < minSum)
            {
                minSum = lastSum;
                minimumArrayIndex[0] = lastArrayIndex[0];
                minimumArrayIndex[1] = lastArrayIndex[1];
            }
        }

        return array.subList(minimumArrayIndex[0], minimumArrayIndex[1] + 1);
    }
}
