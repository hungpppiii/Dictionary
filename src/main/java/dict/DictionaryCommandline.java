package dict;

import java.util.Scanner;

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

    public void dictionaryBasic() {  
        String value; 
        while (true) {    
            System.out.println("\t1.nhap tu moi");
            System.out.println("\t2.danh sach cac tu//\n\t4.del\n\t5.repair\n\t6.add");
            System.out.println("\t3.exit");
            System.out.print("nhap lua chon: ");
            value = sc.nextLine();
            if (value.equals("1")) {
                dictManagement.insertFromCommandline();
            } else if (value.equals("2")) {
                showAllWord();
            } else if (value.equals("3")) {
                break;
            } 
            else if (value.equals("4")) {
                dictManagement.deleteData();
            } else if (value.equals("5")) {
                dictManagement.repairData();
            } else if (value.equals("6")) {
                dictManagement.addData();
            } else if (value.equals("7")) {
                dictManagement.dictionaryExportToFile();
            } 
            else {
                System.out.println("!!! nhap sai lua chon !!!");
            }
        }
    }

    public void dictionarySearcher() {
        System.out.print("nhap tu: ");
        String word = sc.nextLine();
        dictManagement.findWord(word);
    }

}
