package edu.bsu.cs222.view;

import java.util.Scanner;

public class UserInput {
    public String inputString(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
