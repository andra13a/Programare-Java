import java.util.*;

public class Main
{
    public static void main(String[] args)
    {

        List<Student> studenti = new ArrayList<>();

        studenti.add(new Student("Andra Dutu", "211"));
        studenti.add(new Student("Nicoleta Stoica", "212"));
        studenti.add(new Student("Marius Popescu", "211"));
        studenti.add(new Student("Andrei Dutu", "212"));
        studenti.add(new Student("Eduard Nita", "211"));

        Random rand = new Random();
        for (Student student : studenti)
        {
            for (int i = 0; i < 5; i++)
            {
                student.adaugaNota(rand.nextInt(7) + 4);  // Note între 4 și 10
            }
        }

        List<Student> integralisti = new ArrayList<>();
        List<Student> restantieri = new ArrayList<>();

        for (Student student : studenti)
        {
            if (student.esteIntegralist())
            {
                integralisti.add(student);
            } else
            {
                restantieri.add(student);
            }
        }

        // b1
        System.out.println("Ordinea alfabetică pe grupe:");
        studenti.sort(Comparator.comparing(Student::getGrupa).thenComparing(Student::getNume));
        for (Student student : studenti)
        {
            System.out.println(student);
        }

        // b2
        System.out.println("\nOrdinea descrescatoare a mediilor pentru integralisti:");
        Collections.sort(integralisti, new ByGradesComparator());
        for (Student student : integralisti)
        {
            System.out.println(student + " - Medie: " + student.getMedie());
        }

        // b3
        System.out.println("\nOrdinea crescatoare a numarului de restante pentru restantieri:");
        Collections.sort(restantieri, new ByRestanteComparator());
        for (Student student : restantieri)
        {
            System.out.println(student + " - Restante: " +
                    student.note.stream().filter(n -> n < 5).count());
        }
    }
}
