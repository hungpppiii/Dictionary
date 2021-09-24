package Dict;

import java.util.Scanner;

public class DictionaryManagement {
        public void insertFromCommandline() {
               Scanner sc = new Scanner(System.in);
               Word new_word = new Word();
               System.out.print("Nhap tu tieng anh : ");
               String eng = sc.nextLine();
               new_word.setWordTarget(eng);
               System.out.print("Them y nghia cua tu: ");
               String vn = sc.nextLine();
               new_word.setWordExplain(vn);
               Dictionary dict = new Dictionary();
               dict.words.add(new_word);
        }

}
