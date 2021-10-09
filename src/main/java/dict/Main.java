package dict;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        //test translate
        Translate trans = new Translate();
        System.out.println(trans.translate("If I pass a string (either in English or Arabic) as an input"));
        //
        DictionaryCommandline dictCommandline = new DictionaryCommandline();
        Scanner sc = new Scanner(System.in);
        String value;
        while(true) {
            System.out.println("\t1.vao dictionaryBasic");
            System.out.println("\t2.vao dictionaryAdvanced");
            System.out.println("\t3.exit");
            System.out.print("nhap lua chon: ");
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
