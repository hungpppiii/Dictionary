package dict;

import java.io.*;
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
        public void insertFromFile() {
           try {
               FileReader fr = new FileReader(linkfile);
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

        public int dictionaryLookup() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhap tu tim kiem: ");
            boolean ss = false;
            String find = sc.nextLine();
            for (int i=0; i<Dictionary.words.size(); i++) {
                if (Dictionary.words.get(i).getWordTarget().equals(find)) {
                    return i;
                }
            }
            return -1;
        }



}
