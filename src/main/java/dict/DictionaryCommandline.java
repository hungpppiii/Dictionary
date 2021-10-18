package dict;

import java.util.Scanner;

public class DictionaryCommandline {

    private DictionaryManagement dictManagement = new DictionaryManagement();
    private Scanner sc = new Scanner(System.in);
    VoiceManager voiceManager = new VoiceManager();

    /**
     * Show all word.
     */
    public void showAllWord() {
        System.out.println("NO\t\tEnglish\t\tVietnamese");
        int count = 1;
        for (Word i : Dictionary.words) {
            System.out.print((count++) + "\t\t" + i.getWordTarget());
            System.out.print("\t\t" + i.getWordType());
            System.out.println("\t\t" + i.getWordExplain());
        }
    }

    // menu thư viện
    public void dictionaryBasic() {
        String value;
        while (true) {
            System.out.println("\t1.nhập từ mới");
            System.out.println("\t2.danh sách các từ");
            System.out.println("\t3.delete");
            System.out.println("\t4.repair (sửa từ)");
            System.out.println("\t5.thêm từ");
            System.out.println("\t6.tìm từ tiếng anh");
            System.out.println("\t7.xuất danh sách ra file .txt");
            System.out.println("\t8.exit");
            dictManagement.insertFromFile();
            System.out.print("nhập lựa chọn: ");
            value = sc.nextLine();
            if (value.equals("1")) {
                dictManagement.insertFromCommandline();
            } else if (value.equals("2")) {
                showAllWord();
            } else if (value.equals("3")) {
                dictManagement.deleteData();
            } else if (value.equals("4")) {
                dictManagement.repairData();

            } else if (value.equals("5")) {
                dictManagement.addData();
            } else if (value.equals("6")) {
                dictionarySearcher();
            } else if (value.equals("7")) {
                dictManagement.dictionaryExportToFile();
            } else if (value.equals("8")) {
                break;
            } else {
                System.out.println("!!! nhập sai lựa chọn !!!");
            }
        }
    }

    // menu2
    public void dictionaryAdvanced() {
        String value;
        dictManagement.insertFromFile();
        while (true) {
            System.out.println("\t1. Thêm từ");
            System.out.println("\t2. Danh sách các từ");
            System.out.println("\t3. Tìm kiếm từ");
            System.out.println("\t4. Exit");
            System.out.print("Nhập lựa chọn: ");
            value = sc.nextLine();
            if (value.equals("1")) {
                dictManagement.insertFromCommandline();
            } else if (value.equals("2")) {
                showAllWord();
            } else if (value.equals("3")) {
                System.out.print("nhap tu can tim: ");
                String word = sc.nextLine();
                int index = dictManagement.dictionaryLookup(word);
                if (index>=0) {
                    System.out.println(index + "    "+Dictionary.words.get(index).getWordTarget()+" "+Dictionary.words.get(index).getWordType()+" "+Dictionary.words.get(index).getWordExplain());
                    VoiceManager.voice(Dictionary.words.get(index).getWordTarget());
                } else {
                    System.out.println("Khong tim thay tu");
                }
            } else if (value.equals("4")) {
                break;
            } else {
                System.out.println("!!! nhập sai lựa chọn !!!");

            }
        }
    }

    public void dictionarySearcher() {
        System.out.print("nhap tu: ");
        String word = sc.nextLine();
        dictManagement.findWord(word);
    }

}
