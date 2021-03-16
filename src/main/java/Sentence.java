
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Sentence {
    private ArrayList<Word> list;

    public Sentence(ArrayList list) {
        this.list = list;
    }

    public void sortWord() {
        Collections.sort(list);
    }

    public void swapWord(int i,int j) {
        Word temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }

    public void printSentence() {
        int length = list.size();
        //ArrayList<Word> set = new ArrayList<>();
        for (int i = length - 1;i > 0;i--) {
            if (list.get(i).equals(list.get(i - 1))) {
                list.remove(i);
            }
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Word word = (Word) iterator.next();
            word.printWord();
        }
    }

}
