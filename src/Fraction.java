import java.util.Objects;
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int top, int bottom) {
        if (top == 0 || bottom == 0) {
            numerator = 0;
            denominator = 1;
        }
        else if (top < 0 || bottom < 0) {
            int gcd = 0;
            if (bottom < 0 && top > 0) {
                int positiveBottom = bottom * -1;
                gcd = find_gcd(top, positiveBottom);
                top = top / gcd;
                bottom =  (-1 * (positiveBottom / gcd)); // makes bottom negative after simplifying
                numerator = top * -1;
                denominator = bottom * -1;
            }
            else if (top < 0 && bottom > 0){
                int positiveTop = top * -1;
                gcd = find_gcd(positiveTop, bottom);
                top = (-1 * (positiveTop / gcd));
                bottom = bottom / gcd;
                numerator = top;
                denominator = bottom;
            }
            else {
                int positiveTop = top * -1;
                int positiveBottom = bottom * -1;
                gcd = find_gcd(positiveTop, positiveBottom);
                numerator = positiveTop / gcd;
                denominator = positiveBottom / gcd;
            }
        }
        else {
            int gcd = find_gcd(top, bottom);
            numerator = top / gcd;
            denominator = bottom / gcd;
        }
    }

    private int find_gcd(int a, int b) {
        while (a != b) {
            if (a > b) {
                a -= b;
            }
            else if (b > a){
                b -= a;
            }
        }
        return a;
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
