import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

    int []   test_numerators = {0, 1, 4, 7, 18, 9, -1, 3, -9};
    int [] test_denominators = {1, 2, 7, 11, 2, 9, 10, -5, -3};

    int []   expected_numerators = {0, 1, 4, 7, 9, 1, -1, -3, 3};
    int [] expected_denominators = {1, 2, 7, 11, 1, 1, 10, 5, 1};

    Fraction [] test_fractions;

    private void DIANOGSTIC(String diagnostic) {
//        System.out.println("DIAGNOSTIC OUTPUT: \n" + diagnostic);
    }

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        DIANOGSTIC("Top of setup method");
        assert test_numerators.length == test_denominators.length;
        test_fractions = new Fraction [test_numerators.length];
        for (int i = 0; i < test_numerators.length; i++) {
            DIANOGSTIC("top of loop in setup method");
            test_fractions[i] = new Fraction(test_numerators[i], test_denominators[i]);
        }
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        test_fractions = null;
    }

    @org.junit.jupiter.api.Test
    void getNumerator() {
        assert expected_numerators.length == test_fractions.length;
        for (int i = 0; i < test_fractions.length; i++) {
            Fraction f = test_fractions[i];
            int expected_numerator = expected_numerators[i];
            int actual_numerator = f.getNumerator();
            assertEquals(expected_numerator, actual_numerator);
        }
    }

    @org.junit.jupiter.api.Test
    void getDenominator() {
        assert expected_denominators.length == test_fractions.length;
        int [] actual_denominators = new int [test_fractions.length];
        for (int i = 0; i < test_fractions.length; i++) {
            actual_denominators[i] = test_fractions[i].getDenominator();
        }
        assertArrayEquals(expected_denominators, actual_denominators);
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
        for (int i = 0; i < test_fractions.length; i++) {
            Fraction f = test_fractions[i];
            Fraction f_equiv = f;
            assertEquals(f, f_equiv);
            assertNotEquals(f, null);
            assertNotEquals(f, "not a fraction");

            Fraction equals_f = new Fraction(test_numerators[i], test_denominators[i]);
            assertNotSame(f, equals_f); // if (f != equals_f)
            assertEquals(f, equals_f);

            Fraction not_equals_f = new Fraction(1 + test_numerators[i], test_denominators[i]);
            assertNotEquals(f, not_equals_f);
        }
    }

    @org.junit.jupiter.api.Test
    void testHashCode() {
        for (int i = 0; i < test_fractions.length; i++) {
            Fraction f = test_fractions[i];
            Fraction equals_f = new Fraction(test_numerators[i], test_denominators[i]);
            assertNotSame(f, equals_f);
            assertEquals(f, equals_f);
            Fraction not_equals_f = new Fraction (test_numerators[1] + 1, test_denominators[i]);
            assertNotEquals(f, not_equals_f);
        }
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        for (int i = 0; i < test_fractions.length; i++) {
            System.out.println("test_fractions[" + i + "] -> " + test_fractions[i]);
        }
    }

    @Test
    void getAsDouble() {
        double [] expected_doubles = new double [test_fractions.length];
        for (int i = 0; i < test_fractions.length; i++) {
            double expected_double = 1.0 * test_numerators[i] / test_denominators[i];
            double  actual_double = test_fractions[i].getAsDouble();
            assertEquals(expected_double, actual_double);
        }
    }
}