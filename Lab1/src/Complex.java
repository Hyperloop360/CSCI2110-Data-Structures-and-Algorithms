/**
 * Antony Punnassery
 * B01012905
 */
public class Complex {
    private double real;
    private double imag;
    private static final double EPSILON = 1e-8;

    // Constructor with given real and imaginary parts
    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    // Default constructor (0.0 + 0.0i)
    public Complex() {
        this(0.0, 0.0);
    }

    // Getter and setter methods
    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    // toString method
    @Override
    public String toString() {
        return "(" + real + " + " + imag + "i)";
    }

    // Check if the complex number is real (imaginary part is 0)
    public boolean isReal() {
        return Math.abs(imag - 0.0) <= EPSILON;
    }

    // Check if the complex number is imaginary (real part is 0)
    public boolean isImaginary() {
        return Math.abs(real - 0.0) <= EPSILON;
    }

    // Check if two complex numbers are equal
    public boolean equals(Complex other) {
        if (other == null) return false;
        return Math.abs(this.real - other.real) <= EPSILON &&
                Math.abs(this.imag - other.imag) <= EPSILON;
    }

    // Calculate magnitude of the complex number
    public double magnitude() {
        return Math.sqrt(real * real + imag * imag);
    }

    // Add two complex numbers
    public Complex add(Complex other) {
        return new Complex(this.real + other.real, this.imag + other.imag);
    }

    // Subtract two complex numbers
    public Complex sub(Complex other) {
        return new Complex(this.real - other.real, this.imag - other.imag);
    }

    // Multiply two complex numbers
    public Complex multiply(Complex other) {
        double resultReal = this.real * other.real - this.imag * other.imag;
        double resultImag = this.real * other.imag + this.imag * other.real;
        return new Complex(resultReal, resultImag);
    }
}
