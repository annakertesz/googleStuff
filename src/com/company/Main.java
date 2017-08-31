package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        List<Integer> array = new ArrayList<>(Arrays.asList(2, -1, -2, 1, -4, 2, 8));

        System.out.println("O(n2)");
        for (List list : Expontential.calculate(array))
        {
            System.out.println(list);
        }

        System.out.println("\nO(n)");
        for (List list : Linear.calc(array))
        {
            System.out.println(list);
        }
    }
}
