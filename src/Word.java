public class Word {
    private String word_target;
    private String word_explain;
    String abc;

    /**
     * Constructor.
     * @param word_target
     * @param word_explain
     */
    Word(String word_target, String word_explain) {
        this.word_target = word_target;
        this.word_explain = word_explain;
    }

    /**
     * set word_target.
     * @param word_target
     */
    public void setWordTarget(String word_target) {
        this.word_target = word_target;
    }

    /**
     * get word_target.
     * @return
     */
    public String getWordTarget() {
        return this.word_target;
    }

    /**
     * set word_explain.
     * @param word_explain
     */
    public void setWordExplain(String word_explain) {
        this.word_explain = word_explain;
    }

    /**
     * get word_explain.
     * @return
     */
    public String getWordExplain() {
        return this.word_explain;
    }
}