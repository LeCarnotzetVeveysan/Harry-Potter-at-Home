package hpah.other;

import java.util.Scanner;
import java.io.InputStream;

public class OptiScanner {
    private Scanner sc;
    public OptiScanner(InputStream inputStream){
        sc = new Scanner(inputStream);
    }

    public int requestInt(){
        int input = sc.nextInt();
        sc.nextLine();
        return input;
    }

    public String requestString(){
        return sc.nextLine();
    }

}

