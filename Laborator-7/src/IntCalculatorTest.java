import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntCalculatorTest {

    @Test
    public void testAddPositive() {
        // Arrange
        IntCalculator calc = new IntCalculator(5);

        // Act
        calc.add(10);

        // Assert
        assertEquals(15, calc.result());
    }

    @Test
    public void testAddNegatives() {
        // Arrange
        IntCalculator calc = new IntCalculator(5);

        // Act
        calc.add(-3);

        // Assert
        assertEquals(2, calc.result());
    }

    @Test
    public void testSubtractPositives() {
        // Arrange
        IntCalculator calc = new IntCalculator(10);

        // Act
        calc.subtract(4);

        // Assert
        assertEquals(6, calc.result());
    }

    @Test
    public void testSubtractNegatives() {
        // Arrange
        IntCalculator calc = new IntCalculator(10);

        // Act
        calc.subtract(-5);

        // Assert
        assertEquals(15, calc.result());
    }

    @Test
    public void testMultiplyPositives() {
        // Arrange
        IntCalculator calc = new IntCalculator(3);

        // Act
        calc.multiply(4);

        // Assert
        assertEquals(12, calc.result());
    }

    @Test
    public void testMultiplyNegatives() {
        // Arrange
        IntCalculator calc = new IntCalculator(3);

        // Act
        calc.multiply(-2);

        // Assert
        assertEquals(-6, calc.result());
    }

    @Test
    public void testMultiplyBy0() {
        // Arrange
        IntCalculator calc = new IntCalculator(5);

        // Act
        calc.multiply(0);

        // Assert
        assertEquals(0, calc.result());
    }
    @Test
    public void testDivideByZeroThrowsException() {
        IntCalculator calc = new IntCalculator(10);
        assertThrows(ArithmeticException.class, () -> calc.divide(0));
    }

    @Test
    public void testMultiplyByZeroDoesNotThrow() {
        IntCalculator calc = new IntCalculator(10);
        assertDoesNotThrow(() -> calc.multiply(0));
    }
}
