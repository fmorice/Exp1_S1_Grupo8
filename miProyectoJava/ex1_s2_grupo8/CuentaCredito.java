package ex1_s2_grupo8;

public class CuentaCredito extends CuentaBancaria {
    private int limiteCredito = 500000; // Puedes modificar este valor

    public CuentaCredito(int numeroCuenta) {
        super(numeroCuenta);
    }

    @Override
    public void girar(int monto) {
        if (monto <= 0) {
            System.out.println("El monto debe ser mayor a 0.");
        } else if (monto > (saldo + limiteCredito)) {
            System.out.println("Supera el límite de crédito disponible.");
        } else {
            saldo -= monto;
            System.out.println("Giro desde cuenta de crédito exitoso. Saldo actual: " + saldo + " pesos.");
        }
    }
}
