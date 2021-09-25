package dict;

public class Word {
     private String word_target;
     private String word_explain;

     Word() {}

     Word(String word_target, String word_explain) {
          this.word_target = word_target;
          this.word_explain = word_explain;
     }

     public String getWordTarget() {
          return this.word_target;
     }

     public String getWordExplain() {
          return this.word_explain;
     }

     public void setWordTarget(String word_target) { 
          this.word_target = word_target; 
     }
     
     public void setWordExplain(String word_explain) { 
          this.word_explain = word_explain; 
     }
}
