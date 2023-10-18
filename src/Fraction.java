import java.util.Objects;
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int top, int bottom) {
        numerator = top;
        denominator = bottom;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;

        if(numerator != fraction.numerator) return false;
        return denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    public String toString() {
        String result = "" + numerator;
        if (denominator != 1) {
            result += "/" + denominator;
        }
        return result;
    }
}
