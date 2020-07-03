package com.company;

import java.util.ArrayList;

public class Stack {
    private int index;
    ArrayList stackList;

    public Stack() {
        stackList = new ArrayList();
        Push("$");
    }

    public void Push(String number) {
        stackList.add(number);
        index++;
    }

    public String Pop() {
        index--;
        if (index != -1)
            return (String) stackList.get(index);
        else {
            throw new IndexOutOfBoundsException();
        }
    }
}
