package Dict;

import java.util.Scanner;

public class DictionaryManagerment {
        public void insertFromCommandline() {
               Scanner sc = new Scanner(System.in);
               Word new_word = new Word();
               System.out.print("Thêm từ  tiếng anh : ");
               String eng = sc.nextLine();
               new_word.setWordTarget(eng);
               System.out.print("Thêm ý nghĩa của từ: ");
               String vn = sc.nextLine();
               new_word.setWordExplain(vn);
               Dictionary dict = new Dictionary();
               dict.words.add(new_word);
        }

}
