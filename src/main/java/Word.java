
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word implements Comparable<Word> {
    private String str;
    private int num;
    private ArrayList<Character> type;

    public Word(String str,int num) {
        this.str = str;
        this.num = num;
        getType();

    }

    public int compareWord(Word word) {
        int minLength = Math.min(str.length(),word.str.length());
        for (int i = 0;i < minLength;i++) {
            if (str.charAt(i) != word.str.charAt(i)) {
                return str.charAt(i) - word.str.charAt(i);
            }
        }
        return str.length() - word.str.length();
    }

    public int compareTo(Word word) {
        int minLength = Math.min(str.length(),word.str.length());
        for (int i = 0;i < minLength;i++) {
            if (str.charAt(i) != word.str.charAt(i)) {
                if (str.charAt(i) - word.str.charAt(i) > 0) {
                    return 1;
                } else if (str.charAt(i) - word.str.charAt(i) < 0) {
                    return -1;
                }
            }
        }
        if (str.length() - word.str.length() > 0) {
            return 1;
        } else if (str.length() - word.str.length() < 0) {
            return -1;
        }
        return 0;
    }

    public void getType() {
        type = new ArrayList<Character>();
        Pattern pa = Pattern.compile("a{2,3}b{2,4}a{2,4}c{2,3}");
        Pattern pb = Pattern.compile("a{2,3}(ba){0,100000000}(bc){2,4}");
        Pattern pc = Pattern.compile("a{2,3}(ba){0,100000000}(bc){2,4}");
        Pattern pdl = Pattern.compile("^a{0,3}b{1,1000000}c{2,3}");
        Pattern pdr = Pattern.compile("b{1,2}a{1,2}c{0,3}$");
        Matcher ma = pa.matcher(str);
        Matcher mb = pb.matcher(str);
        Matcher mc = pc.matcher(str.toLowerCase());
        Matcher mdl = pdl.matcher(str);
        Matcher mdr = pdr.matcher(str.toLowerCase());
        if (ma.find()) {
            type.add('A');
        }
        if (mb.find()) {
            type.add('B');
            type.add('C');
        }  else if (mc.find()) {
            type.add('C');
        }
        if (mdl.find() && mdr.find()) {
            type.add('D');
        }
        Pattern pe = Pattern.compile("a([A-Za-z\\-]*b){2,10000}" +
                "([A-Za-z\\-]*c){1,2}" +
                "([A-Za-z\\-]*b){1,3}([A-Za-z\\-]*c){2,10000}");
        Matcher me = pe.matcher(str);
        if (me.find()) {
            type.add('E');
        }
    }

    public void printWord() {
        System.out.printf("%d",type.size());
        Iterator iterator = type.iterator();
        if (type.size() != 0) {
            System.out.print(" ");
        }
        while (iterator.hasNext()) {
            char ch = (char) iterator.next();
            System.out.print(ch);
        }
        System.out.print("\n");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Word word = (Word) o;
        return Objects.equals(str, word.str);
    }

    @Override
    public int hashCode() {
        return Objects.hash(str);
    }
}
