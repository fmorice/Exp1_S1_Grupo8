package com.mycompany.miproyectojava;

import java.util.Scanner;

/**
 *
 * @author Flore, Cata
 */

public class MiProyectoJava {
    public static void main(String[] args) {
        
        // para que muestre las tildes
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            System.err.println("No se pudo establecer UTF-8 en la salida.");
        }
        
        Scanner scanner = new Scanner(System.in);
        Cliente cliente = null;
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Ver datos de cliente");
            System.out.println("3. Depositar");
            System.out.println("4. Girar");
            System.out.println("5. Consultar saldo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            if (opcion == 1) {
                System.out.print("Ingrese Rut: ");
                String rut = scanner.nextLine();
                System.out.print("Ingrese nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese apellido paterno: ");
                String apPaterno = scanner.nextLine();
                System.out.print("Ingrese apellido materno: ");
                String apMaterno = scanner.nextLine();
                System.out.print("Ingrese domicilio: ");
                String domicilio = scanner.nextLine();
                System.out.print("Ingrese comuna: ");
                String comuna = scanner.nextLine();
                System.out.print("Ingrese teléfono: ");
                String telefono = scanner.nextLine();
                System.out.print("Ingrese número de cuenta corriente (9 dígitos): ");
                int nroCuenta = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer

                try {
                    CuentaCorriente cuenta = new CuentaCorriente(nroCuenta);
                    cliente = new Cliente(rut, nombre, apPaterno, apMaterno, domicilio, comuna, telefono, cuenta);
                    System.out.println("¡Cliente registrado exitosamente!");
                } catch (IllegalArgumentException e) {
                    System.out.println("Error al registrar cliente: " + e.getMessage());
                }

            } else if (opcion == 2) {
                if (cliente != null) {
                    cliente.verDatos();
                } else {
                    System.out.println("Primero debe registrar un cliente.");
                }

            } else if (opcion == 3) {
                if (cliente != null) {
                    System.out.print("Ingrese un monto para depositar: ");
                    int montoDeposito = scanner.nextInt();
                    scanner.nextLine();
                    cliente.getCuenta().depositar(montoDeposito);
                } else {
                    System.out.println("Primero debe registrar un cliente.");
                }

            } else if (opcion == 4) {
                if (cliente != null) {
                    System.out.print("Ingrese un monto para girar: ");
                    int montoGiro = scanner.nextInt();
                    scanner.nextLine();
                    cliente.getCuenta().girar(montoGiro);
                } else {
                    System.out.println("Primero debe registrar un cliente.");
                }

            } else if (opcion == 5) {
                if (cliente != null) {
                    cliente.getCuenta().consultarSaldo();
                } else {
                    System.out.println("Primero debe registrar un cliente.");
                }

            } else if (opcion == 6) {
                salir = true;
                System.out.println("¡Gracias por usar Bank Boston!");

            } else {
                System.out.println("Opción no válida. Intente nuevamente.");
            }
        }

        scanner.close();
    }
}
