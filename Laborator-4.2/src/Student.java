import java.util.List;
import java.util.Objects;

public class Student
{
    private String nume;
    private String prenume;
    private String grupa;
    private List<Integer> note;

    public Student(String nume, String prenume, String grupa, List<Integer> note)
    {
        this.nume = nume;
        this.prenume = prenume;
        this.grupa = grupa;
        this.note = note;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return nume.equals(student.nume) &&
                prenume.equals(student.prenume) &&
                grupa.equals(student.grupa) &&
                note.equals(student.note);
    }

@Override
    public int hashCode()
    {
        return Objects.hash(nume, prenume, grupa, note);
    }

    public String toString()
    {
        return nume + " " + prenume + " " + grupa + " " + note;
    }
}
