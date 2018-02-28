package ru.omsu.imit;

import org.junit.Test;

import static org.junit.Assert.*;

public class SumPointTest {
    @Test
    public void decideFanctionalTest(){
        SumPoint processor = new SumPoint();
        LineEquation fun = new LineEquation(1,2,1,5);
        assertEquals("Тестирование 4.1 не пройдено![1/2]", 13.5, processor.decideFanctional(fun,2,3),0.001);
        fun = new LineEquation(1,2,1,10);
        assertEquals("Тестирование 4.1 не пройдено![2/2]", 24, processor.decideFanctional(fun,3,9),0.001);
    }
}