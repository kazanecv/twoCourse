package ru.omsu.imit;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntegrateFuctionTest {
    @Test
    public void decideFanctionalTest(){
        IntegrateFuction processor = new IntegrateFuction();
        LineEquation fun = new LineEquation(1,2,1,5);
        assertEquals("Тестирование 4.2 не пройдено![1/2]", 3.5, processor.decideFanctional(fun,1,2),0.001);
        fun = new LineEquation(1,2,10,15);
        assertEquals("Тестирование 4.2 не пройдено![2/2]", 28, processor.decideFanctional(fun,11,13),0.001);
    }
    @Test
    public void decideFanctionalTest1(){
        IntegrateFuction processor = new IntegrateFuction();
        SinEquation fun = new SinEquation(1,1,-100,100);
        assertEquals("Тестирование 4.2 не пройдено!---", -2, processor.decideFanctional(fun,Math.PI,Math.PI*2),1e-6);
    }
}