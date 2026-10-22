import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Map<Student, Integer> students = readInputFile("input.txt");

        if (students == null || students.isEmpty())
        {
            System.out.println("Nu s-au citit studenti din fisier!");
            return;
        }

        // Afisarea studentilor și a numărului lor de apariții
        for (Map.Entry<Student, Integer> entry : students.entrySet()) {
            System.out.println(entry.getKey() + " -> Apare de " + entry.getValue() + " ori");
        }
    }

    static Map<Student, Integer> readInputFile(String name) {
        Map<Student, Integer> students = new HashMap<>();
        BufferedReader buffReader = null;

        try {
            File file = new File(name);

            if (!file.exists())
            {
                System.out.println("Fisierul nu a fost gasit!" + file.getAbsolutePath());
                return students;
            }

            buffReader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = buffReader.readLine()) != null)
            {
                line = line.trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split("\\s+");
                if (parts.length < 4) {
                    System.out.println("Linie invalida: " + line);
                    continue;
                }

                String nume = parts[0];
                String prenume = parts[1];
                String grupa = parts[2];

                List<Integer> note = new ArrayList<>();
                for (int i = 3; i < parts.length; i++) {
                    try {
                        note.add(Integer.parseInt(parts[i]));
                    } catch (NumberFormatException e) {
                        System.out.println("Nota invalida la linia: " + line);
                    }
                }

                Student student = new Student(nume, prenume, grupa, note);
                students.put(student, students.getOrDefault(student, 0) + 1);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        } finally {
            if (buffReader != null) {
                try {
                    buffReader.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
        return students;
    }
}
