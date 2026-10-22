import java.util.ArrayList;
import java.util.List;

public class Student
{
    String nume;
    String grupa;
    List<Integer> note;

    public Student( String nume, String grupa)
    {
        this.nume = nume;
        this.grupa = grupa;
        this.note = new ArrayList<Integer>();
    }

    public String getNume()
    {
        return nume;
    }

    public String getGrupa()
    {
        return grupa;
    }

    public void adaugaNota(int nota)
    {
        note.add(nota);
    }

    public boolean esteIntegralist()
    {
        for(int nota : note)
        {
            if(nota < 5)
            {
                return false;
            }
        }
        return true;
    }

    public float getMedie()
    {
        int suma = 0;
        for(int nota : note)
        {
            suma += nota;
        }
        return (float) suma/note.size();
    }


    public List<Integer> getNote()
    {
        return note;
    }

    public String toString()
    {
        return String.format("%s (%s) - Note: %s", nume, grupa, note);
    }

}
