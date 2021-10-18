package dict;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        //test translate
        //
        DictionaryCommandline dictCommandline = new DictionaryCommandline();
        Scanner sc = new Scanner(System.in);
        String value;
        while(true) {
            System.out.println("\t1.vào dictionaryBasic");
            System.out.println("\t2.vào dictionaryAdvanced");
            System.out.println("\t3.exit");
            System.out.print("nhập lựa chọn: ");
            value = sc.nextLine();
            if (value.equals("1")) {
                dictCommandline.dictionaryBasic();
            } else if (value.equals("2")) {
                dictCommandline.dictionaryAdvanced();
            } else if (value.equals("3")) {
                break;
            }
        }
    }
}
