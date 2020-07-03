package com.company;

import java.util.Scanner;

public class FirstInput {
    private String[] State = new String[]{"q1", "q2", "qf"};
    enum  possibility  {a, b, ab,lambda};
    possibility possibility;
    private int state;

    private String input;
    private String symbol;
    Stack stack;

    public FirstInput() {
        GetInput();
    }

    private void GetInput() {
        Scanner scann = new Scanner(System.in);
        input = scann.next();
        stack = new Stack();
    }



    public boolean commit() throws IndexOutOfBoundsException {
        possibility = possibility.ab;
        InputReader inputReader = new InputReader(input);
        for (int i = 0; i < input.length() + 1; ++i) {
            symbol = inputReader.GetInputSymbol();
            switch (symbol) {
                case "a":
                    if (possibility.equals(possibility.ab)){
                        stack.Push("1");
                        setState(0);
                    }
                    else return false;
            break;
            case "b":
                possibility = possibility.b;
                if (stack.Pop().equals("1") && possibility.equals(possibility.b)) {
                    setState(1);
                }
                break;
            case "$":
                if (stack.Pop().equals("$")) {
                    setState(2);
                }
                break;
        }
    }
        if(

    getState() ==2)

    {
        return true;
    } else
            return false;
}

    private void ShowState() {
        System.out.println(State[getState()]);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        ShowState();
    }
}
