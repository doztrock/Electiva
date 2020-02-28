package modelo;

public class Calculadora {

    private double A;
    private double B;
    private double C;

    public Calculadora() {
    }

    public double getA() {
        return A;
    }

    public void setA(double A) {
        this.A = A;
    }

    public double getB() {
        return B;
    }

    public void setB(double B) {
        this.B = B;
    }

    public double getC() {
        return C;
    }

    public void setC(double C) {
        this.C = C;
    }

    public double calcularDiscriminante() {
        return (Math.pow(this.getB(), 2) - 4 * this.getA() * this.getC());
    }

    public String calcularPositivo() {

        double discriminante = calcularDiscriminante();

        if (discriminante < 0) {
            discriminante = Math.abs(discriminante);
            return "" + ((-this.getB() / (2 * this.getA()))) + " + " + (Math.sqrt(discriminante) / (2 * this.getA())) + "i";
        }

        return "" + (-this.getB() + Math.sqrt(discriminante)) / (2 * this.getA()) + "";
    }

    public String calcularNegativo() {

        double discriminante = calcularDiscriminante();

        if (discriminante < 0) {
            discriminante = Math.abs(discriminante);
            return "" + ((-this.getB() / (2 * this.getA()))) + " - " + (Math.sqrt(discriminante) / (2 * this.getA())) + "i";
        }

        return "" + (-this.getB() - Math.sqrt(discriminante)) / (2 * this.getA()) + "i";
    }
}
