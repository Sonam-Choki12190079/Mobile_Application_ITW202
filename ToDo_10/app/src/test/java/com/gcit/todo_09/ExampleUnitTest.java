package com.gcit.todo_09;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.*;

import androidx.test.filters.SmallTest;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;




/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
@SmallTest
public class ExampleUnitTest {
    private Calculator CalculateOperation;
    @Before
    public void SetUp(){
        CalculateOperation = new Calculator();

    }
    //for addition
    @Test
    public void addTwoNumber(){
        double result = CalculateOperation.Add(2d,2d);
        assertThat(result, is(equalTo(4d)));
    }
    //for multiplication
    @Test
    public void MulTwoValue(){
        double result = CalculateOperation.Mul(2d,3d);
        assertThat(result,is(equalTo(6d)));

    }
    //for substration
    @Test
    public void subWorksWithNegativeResults(){
        double result = CalculateOperation.Sub(4d,6d);
        assertThat(result,is(equalTo(-2d)));

    }
    //with negative argument for substration
    @Test
    public void subNegative(){
        double result = CalculateOperation.Sub(-7d,10d);
        assertThat(result,is(equalTo(3d)));

    }
    @Test
    public  void TwoNegativeValue(){
        double result = CalculateOperation.Sub(-6d,-3d);
        assertThat(result,is(equalTo(-3d)));
    }
    @Test
    public void mulTwoNumbersZero(){
        double result = CalculateOperation.Mul(4d,0d);
        assertThat(result,is(equalTo(0d)));
    }
    @Test
    public void divTwoNumbers(){
        double result = CalculateOperation.Div(9d,3d);
        assertThat(result,is(equalTo(3d)));
    }
    @Test
    public void addTwoFloat(){
        double result = CalculateOperation.Add(1.111f,1.111f);
        assertThat(result,is(closeTo(2.222, 0.01)));
    }
    @Test
    public void divTwoNumbersZero(){
        double result = CalculateOperation.Div(22d,0d);
        assertThat(result,is(equalTo(Double.POSITIVE_INFINITY)));
    }



}