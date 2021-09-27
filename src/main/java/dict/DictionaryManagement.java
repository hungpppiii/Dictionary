package dict;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DictionaryManagement {

        //private DictionaryManagement dictonaryManagement = new DictionaryManagement();
        private Scanner sc = new Scanner(System.in);
        private final String linkFile = "dictionaries.txt";
        /**
         * add word from commnadline.
         */
        public void insertFromCommandline() {           
                Word new_word = new Word();
                
                System.out.print("Them tu tieng anh : ");
                String eng = sc.nextLine();
                new_word.setWordTarget(eng);

                System.out.print("Them y nghia cua tu: ");
               String vn = sc.nextLine();
               new_word.setWordExplain(vn);

               Dictionary.words.add(new_word);
        }
        
        public int dictionaryLookup(String word) {
                for (int i = 0; i < Dictionary.words.size(); i++) {
                        if(Dictionary.words.get(i).getWordTarget().equals(word)) {
                                return i;
                        }
                }
                return -1;
        }
        
        public void addData() {
                System.out.println("\t\t1.them tu moi: ");
                System.out.println("\t\t2.them nghia moi cua tu cu: ");
                System.out.println("\t\t3.exit: ");
                System.out.print("nhap lua chon: ");
                String value = sc.nextLine();
                if (value.equals("1")) {
                        insertFromCommandline();
                } else if (value.equals("2")) {
                        System.out.print("nhap tu tieng anh can them nghia: ");
                        String word = sc.nextLine();
                        int index = dictionaryLookup(word);
                        System.out.print("nhap nghia moi: ");
                        String new_word_explain = sc.nextLine();
                        new_word_explain = Dictionary.words.get(index).getWordExplain() + ", "+ new_word_explain;
                        Dictionary.words.get(index).setWordExplain(new_word_explain);
                } else if (value.equals("3")) {
                        return;
                } else {
                        System.out.println("!!! nhap sai lua chon !!!");
                }

        }

        public void deleteData() {
                System.out.print("nhap tu tieng anh can xoa: ");
                String del_word = sc.nextLine();
                int index = dictionaryLookup(del_word);
                if(index != -1) {
                        Dictionary.words.remove(index);
                }
        }

        public void repairData() {
                System.out.print("nhap tu tieng anh can sua: ");
                String repair_word = sc.nextLine();
                int index = dictionaryLookup(repair_word);
                System.out.print("sua tu " + repair_word + " thanh tu: ");
                String word_target = sc.nextLine();
                System.out.print("sua nghia cua tu " + word_target + " thanh: ");
                String word_explain = sc.nextLine();
                Dictionary.words.get(index).setWordTarget(word_target);
                Dictionary.words.get(index).setWordExplain(word_explain);
        }

        public void findWord(String word) {
                System.out.println("tu can tim: ");
                boolean check = true;
                for (Word i:Dictionary.words) {
                        if(i.getWordTarget().length() >= word.length()) {
                                if(word.equals(i.getWordTarget().substring(0, word.length()))) {
                                        check = false;
                                        System.out.println(i.getWordTarget());
                                }
                        }
                }
                if (check) {
                        System.out.println("khong co tu nao !!!");
                }
        }

        public void dictionaryExportToFile() {
                BufferedWriter bufferWriter = null;
                
                try {
                        FileWriter fileWriter = new FileWriter(linkFile);
                        bufferWriter = new BufferedWriter(fileWriter);
                        for(Word i:Dictionary.words) {
                                bufferWriter.write(i.getWordTarget());
                                bufferWriter.write("\t");
                                bufferWriter.write(i.getWordExplain());
                                bufferWriter.write("\n");
                        }
                } catch (IOException e) {
                        e.printStackTrace();
                } finally {
                        if (bufferWriter != null) {
                                try {
                                        bufferWriter.close();
                                } catch (IOException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                }
                        }
                }
        }
}
