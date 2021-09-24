package Dict;

public class DictionaryCommandline {
    public void showAllWord() {
            Dictionary dict = new Dictionary();
            for (int i=0; i<dict.wordss.size(); i++) {
                System.out.println(dict.wordss.get(i).getWord_target() + "     " + dict.wordss.get(i).getWord_explain());
            }
    }

    public void dictionaryBasic() {
        DictionaryCommandline dict = new DictionaryCommandline();
        DictionaryManagerment dictm = new DictionaryManagerment();
        dictm.insertFromCommandline();
        dict.showAllWord();
    }

}
