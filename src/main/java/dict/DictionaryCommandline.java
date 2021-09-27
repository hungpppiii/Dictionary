package dict;

import java.io.File;
import java.io.*;
import java.util.*;

public class DictionaryCommandline {

    //private Dictionary dict = new Dictionary();
    private DictionaryManagement dictManagement = new DictionaryManagement();
    private Scanner sc = new Scanner(System.in);
    /**
     * Show all word.
     */
    public void showAllWord() {
        System.out.println("NO\t\tEnglish\t\tVietnamese");
        int count = 1;
        for (Word i:Dictionary.words) {
            System.out.print((count++) + "\t\t" + i.getWordTarget());
            System.out.println("\t\t" + i.getWordExplain());
        }
    }

    public void dictionaryBasic() throws FileNotFoundException {
        int value;
        dictManagement.insertFromFile();
        while (true) {    
            System.out.println("\t1.nhap tu moi");
            System.out.println("\t2.danh sach cac tu");
            System.out.println("\t3.exit");
            System.out.print("nhap lua chon: ");
            value = sc.nextInt();
            if (value == 1) {
            dictManagement.insertFromCommandline();
            } else if (value == 2) {
                showAllWord();
            } else {
                break;
            }
        }
    }

}
