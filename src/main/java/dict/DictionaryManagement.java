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
            while(scanner.hasNext()) {
                String stringWord = scanner.nextLine();
                Scanner s = new Scanner(stringWord).useDelimiter("s*\ts*");
                Word newword = new Word();
                newword.setWordTarget(s.next());
                newword.setWordExplain(s.next());
                Dictionary.words.add(newword);
            }
        }

}
