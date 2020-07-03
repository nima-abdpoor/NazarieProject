package com.company;

import java.util.Scanner;

public class FirstInput {
    private String[] State = new String[]{"q1", "q2", "qf"};
    int a = 0;

    enum possibility {a, b, ab, lambda}

    possibility possibility;
    private int state;

    private String input;
    private String symbol;
    Stack stack;

    public FirstInput() {
        GetInput();
    }

    private String GetInput() {
        stack = new Stack();
        Scanner scann = new Scanner(System.in);
        input = scann.next();
        return input;
    }


    public boolean commit(int n) throws IndexOutOfBoundsException {
        possibility = possibility.ab;
        String result =getinput(input,n);
        InputReader inputReader = new InputReader(result);
        System.out.println(result);
        for (int i = 0; i < result.length() + 1; ++i) {
            symbol = inputReader.GetInputSymbol();
            switch (symbol) {
                case "a":
                    if (possibility.equals(possibility.ab)) {
                        stack.Push("1");
                        setState(0);
                    } else return false;
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
        if (

                getState() == 2) {
            return true;
        } else
            return false;
    }

    public String Reason() {
        switch (stack.size()) {
            case 0:
                return "accepted";
            case -1:
                return "cause it closes the parantes but doesnt open it";
            default:
                return "cause it opens " + stack.size() + " more parantes but doesnt close it";
        }
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

    private String getinput(String input, int n) {
        if (n == 1) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < input.length(); ++i) {
                if (input.charAt(i) == '(') {
                    result.append("a");
                } else if (input.charAt(i) == ')') {
                    result.append("b");
                }

            }
            return result.toString();
        }
        else if (n == 0) {
            return input;
        }
        return null;
    }
}
