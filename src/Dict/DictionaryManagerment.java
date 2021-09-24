package Dict;

import java.util.Scanner;

public class DictionaryManagerment {
        public void insertFromCommandline() {
               Scanner sc = new Scanner(System.in);
               Word new_word = new Word();
               System.out.print("Thêm từ  tiếng anh : ");
               String eng = sc.nextLine();
               new_word.setWord_target(eng);
               System.out.print("Thêm ý nghĩa của từ: ");
               String vn = sc.nextLine();
               new_word.setWord_explain(vn);
               Dictionary dict = new Dictionary();
               dict.wordss.add(new_word);
        }

}
