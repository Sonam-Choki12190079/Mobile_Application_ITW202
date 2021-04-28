package com.gcit.todo_09;

public class Calculator {
    public enum Operator{ADD, SUB, MUL,DIV };

    public double Add(double operandOne, double operandTwo){
        return operandOne + operandTwo;

    }
    public double Sub(double operandOne, double operandTwo){
        return operandOne - operandTwo;

    }
    public double Mul(double operandOne, double operandTwo){
        return  operandOne * operandTwo;

    }
    public double Div(double operandOne, double operandTwo){
        return operandOne / operandTwo;

    }

}
