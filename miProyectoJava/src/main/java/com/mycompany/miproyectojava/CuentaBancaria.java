package com.mycompany.miproyectojava;

public abstract class CuentaBancaria {
    protected int numeroCuenta;
    protected int saldo;

    public CuentaBancaria(int numeroCuenta, int saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    public CuentaBancaria(int numeroCuenta) {
        this(numeroCuenta, 0); // Sobrecarga de constructor
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void depositar(int monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito exitoso. Saldo: " + saldo + " pesos.");
        } else {
            System.out.println("El monto debe ser mayor a 0.");
        }
    }

    public abstract void girar(int monto); // Método abstracto
}