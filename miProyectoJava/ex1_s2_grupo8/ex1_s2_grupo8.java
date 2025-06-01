package ex1_s2_grupo8;

import java.util.Scanner;

public class ex1_s2_grupo8 {
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
            switch (opcion) {
                case 1 -> {
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
                    
                    //Ahora que existen 3 tipos de cuentas, se le preguntara al cliente que tipo de cuenta querra abrir en el banco
                    System.out.println("Seleccione el tipo de cuenta a abrir:");
                    System.out.println("1. Cuenta Corriente");
                    System.out.println("2. Cuenta de Ahorro");
                    System.out.println("3. Cuenta de Credito");
                    System.out.print("Seleccione una opción: ");
                    int tipoCuenta = scanner.nextInt();
                    System.out.print("Ingrese número de cuenta (9 dígitos): ");
                    int nroCuenta = scanner.nextInt();
                    scanner.nextLine(); // limpiar buffer
                    
                    CuentaBancaria cuenta;
                    try {
                        switch (tipoCuenta){
                            case 1 -> cuenta = new CuentaCorriente(nroCuenta);
                            case 2 -> cuenta = new CuentaAhorro(nroCuenta);
                            case 3 -> cuenta = new CuentaCredito (nroCuenta);
                            default -> throw new IllegalArgumentException("Tipo de cuenta invalida");
                        }
                        cliente = new Cliente (rut, nombre, apPaterno, apMaterno, domicilio, comuna, telefono, cuenta);
                        System.out.println("Cliente registrado exitosamente!");
                    }catch (IllegalArgumentException e){
                        System.out.println("Error: "+ e.getMessage());
                    }
                }
                case 2 -> {
                    if (cliente != null) {
                        cliente.mostrarInformacion();
                    } else {
                        System.out.println("Primero debe registrar un cliente.");
                    }
                }
                case 3 -> {
                    if (cliente != null) {
                        System.out.print("Ingrese un monto para depositar: ");
                        int montoDeposito = scanner.nextInt();
                        scanner.nextLine();
                        cliente.getCuenta().depositar(montoDeposito);
                    } else {
                        System.out.println("Primero debe registrar un cliente.");
                    }
                }
                case 4 -> {
                    if (cliente != null) {
                        System.out.print("Ingrese un monto para girar: ");
                        int montoGiro = scanner.nextInt();
                        scanner.nextLine();
                        cliente.getCuenta().girar(montoGiro);
                    } else {
                        System.out.println("Primero debe registrar un cliente.");
                    }
                }
                case 5 -> {
                    if (cliente != null) {
                        cliente.getCuenta().consultarSaldo();
                    } else {
                        System.out.println("Primero debe registrar un cliente.");
                    }
                }
                case 6 -> {
                    salir = true;
                    System.out.println("¡Gracias por usar Bank Boston!");
                }
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        }

        scanner.close();
    }
}
