import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String text = "Acesta este un program scris cu java 8 si expresii lambda";
        List<String> words = Arrays.asList(text.split(" "));

        // a) Cuvinte lungimea >= 5
        List<String> longWords = words.stream()
                .filter(w -> w.length() >= 5)
                .collect(Collectors.toList());

        System.out.println("Cuvinte cu lungimea >= 5: " + longWords);
        System.out.println("Numar cuvinte >= 5 caractere: " + longWords.size());

        // b) Ordonam lista
        List<String> sortedLongWords = longWords.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Cuvinte ordonate: " + sortedLongWords);

        // c) element care icepe cu 'p'
        Optional<String> startsWithP = words.stream()
                .filter(w -> w.startsWith("p"))
                .findFirst();

        startsWithP.ifPresent(s -> System.out.println("Primul cuvant care incepe cu 'p': " + s));
    }
}
