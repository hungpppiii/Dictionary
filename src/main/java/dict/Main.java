package dict;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DictionaryCommandline dictCommandline = new DictionaryCommandline();
        Scanner sc = new Scanner(System.in);
        int value;
        while(true) {
            System.out.println("\t1.vao dictionary");
            System.out.println("\t2.exit");
            System.out.print("nhap lua chon: ");
            value = sc.nextInt();
            if (value == 1) {
               dictCommandline.dictionaryBasic();
            } else {
                break;
            }
        }
    }
}
