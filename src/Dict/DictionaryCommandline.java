package Dict;

public class DictionaryCommandline {
    public void showAllWord() {
            final Dictionary dict = new Dictionary();
        for (int i = 0; i < dict.words.size(); i++) {
            System.out.println(dict.words.get(i).getWordTarget() + "     " + dict.words.get(i).getWordExplain());
        }
    }

    public void dictionaryBasic() {
        final DictionaryCommandline dict = new DictionaryCommandline();
        final DictionaryManagement dictm = new DictionaryManagement();
        dictm.insertFromCommandline();
        dict.showAllWord();
    }

}
