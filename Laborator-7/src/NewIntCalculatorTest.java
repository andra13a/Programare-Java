import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NewIntCalculatorTest {

    @Test
    public void testAddPositive() {
        // Arrange
        NewIntCalculator calc = new NewIntCalculator(5);

        // Act
        calc.add(4);

        // Assert
        assertEquals(9, calc.result());
    }

    @Test
    public void testAddNegatives() {
        // Arrange
        NewIntCalculator calc = new NewIntCalculator(5);

        // Act
        calc.add(-2);

        // Assert
        assertEquals(3, calc.result());
    }

    @Test
    public void testSubtractPositives() {
        // Arrange
        NewIntCalculator calc = new NewIntCalculator(10);

        // Act
        calc.subtract(3);

        // Assert
        assertEquals(7, calc.result());
    }

    @Test
    public void testSubtractNegatives() {
        // Arrange
        NewIntCalculator calc = new NewIntCalculator(10);

        // Act
        calc.subtract(-3);

        // Assert
        assertEquals(13, calc.result());
    }

    @Test
    public void testMultiplyPositives() {
        // Arrange
        NewIntCalculator calc = new NewIntCalculator(3);

        // Act
        calc.multiply(4);

        // Assert
        assertEquals(12, calc.result());
    }

    @Test
    public void testMultiplyNegatives() {
        // Arrange
        NewIntCalculator calc = new NewIntCalculator(3);

        // Act
        calc.multiply(-3);

        // Assert
        assertEquals(-9, calc.result());
    }

    @Test
    public void testMultiplyBy0() {
        // Arrange
        NewIntCalculator calc = new NewIntCalculator(3);

        // Act
        calc.multiply(0);

        // Assert
        assertEquals(0, calc.result());
    }

    @Test
    public void testDivideByZeroThrowsException() {
        NewIntCalculator calc = new NewIntCalculator(10);
        assertThrows(ArithmeticException.class, () -> calc.divide(0));
    }

    @Test
    public void testMultiplyByZeroDoesNotThrow() {
        NewIntCalculator calc = new NewIntCalculator(10);
        assertDoesNotThrow(() -> calc.multiply(0));
    }
}
