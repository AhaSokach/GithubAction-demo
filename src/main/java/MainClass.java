
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Word> list1 = new ArrayList<>();
        int flag = 0;
        String[] newStr = new String[2];
        char[] punctuation = new char[]{',','.','!','?'};
        while (input.hasNext()) {
            newStr[flag] = input.next();
            String str = "";
            if (flag == 1) {
                newStr[0] = newStr[0].substring(0,newStr[0].length() - 1)
                        + newStr[1];
                if (newStr[1].endsWith("-")) {
                    flag = 1;
                } else {
                    flag = 0;
                    str = newStr[0];
                }
            } else {
                str = newStr[0];
                if (newStr[0].endsWith("-")) {
                    flag = 1;
                }
            }
            if (flag == 0) {
                int flag2 = 0;
                for (char k : punctuation) {
                    if (str.indexOf(k) != -1) {
                        list1.add(new Word(str.substring(0,
                                str.indexOf(k)), 1));
                        flag2 = 1;
                    }
                }
                if (flag2 == 0) {
                    list1.add(new Word(str,1));
                }
            }
        }
        Sentence sen = new Sentence(list1);
        sen.sortWord();
        sen.printSentence();

    }

}
