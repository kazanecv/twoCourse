package ru.omsu.imit;

import org.junit.Test;

import static org.junit.Assert.*;

public class SinEquationTest {
    @Test
    public void decideFunctionTest(){
        SinEquation fun = new SinEquation(1,2,1,5);
        assertEquals("Тестирование 2.2 не пройдено![1/2]", -0.7568024953, fun.decideFunction(2),0.000001);
        assertEquals("Тестирование 2.2 не пройдено![2/2]", -0.2794154981, fun.decideFunction(3),0.000001);
    }
    @Test(expected = IllegalArgumentException.class)
    public void decideFunctionTest1(){
        SinEquation fun = new SinEquation(1,2,3,4);
        fun.decideFunction(8);
    }
}