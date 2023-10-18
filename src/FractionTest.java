import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

    int [] test_numerators = {0, 1, 4, 7, 18, 9};
    int [] test_denominators = {1, 2, 7, 11, 2, 9};

    Fraction [] test_fractions;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        assert test_numerators.length == test_denominators.length;
        test_fractions = new Fraction [test_numerators.length];
        for (int i = 0; i < test_numerators.length; i++) {
            test_fractions[i] = new Fraction(test_numerators[i], test_denominators[i]);
        }
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        test_fractions = null;
    }

    @org.junit.jupiter.api.Test
    void getNumerator() {
    }

    @org.junit.jupiter.api.Test
    void getDenominator() {
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
    }

    @org.junit.jupiter.api.Test
    void testHashCode() {
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        for (int i = 0; i < test_fractions.length; i++) {
            System.out.println("test_fractions[" + i + "] -> " + test_fractions[i]);
        }
    }
}