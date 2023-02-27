import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        String str = "The quick brown fox jumped over the lazy dog";
        System.out.println(str);
        System.out.println("В тексте " + countWords(str) + " слов");

        System.out.println("________________________________________________");

        String str2 = str.toLowerCase();
        String[] arr = str2.split(" ");

        Arrays.stream(arr)
                .collect(Collectors.toMap(s -> s, v -> 1, Integer::sum))
                .entrySet().stream()
                .sorted((o1, o2) -> {
                    int equal = (o2.getValue().compareTo(o1.getValue()));
                    if (equal == 0) {
                        equal = o1.getKey().compareTo(o2.getKey());
                    }
                    return equal;
                })
                .limit(10)
                .forEach(e ->  System.out.println(e.getValue() + " - " + e.getKey()) );
    }

    public static int countWords(String str) {
        int count = 0;
        str = str.trim();
        String[] words = str.split("\\s+");
        count = words.length;
        return count;
    }

}