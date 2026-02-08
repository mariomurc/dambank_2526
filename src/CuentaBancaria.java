import java.util.Random;

public class CuentaBancaria {

    private String iban;
    private final String pin;
    //private String nombreCompleto;
    private Cliente cliente;
    private float saldo;
    //private String[] movimientos;
    private Movimientos[] movimientos;
    public int numMovimientos;
    private boolean estado;
    public static int totalCuentas=0;
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public CuentaBancaria(String iban, Cliente cliente, String pin) {
        this.iban = iban;
        this.cliente = cliente;
        this.saldo = 0;
        this.movimientos = new Movimientos[10];
        this.numMovimientos = 0;
        this.estado = true;
        this.pin = pin;
        totalCuentas++;
        System.out.println("CUENTA CREADA");
    }
    public String getIban() {return iban;}
    public String getPin() {return pin;}

    public Cliente getCliente() {
        return cliente;
    }

    public float getSaldo() {
        return saldo;
    }
    private void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void mostrarIban() {
        System.out.println("· IBAN: " + getIban());
    }
    public void mostrarTitular() {
        System.out.println("· TITULAR: " + getCliente().getPersona());
    }
    public void mostrarSaldo() {
        System.out.println("· SALDO: " + getSaldo());
    }

    public void mostrarInfoCuenta(boolean conMovimientos){
        System.out.println("*****************************");
        System.out.println("INFO COMPLETA CUENTA BANCARIA");
        System.out.println("*****************************");
        this.mostrarIban();
        this.mostrarTitular();
        this.mostrarSaldo();
        if (conMovimientos){
            this.mostrarMovimientos();
        }

    }
    public void ingreso(float cantidad, int tipo) {
        Random r = new Random();
        if (cantidad > 3000) {
            System.err.println("AVISO: Notificar a Hacienda");
        }
        setSaldo(getSaldo() + cantidad);
        if (tipo == 0){
            Movimientos m = new Movimientos("ING", cantidad, UtilisDatos.conceptos[r.nextInt(0,UtilisDatos.nombre.length)]);
            registrarMovimiento(m);
        }

    }

    public void retirada(float cantidad, int tipo) {
        Random r = new Random();
        float saldoFinal = getSaldo() - cantidad;
        if (saldoFinal < -50) {
            System.out.println("Operación no realizada");
        } else {
            setSaldo(saldoFinal);
            if (getSaldo() < 0) {
                System.err.println("AVISO: Saldo negativo");
            }
            if (tipo == 0) {
                Movimientos m = new Movimientos("RET", cantidad, UtilisDatos.conceptos[r.nextInt(0, UtilisDatos.conceptos.length)]);
                registrarMovimiento(m);
            }
        }
    }

    public void mostrarMovimientos() {
        System.out.println("· Movimientos en la cuenta:");
        for (int i = 0; i < numMovimientos; i++) {
            movimientos[i].mostrarMovimiento();
        }
    }

    private void registrarMovimiento(Movimientos movimiento) {
        if (numMovimientos >= 10) {
            for (int i = 0; i < 9; i++) {
                movimientos[i] = movimientos[i + 1];
            }
            numMovimientos--;
        }
        movimientos[numMovimientos] = movimiento;
        numMovimientos++;
    }
    public void invertir(String tipoRiesgo, int cantidad) {
        int cantRiesgo;
        Random r = new Random();
        int valor;
        do {
            valor = r.nextInt(-1, 2);
        } while (valor == 0);

        if (tipoRiesgo.equals("A")) {
            cantRiesgo = r.nextInt(50, 101) * valor;
        } else if (tipoRiesgo.equals("M")) {
            cantRiesgo = r.nextInt(10, 50) * valor;
        } else if (tipoRiesgo.equals("B")) {
            cantRiesgo = r.nextInt(1, 10) * valor;
        } else {
            System.out.println("TIPO DE INVERSIÓN NO VÁLIDA");
            return;
        }
        System.out.println("***************RIESGO====> " + cantRiesgo + "%");

        cantidad = cantidad * cantRiesgo/100;
        System.out.println("*********CANTIDAD GENERADA=====> " + cantidad);

        if (this.saldo + cantidad <= 10) {
            System.out.println("NO PUEDES REALIZAR LA INVERSIÓN");
            System.out.println("TU CUENTA SE QUEDARÍA PELÁ :-(");
        }else {
            this.saldo = this.saldo + cantidad;
            System.out.println("INVERSIÓN REALIZADA");
            Movimientos m = new Movimientos("INV", cantidad, UtilisDatos.conceptos[r.nextInt(0,UtilisDatos.conceptos.length)]);
            registrarMovimiento(m);
        }
    }
    public void transferir(CuentaBancaria destino, float cantidad) {
        Random r = new Random();
        UtilisPintar.teclado.nextLine(); //BUFFER
        System.out.println("Introduce el PIN de la cuenta origen:");
        String pinIntroducido = UtilisPintar.teclado.nextLine();

        if (!pinIntroducido.equals(this.getPin())) {
            System.out.println("ERROR: PIN incorrecto. No se puede realizar la transferencia.");
            return;
        }
        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser mayor que 0.");
            return;
        } else if (cantidad > this.getSaldo()) {
            System.out.println("Saldo insuficiente.");
            return;
        }

        this.retirada(cantidad * -1, 1);
        destino.ingreso(cantidad,1 );
        Movimientos m = new Movimientos("TRA", cantidad*-1, UtilisDatos.conceptos[r.nextInt(0,UtilisDatos.conceptos.length)]);
        Movimientos m1 = new Movimientos("TRA", cantidad, UtilisDatos.conceptos[r.nextInt(0,UtilisDatos.conceptos.length)]);
        this.registrarMovimiento(m);
        destino.registrarMovimiento(m1);

        System.out.println("Transferencia realizada correctamente.");
    }
}