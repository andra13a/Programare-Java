import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> lista = IntStream.range(0, 10)
                .map(i -> 5 + random.nextInt(21)) // 21 pentru [5,25]
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Lista originală: " + lista);

        // a) suma
        int suma = lista.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Suma: " + suma);

        // b) Max si min
        int max = lista.stream().max(Integer::compareTo).orElseThrow();
        int min = lista.stream().min(Integer::compareTo).orElseThrow();
        System.out.println("Maximul: " + max + ", Minimul: " + min);

        // c) elementele in intervalul [10..20].
        List<Integer> filtrate = lista.stream()
                .filter(x -> x >= 10 && x <= 20)
                .collect(Collectors.toList());
        System.out.println("Elemente între 10 și 20: " + filtrate);

        // d) transformare in double
        List<Double> listaDouble = lista.stream()
                .map(Integer::doubleValue)
                .collect(Collectors.toList());
        System.out.println("Listă Double: " + listaDouble);

        // e) verificare exista 12
        boolean contine12 = lista.contains(12);
        System.out.println("Conține 12? " + contine12);
    }
}
