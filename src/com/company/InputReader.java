package com.company;

public class InputReader {
    private String input;
    private String inputInProgress;

    public InputReader(String input) {
        this.input = input;
        this.input+="$" ;
    }

    public String GetInputSymbol() {
        StringBuilder sb = new StringBuilder(input);
        input=sb.substring(1,sb.length());
        inputInProgress = sb.substring(0,1);
        return inputInProgress;
    }
}
