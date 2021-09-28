package dict;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DictionaryManagement {
        //private static Dictionary dict = new Dictionary();

        /**
         * add word from commnadline.
         */
        public void insertFromCommandline() {
               Scanner sc = new Scanner(System.in);
               Word new_word = new Word();
               
               System.out.print("Them tu tieng anh : ");
               String eng = sc.nextLine();
               new_word.setWordTarget(eng);

               System.out.print("Them y nghia cua tu: ");
               String vn = sc.nextLine();
               new_word.setWordExplain(vn);

               Dictionary.words.add(new_word);
        }

        public final static String linkfile = "dictionaries.txt";
        public void insertFromFile() throws FileNotFoundException {
            File file = new File(linkfile);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()) { //check xem còn từ nào trong file chưa đọc không
                String nword = scanner.nextLine();
                Scanner s = new Scanner(nword);
                s.useDelimiter("s*\ts*");
                Word newword = new Word();
                newword.setWordTarget(s.next());
                newword.setWordExplain(s.next());
                Dictionary.words.add(newword);
            }
        }

        public void dictionaryLookup() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhap tu tim kiem: ");
            boolean ss = false;
            String find = sc.nextLine();
            for (Word i: Dictionary.words) {
                if(i.getWordTarget().equals(find)) {
                    System.out.println(i.getWordTarget()+"  "+i.getWordExplain());
                    ss = true;
                }
            }
            if (ss == false) {
                System.out.println("Khong tim thay");
            }
        }

        public void dictionaryAdvanced() throws FileNotFoundException {
            int value;
            Scanner sc = new Scanner(System.in);
            insertFromFile();
            DictionaryCommandline dict = new DictionaryCommandline();
            while(true) {
                System.out.println("1. Them tu");
                System.out.println("2. Danh sach cac tu");
                System.out.println("3. Tim kiem tu");
                System.out.println("4. exit");
                System.out.print("5. Nhap lua chon: ");
                value = sc.nextInt();
                if (value == 1) {
                    insertFromCommandline();
                }
                else if (value == 2) {
                    dict.showAllWord();
                }else if(value == 3){
                    dictionaryLookup();
                }
                else {
                    break;
                }
            }
        }


}
