package hpah.other;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.InputStream;

public class OptiScanner {
    private Scanner sc;
    public OptiScanner(InputStream inputStream){
        sc = new Scanner(inputStream);
    }

    public int requestInt(String desc, int maxNumber){
        System.out.println(desc);

        int input = -1;
        boolean validInput = false;
        do {
            try {
                System.out.println("Enter a number:");
                input = sc.nextInt();
                validInput = true;
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
                sc.nextLine();
            }
        } while (!validInput || input < 0 || input > maxNumber);

        return input;
    }

    public String requestString(){
        return sc.nextLine();
    }

    public void pressSpace() {
        //Catch key pressed

    }

}

