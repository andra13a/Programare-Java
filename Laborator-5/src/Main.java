import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args)
    {
        String inputFile = "in.txt";
        String outputFile = "out.txt";

        try {
            List<String> modifiedLines = processTextFile(inputFile);
            Files.write(Paths.get(outputFile), modifiedLines);
            System.out.println("\nFisierul a fost salvat in " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static List<String> processTextFile(String fileName) throws IOException {
        System.out.println("Using Files.readAllLines:");

        Path path = Paths.get(fileName);
        List<String> allLines = Files.readAllLines(path);

        // a. adaugam newline la sfarsitul fiecarei linii
        //b. adaugam newline dupa fiecare caracter "."
        List<String> modifiedLines = allLines.stream()
                .map(line -> line + "\n")
                .map(line -> line.replace(".", ".\n"))
                .collect(Collectors.toList());

        modifiedLines.forEach(System.out::print);
        return modifiedLines;
    }
}
