public class Main
{
    public static void main(String[] args)
    {
        IntCalculator calculator = new IntCalculator(10);
        int result = calculator.add(5).subtract(3).multiply(2).result();
        System.out.println("a) " + result);

        DoubleCalculator doubleCalculator = new DoubleCalculator(10.0);
        double doubleResult = doubleCalculator.add(5).subtract(3.3).multiply(2.2).result();
        System.out.println("Double Result: " + doubleResult);
    }
}
