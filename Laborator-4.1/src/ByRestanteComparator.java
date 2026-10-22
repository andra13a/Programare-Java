import java.util.Comparator;

public class ByRestanteComparator implements Comparator<Student>
{
    public int compare(Student o1, Student o2)
    {
        int restante1 = o1.note.stream().filter(n -> n < 5).toArray().length;
        int restante2 = o2.note.stream().filter(n -> n < 5).toArray().length;

        return Integer.compare(restante1, restante2);
    }
}
