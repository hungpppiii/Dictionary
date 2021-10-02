package dict;

import java.util.Scanner;

public class DictionaryCommandline {

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

    //menu thư viện
    public void dictionaryBasic() {  
        String value; 
        while (true) {    
            System.out.println("\t1.nhap tu moi");
            System.out.println("\t2.danh sach cac tu\n\t4.del\n\t5.repair\n\t6.add");
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

    //menu2
    public void dictionaryAdvanced() {
        String value;
        Scanner sc = new Scanner(System.in);
        DictionaryManagement dictManagement = new DictionaryManagement();
        dictManagement.insertFromFile();
        DictionaryCommandline dict = new DictionaryCommandline();
        while(true) {
            System.out.println("1. Them tu");
            System.out.println("2. Danh sach cac tu");
            System.out.println("3. Tim kiem tu");
            System.out.println("4. exit");
            System.out.print("5. Nhap lua chon: ");
            value = sc.nextLine();
            if (value.equals("1")) {
                dictManagement.insertFromCommandline();
            }
            else if (value.equals("2")) {
               showAllWord();
            } else if (value.equals("3")) {
                System.out.println("nhap tu can tim: ");
                String word = sc.nextLine();
                int index = dictManagement.dictionaryLookup(word);
                System.out.println(index + 1 + "  " + Dictionary.words.get(index).getWordTarget()+ "    " + Dictionary.words.get(index).getWordExplain());
                if (index<0) {
                    System.out.println("Khong tim thay tu nao!");
                }
            }
            else {
                break;
            }
        }
    }

    public void dictionarySearcher() {
        System.out.print("nhap tu: ");
        String word = sc.nextLine();
        dictManagement.findWord(word);
    }

}
