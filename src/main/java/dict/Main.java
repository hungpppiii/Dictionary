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
        while (true) {
            System.out.println("\t1.vao dictionary");
            System.out.println("\t2.exit");
            System.out.print("nhap lua chon: ");
            value = sc.nextLine();
            if (value.equals("1")) {
                dictCommandline.dictionaryBasic();
            } else if (value.equals("2")) {
                break;
            }
        }
    }
}
