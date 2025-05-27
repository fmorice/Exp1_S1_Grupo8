package ex1_s1_grupo8;
import java.util.Scanner;

public class Ex1_S1_Grupo8 {
    private static final RegistroCliente[] clientes = new RegistroCliente[1000];
    private static final OperacionesBancarias[] cuentas = new OperacionesBancarias[1000];
    private static int totalClientes = 0;
    private static int numCuentaCorriente = 100000000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("========= Menu =========");
            System.out.println("\nSelecciona la opcion que deseas realizar");
            System.out.println("\n1. Registrarse");
            System.out.println("2. Ver datos de cliente");
            System.out.println("3. Realizar deposito");
            System.out.println("4. Realizar giro");
            System.out.println("5. Consultar saldo");
            System.out.println("6. Salir");
            int opcionSel = opcionValida(scanner);

            switch (opcionSel){
                case 1 -> registrarCliente(scanner);
                case 2 -> verDatosCliente(scanner);
                case 3 -> realizarDeposito(scanner);
                case 4 -> realizarGiro(scanner);
                case 5 -> consultarSaldo(scanner);
                case 6 ->{
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;
                }
            }
        }
    }    
    private static int opcionValida(Scanner scanner){
        while (true){
            try{
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) continue;
                int opcion = Integer.parseInt(input);
                if(opcion>=1 && opcion<=6){
                    return opcion;
                }
                System.out.println("Ingresa una opcion valida (1-6)");
            }catch(NumberFormatException e){
                System.out.println("Opcion invalida, por favor ingresar un numero entero");
            }
        }
    }
    private static boolean validarLetras (String input){
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        return input.matches("[a-zA-ZñÑ\\s]+");
    }
    private static void registrarCliente(Scanner scanner) {
        if (totalClientes >= clientes.length) {
            System.out.println("No se pueden registrar mas clientes");
            return;
        }
        System.out.println("\nRegistrar Cliente");
        String rut = "";
        while(true){
            System.out.println("\nIngresa tu RUT (Formato XX.XXX.XXX-X)");
            rut = scanner.nextLine().trim();
            
            if (rut.matches("^\\d{1,2}\\.?\\d{3}\\.?\\d{3}\\-[\\dkK]$")) {
                if (rut.length()>=11 && rut.length()<=12) {
                    boolean rutExiste=false;
                    for (int i = 0; i < totalClientes; i++) {
                        if (clientes[i].getRut().equals(rut)){
                            rutExiste=true;
                            break;
                        }
                    }
                    if (!rutExiste) {
                        break;
                    }else{
                        System.out.println("RUT ya ha sido registrado");
                        return;
                    }
                }else{
                    System.out.println("El RUT debe contener entre 11 y 12 caracteres incluyendo puntos y guion");
                }
            }else{
                System.out.println("Formato de RUT invalido. Ingresalo en formato XX.XXX.XXX-X");
            }
        }   
        String nombre= "";
        while (true){
            System.out.println("Ingresa tu nombre");
            nombre = scanner.nextLine().trim();
            if (nombre.isEmpty()) {
                System.out.println("Este campo es obligatorio y no puede quedar vacio");
                continue;
            }
            boolean valido = true;
            for (char c : nombre.toCharArray()) {
                if(!Character.isLetter(c) && !Character.isWhitespace(c)){
                    valido = false;
                    break;
                }
            }
            if(valido){
                break;
            }else{
                System.out.println("Este campo es obligatorio y solo debe contener letras y/o espacios");
            }
        }    
        
        String apellidoPaterno = "";
        while(true){
            System.out.println("Ingresa tu apellido paterno");
            apellidoPaterno = scanner.nextLine().trim();
            
            if (apellidoPaterno.isEmpty()){
                System.out.println("Este campo es obligatorio y no puede quedar vacio");
                continue;
            }
            boolean validoP = true;
            for (char c : apellidoPaterno.toCharArray()) {
                if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                    validoP = false;
                    break;
                }
            }
            if (validoP){
                break;
            }else{
                System.out.println("Este campo es obligatorio y solo debe contener letras y/o espacios");
            }
        }    
        String apellidoMaterno = "";
        while(true){
            System.out.println("Ingresa tu apellido materno");
            apellidoMaterno = scanner.nextLine().trim();
            if (apellidoMaterno.isEmpty()){
                System.out.println("Este campo es obligatorio y no puede quedar vacio");
                continue;
            }
            boolean validoM = true;
            for (char c : apellidoPaterno.toCharArray()) {
                if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                    validoM = false;
                    break;
                }
            }
            if (validoM){
                break;
            }else{
                System.out.println("Este campo es obligatorio y solo debe contener letras y/o espacios");
            }
        }    
        System.out.println("Ingresa tu domicilio (Calle y numeracion)");
        String domicilio = scanner.nextLine().trim();
        
        String comuna = "";
        while (true){
            System.out.println("Ingresa la comuna donde vives");
            comuna = scanner.nextLine().trim();
            if (validarLetras(comuna)) {
                break;
            }
            System.out.println("Este campo es obligatorio y solo debe contener letras");
        }
        
        String telefono = "";
        while(true){
            System.out.println("Ingresa tu numero de telefono (9 digitos)");
            telefono = scanner.nextLine().trim();
            if (telefono.matches("\\d{9}")) {
                break;
            }
            System.out.println("Este campo es obligatorio y solo debe contener 9 numeros");
        }
        
        RegistroCliente nuevoCliente = new RegistroCliente (nombre, apellidoPaterno, apellidoMaterno, domicilio, comuna, rut, telefono, clientes);
        int numeroCuenta = nuevoCliente.getNumeroCuenta();
        OperacionesBancarias nuevaCuenta = new OperacionesBancarias (String.valueOf(numeroCuenta), nuevoCliente);
        
        clientes[totalClientes] = nuevoCliente;
        cuentas[totalClientes] = nuevaCuenta;
        totalClientes++;
        
        System.out.println("Tu registro se ha realizado con exito!");
        System.out.println("Tu numero de cuenta es: "+ numeroCuenta);
    }
    private static void verDatosCliente(Scanner scanner) {
        System.out.println("Ingresa el RUT del cliente");
        String rut = scanner.nextLine().trim();
        
        for (int i = 0; i < totalClientes; i++) {
            if (clientes[i].getRut().equals(rut)) {
                System.out.println("====== Datos del cliente ======");
                System.out.println("Nombre: "+clientes[i].getNombre()+" "+clientes[i].getApellidoPaterno()+" "+clientes[i].getApellidoMaterno());
                System.out.println("RUT: "+clientes[i].getRut());
                System.out.println("Direccion: "+clientes[i].getDomicilio());
                System.out.println("Telefono: "+clientes[i].getTelefono());
                System.out.println("Numero de cuenta corriente: "+clientes[i].getNumeroCuenta());
                return;
            }
        }
        System.out.println("Cliente no encontrado");
    }
    private static void realizarDeposito(Scanner scanner) {
        System.out.println("Ingrese el numero de cuenta a la que desea depositar");
        String numeroCuenta = scanner.nextLine().trim();
        
        for (int i = 0; i < totalClientes; i++) {
            if (cuentas[i].getNumeroCuenta().equals(numeroCuenta)) {
                while(true){
                    System.out.println("Cuanto es el monto a depositar? (No se permiten montos menores o igual a 0)");
                    try{
                        int monto = Integer.parseInt(scanner.nextLine().trim());
                        if (monto <= 0) {
                            System.out.println("Ingresa un monto mayor a 0");
                        }else{
                            System.out.println("Tu deposito de "+monto+" se ha realizado con exito!");
                            cuentas[i].depositar(monto);
                            break;
                        }
                    }catch(NumberFormatException e){
                        System.out.println("Ingresa un numero valido");
                    }
                }    
                return;
            }
        }
        System.out.println("Cuenta no existe");
    }
    private static void realizarGiro(Scanner scanner) {
        System.out.println("\n====== Realizar giro ======");
        System.out.println("Ingresa el numero de cuenta de la que deseas girar dinero");
        String numeroCuenta = scanner.nextLine().trim();
        
        OperacionesBancarias cuenta = null;
        for (int i = 0; i < totalClientes; i++) {
            if (cuentas[i].getNumeroCuenta().equals(numeroCuenta)) {
                cuenta=cuentas[i];
                break;
            }
        }
        if (cuenta == null) {
            System.out.println("Cuenta no existe en nuestro sistema");
            return;
        }
        System.out.println("Ingresa el monto que deseas girar: ");
        try{
            int monto = Integer.parseInt(scanner.nextLine().trim());
            cuenta.girar(monto);
        }catch (NumberFormatException e){
            System.out.println("Monto invalido. Debes ingresar un numero positivo");
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    private static void consultarSaldo(Scanner scanner) {
        System.out.println("\n====== Saldo de tu cuenta ======");
        System.out.println("Ingresa el numero de cuenta");
        String numeroCuenta = scanner.nextLine().trim();
        
        OperacionesBancarias cuenta = null;
        for (int i = 0; i < totalClientes; i++) {
            if (cuentas[i].getNumeroCuenta().equals(numeroCuenta)) {
                cuenta=cuentas[i];
                break;
            }
        }
        if (cuenta != null){
            System.out.println("Tu saldo actual es de: $"+cuenta.getSaldo());
        }else{
            System.out.println("Cuenta no encontrada");
        }
    }
}
