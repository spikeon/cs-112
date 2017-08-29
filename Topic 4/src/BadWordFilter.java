import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BadWordFilter extends Filter {

    private List<String> bad_words;

    public BadWordFilter(String str){
        super(str);
    }

    private String getStars(int length) {
        String r = "";
        for(int i = 0; i < length; i++) r += "*";
        return r;
    }

    public String filter() {
        bad_words = new ArrayList<String>(Arrays.asList("fuck", "shit", "ass", "cunt"));

        String r = getOriginal();

        for(String word : bad_words) {
            r = r.replace(word, getStars(word.length()));
        }

        return r;
    }

}
