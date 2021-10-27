package javaapplication3;
import java.io.*;
import java.util.*;

public class DictionaryManagement {

        private Scanner sc = new Scanner(System.in);
        private final String linkFile = "src\\javaapplication3\\dictionary.txt";

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
                // add
                Collections.sort(Dictionary.words, new Comparator<Word>() {
                        @Override
                        public int compare(Word o1, Word o2) {
                                return o1.getWordTarget().compareTo(o2.getWordTarget());
                        }
                });
        }

        // tìm kiếm từ
        public int dictionaryLookup(String word) {
                int index = findWord(word);
                if (index != -1 && word.equals(Dictionary.words.get(index).getWordTarget())) {
                        return index;
                }
                return -1;

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
                        new_word_explain = Dictionary.words.get(index).getWordExplain() + ", " + new_word_explain;
                        Dictionary.words.get(index).setWordExplain(new_word_explain);
                } else if (value.equals("3")) {
                        return;
                } else {
                        System.out.println("!!! nhap sai lua chon !!!");
                }

        }

        // xóa dữ liệu (xóa từ)
        public void deleteData() {
                System.out.print("nhap tu tieng anh can xoa: ");
                String del_word = sc.nextLine();
                int index = dictionaryLookup(del_word);
                if (index > -1) {
                        Dictionary.words.remove(index);
                }
        }

        // sửa nghĩa và sửa từ
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

        // tìm từ dựa trên những chữ cái đầu tiên
        public int findWord(String word) {
                int wordLength = word.length();
                int size = Dictionary.words.size();
                int mid = size / 2, left = 0, right = size - 1;
                int value = 1;
                char kt = (char) (word.charAt(0) - 1);
                while (value != 0) {
                        value = kt - Dictionary.words.get(mid).getWordTarget().charAt(0);
                        if (value < 0) {
                                right = mid;
                                mid -= (mid - left) / 2;
                        } else if (value > 0) {
                                left = mid;
                                mid += (right - mid) / 2;
                        }
                }
                int i = mid;
                //ArrayList<Integer> listResult = new ArrayList<Integer>();
                kt = word.charAt(0);
                while (i < size && Dictionary.words.get(i).getWordTarget().charAt(0) <= kt) {
                        if (Dictionary.words.get(i).getWordTarget().length() >= wordLength) {
                                if (word.equals(Dictionary.words.get(i).getWordTarget().substring(0, word.length()))) {
                                        //listResult.add(i);
                                        return i;
                                }
                        }
                        i++;
                }
                // if (listResult.size() <= 0) {
                //         System.out.println("khong co tu nao !!!");
                // } else {
                //         for (int index : listResult) {
                //                 System.out.println(Dictionary.words.get(index).getWordTarget());
                //         }
                // }
                return -1;
        }

        // xuất danh sách từ điển ra file dictionaries.txt
        public void dictionaryExportToFile() {
                BufferedWriter bufferWriter = null;

                try {
                        FileWriter fileWriter = new FileWriter(linkFile);
                        bufferWriter = new BufferedWriter(fileWriter);
                        for (Word i : Dictionary.words) {
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
                                        e.printStackTrace();
                                }
                        }
                }
        }

        // lấy danh sách từ điển từ file dictionaries.txt
        public void insertFromFile() {
                BufferedReader br = null;
                try {
                        FileReader fr = new FileReader(linkFile);
                        br = new BufferedReader(fr);
                        String line = "";
                        while (true) {
                                line = br.readLine();
                                if (line == null) {
                                        break;
                                }
                                String txt[] = line.split("\t");
                                Dictionary.words.add(new Word(txt[0], txt[1]));
                        }
                } catch (IOException e) {
                } finally {
                        if (br != null) {
                                try {
                                        br.close();

                                } catch (IOException e) {
                                }
                        }
                }
        }

}
