import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DoubleCalculatorTest {

    @Test
    public void testAddPositive() {
        // Arrange
        DoubleCalculator calc = new DoubleCalculator(5.0);

        // Act
        calc.add(2.5);

        // Assert
        assertEquals(7.5, calc.result());
    }

    @Test
    public void testAddNegatives() {
        // Arrange
        DoubleCalculator calc = new DoubleCalculator(5.0);

        // Act
        calc.add(-3.2);

        // Assert
        assertEquals(1.8, calc.result(), 0.0001);
    }

    @Test
    public void testSubtractPositives() {
        // Arrange
        DoubleCalculator calc = new DoubleCalculator(10.0);

        // Act
        calc.subtract(2.5);

        // Assert
        assertEquals(7.5, calc.result());
    }

    @Test
    public void testSubtractNegatives() {
        // Arrange
        DoubleCalculator calc = new DoubleCalculator(10.0);

        // Act
        calc.subtract(-4.0);

        // Assert
        assertEquals(14.0, calc.result());
    }

    @Test
    public void testMultiplyPositives() {
        // Arrange
        DoubleCalculator calc = new DoubleCalculator(2.0);

        // Act
        calc.multiply(3.5);

        // Assert
        assertEquals(7.0, calc.result());
    }

    @Test
    public void testMultiplyNegatives() {
        // Arrange
        DoubleCalculator calc = new DoubleCalculator(2.0);

        // Act
        calc.multiply(-1.5);

        // Assert
        assertEquals(-3.0, calc.result());
    }

    @Test
    public void testMultiplyBy0() {
        // Arrange
        DoubleCalculator calc = new DoubleCalculator(5.0);

        // Act
        calc.multiply(0.0);

        // Assert
        assertEquals(0.0, calc.result());
    }
}
