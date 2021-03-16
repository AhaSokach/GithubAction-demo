import org.junit.Assert;

import static org.junit.Assert.*;

public class WordTest {
    Word word = new Word("word",1);
    @org.junit.Test
    public void compareWord() {
        Word type = new Word("t",2);
        int ans = word.compareWord(type);
        Assert.assertEquals('w'-'t',ans);

    }
}