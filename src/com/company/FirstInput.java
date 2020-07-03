package com.company;

import java.util.Scanner;

public class FirstInput {
    private String[] State = new String[]{"q1", "q2", "qf"};
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

    public boolean commit() throws IndexOutOfBoundsException{
        InputReader inputReader = new InputReader(input);
        for (int i = 0; i < input.length() + 1; ++i) {
            symbol = inputReader.GetInputSymbol();
            switch (symbol) {
                case "a":
                    stack.Push("1");
                    setState(0);
                    ShowState();
                    break;
                case "b":
                    stack.Pop();
                    setState(1);
                    ShowState();
                    break;
                case "$":
                    if (stack.Pop().equals("$")) {
                        setState(2);
                        ShowState();
                    }
                    break;
            }
        }
        if (getState() == 2) {
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
    }
}
