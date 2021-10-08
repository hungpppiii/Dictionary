package dict;

import java.io.*;
import java.util.*;

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
        
        // tìm kiếm từ
        public int dictionaryLookup(String word) {
               for (int i=0; i<Dictionary.words.size(); i++) {
                       if (Dictionary.words.get(i).getWordTarget() == word) {
                               return i;
                       }
               }
               return 0         ;
        }
        
        // thêm dữ liệu (thêm từ mới hoặc thêm nghĩa từ "chèn sau nghĩa cũ")
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

        //xóa dữ liệu (xóa từ)
        public void deleteData() {
                System.out.print("nhap tu tieng anh can xoa: ");
                String del_word = sc.nextLine();
                int index = dictionaryLookup(del_word);
                if(index != -1) {
                        Dictionary.words.remove(index);
                }
        }

        //sửa nghĩa và sửa từ
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

        //tìm từ dựa trên những chữ cái bắt đầu
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

        //xuất danh sách từ điển ra file dictionary.txt
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

        //ghi từ điển từ file
        public void insertFromFile() {
           try {
               FileReader fr = new FileReader(linkFile);
               BufferedReader br = new BufferedReader(fr);
               String line  = "";
               while(true) {
                   line = br.readLine();
                   if (line == null) {
                       break;
                   }
                   String txt[] = line.split("\t");
                   String eng = txt[0];
                   String vn = txt[1];
                   Word Wordss = new Word();
                   Wordss.setWordTarget(eng);
                   Wordss.setWordExplain(vn);
                   Dictionary.words.add(Wordss);
               }
           } catch(IOException e){
           }
        }

        public int SeachVieNam() {
                Scanner sc = new Scanner(System.in);
                String word = sc.nextLine();
                boolean check = false;
                int index = 0;
                for (int i=0; i < Dictionary.words.size(); i++) {
                        if (word.equals(Dictionary.words.get(i).getWordExplain())) {
                                index = i;
                                check = true;
                        }
                }
                if (check == false) {
                        return 0;
                } else {
                       return index;
                }
        }

}
