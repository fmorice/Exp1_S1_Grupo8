/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.miproyectojava;

/**
 *
 * @author Flore, Cata
 */
public class CuentaCorriente {
    private final int numeroCuenta;
    private int saldo;

    public CuentaCorriente(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void depositar(int monto) {
        if (monto <= 0) {
            System.out.println("El monto debe ser mayor a 0.");
        } else {
            saldo += monto;
            System.out.println("¡Depósito realizado de manera exitosa!");
            System.out.println("Usted tiene un saldo actual de " + saldo + " pesos.");
        }
    }

    public void girar(int monto) {
        if (monto <= 0) {
            System.out.println("El monto debe ser mayor a 0.");
        } else if (monto > saldo) {
            System.out.println("No puede girar más de lo que tiene en el saldo.");
        } else {
            saldo -= monto;
            System.out.println("¡Giro realizado de manera exitosa!");
            System.out.println("Usted tiene un saldo actual de " + saldo + " pesos.");
        }
    }

    public void consultarSaldo() {
        System.out.println("Saldo actual: " + saldo + " pesos");
    }
}

