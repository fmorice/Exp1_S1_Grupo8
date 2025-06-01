package ex1_s2_grupo8;

public abstract class CuentaBancaria {
    protected int numeroCuenta;
    protected int saldo;
    
    public CuentaBancaria(int numeroCuenta, int saldoInicial) {
        //Verificacion de datos ingresados por cliente
        if (numeroCuenta <= 0) {
            throw new IllegalArgumentException ("Numero de cuenta debe ser positivo");
        }
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
    public void consultarSaldo(){
        System.out.println("Saldo actual: "+ saldo + " pesos");
    }
    public void consultarSaldo(String mensajePersonalizado){
        System.out.println(mensajePersonalizado + saldo + " pesos");
    }
}