package com.company;


public class Main {

    public static void main(String[] args) {
        FirstOne();
    }

    private static void FirstOne() {
        FirstInput firstInput = new FirstInput();
        try {
            if (firstInput.commit()) {
                System.out.println("ACCEPTED!");
            } else System.out.println("REJECTED :(");
        } catch (IndexOutOfBoundsException ix) {
            System.out.println("Rejected :(");
        }
    }
}
