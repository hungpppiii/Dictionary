package dict;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        DictionaryCommandline dictCommandline = new DictionaryCommandline();
        Scanner sc = new Scanner(System.in);
        String value;
        while(true) {
            System.out.println("\t1.vao dictionary");
            System.out.println("\t2.exit");
            System.out.print("nhap lua chon: ");
            value = sc.nextLine();
            if (value.equals("1")) {
               dictCommandline.dictionaryAdvanced();;
            } else {
                break;
            }
        }
    }
}
