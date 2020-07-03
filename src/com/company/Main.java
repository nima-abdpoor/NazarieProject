package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hi ... \nfor 'a' and 'b' input please enter 0 and for math input enter 1");
        Scanner scanner=new Scanner(System.in);
        FirstOne(scanner.nextInt());
    }

    private static void FirstOne(int n) {
        FirstInput firstInput = new FirstInput();
        try {
            if (firstInput.commit(n)) {
                System.out.println("ACCEPTED!");
            } else System.out.println("REJECTED :(");
        } catch (IndexOutOfBoundsException ix) {
            System.out.println("Rejected :(");
        }
        finally {
            System.out.println(firstInput.Reason());
        }
    }
}
