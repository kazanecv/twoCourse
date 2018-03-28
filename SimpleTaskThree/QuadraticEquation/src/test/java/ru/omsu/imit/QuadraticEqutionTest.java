package ru.omsu.imit;

import org.junit.Test;
import static org.junit.Assert.*;

public class QuadraticEqutionTest {
    @Test
    public void testSolveEquetion(){
        QuadraticEqution a = new QuadraticEqution(1,-70,600);
        double[] res = new double[2];
        res[0]=60;
        res[1]=10;
        assertArrayEquals("Ошибка тестирования квадратного трёхчлена [1/3]",res,a.solveEquetion(),0.0001);
        a = new QuadraticEqution(3,-18,27);
        res = new double[1];
        res[0]=3;
        assertArrayEquals("Ошибка тестирования квадратного трёхчлена [2/3]",res,a.solveEquetion(),0.0001);
        a = new QuadraticEqution(1,2,3);
        res = new double[0];
        assertArrayEquals("Ошибка тестирования квадратного трёхчлена [3/3]",res,a.solveEquetion(),0.0001);
    }
}