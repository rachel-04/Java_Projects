/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe318.lab2;

public class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getReal() {
        return re;
    }

    public double getImaginary() {
        return im;
    }

    public ComplexNumber negate() {
        return new ComplexNumber(-re, -im);
    }

    public ComplexNumber add(ComplexNumber z) {
        return new ComplexNumber(this.re + z.re, this.im + z.im);
    }

    public ComplexNumber subtract(ComplexNumber z) {
        return this.add(z.negate());
    }

    public ComplexNumber multiply(ComplexNumber z) {
        double real = this.re * z.re - this.im * z.im;
        double imag = this.re * z.im + this.im * z.re;
        return new ComplexNumber(real, imag);
    }

    public ComplexNumber reciprocal() {
        double scale = re * re + im * im;
        return new ComplexNumber(re / scale, -im / scale);
    }

    public ComplexNumber divide(ComplexNumber z) {
        return this.multiply(z.reciprocal());
    }

    @Override
    public String toString() {
        String str = "" + this.getReal();
        if (this.getImaginary() == 0.0) {
            return str;
        }
        if (this.getImaginary() > 0) {
            return str + " + i" + this.getImaginary();
        } else {
            return str + " - i" + -this.getImaginary();
        }
    }
}
