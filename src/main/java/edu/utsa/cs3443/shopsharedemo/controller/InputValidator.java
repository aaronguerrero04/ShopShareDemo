package main.java.edu.utsa.cs3443.shopsharedemo.controller;

import java.util.Scanner;

public class InputValidator {

    public static int getIntInRange(int min, int max){
        Scanner scnr = new Scanner(System.in);
        int userInt = scnr.nextInt();

        while (userInt < min || userInt > max){
            userInt = scnr.nextInt();
        }
        scnr.close();
        return userInt;
    }
}
