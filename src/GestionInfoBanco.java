public class GestionInfoBanco {

    public static void GestionarInfoBanco(int opc){
        switch (opc){
            case 1:
                mostrarInformacionCuentas();
                break;
            case 2:
                calcularSaldoTotal();
                break;
            case 3:
                calcularSaldoMedio();
                break;
            case 4:
                cuentaConMayorSaldo();
                break;
            case 5:
                cuentasNumerosRojos();
                break;
            case 0:
                System.out.println("SALIDA AL MENÚ PRINCIPAL");
                break;

        }
    }

    public static void cuentasNumerosRojos(){
        boolean enc = false;
        for (int i = 0; i < UtilisPintar.NUM_MAX_CUENTAS; i++){
            if (GestionDamBank.cb[i].getSaldo() < 0){
                enc = true;
                GestionDamBank.cb[i].mostrarInfoCuenta(false);
            }
        }
        if (!enc){
            System.out.println("********************************");
            System.out.println("** NO HAY CUENTAS CON NÚMEROS ROJOS **");
            System.out.println("********************************");

        }

    }
    public static void cuentaConMayorSaldo(){
        int posCuentaMayor = 0;
        float maxSaldo = GestionDamBank.cb[0].getSaldo();
        for (int i = 1; i < UtilisPintar.NUM_MAX_CUENTAS; i++) {
            if (GestionDamBank.cb[i] != null) {
                if (GestionDamBank.cb[i].getSaldo() > maxSaldo){
                    posCuentaMayor = i;
                    maxSaldo = GestionDamBank.cb[i].getSaldo();
                }
            }
        }
        System.out.println("*** CUENTA CON MAYOR SALDO ***");
        GestionDamBank.cb[posCuentaMayor].mostrarInfoCuenta(false);
        System.out.println("******************************");
    }

    public static void calcularSaldoMedio(){
        float saldoTotal = calcularSaldoTotal();
        int i=0;
        boolean noMasCuentas = false;
        while (i < GestionDamBank.cb.length && !noMasCuentas){
            if (GestionDamBank.cb[i] != null){
                i++;

            } else {
                noMasCuentas = true;
            }

        }

        float saldoMedio = saldoTotal / i;
        System.out.println("*************************************");
        System.out.println("**  SALDO MEDIO CUENTAS BANCO: " + saldoMedio + " **");
        System.out.println("*************************************");
    }
    public static void mostrarInformacionCuentas() {
        System.out.println("---- INFORMACIÓN DE TODAS LAS CUENTAS ----");
        boolean algo = false;
        for (int i = 0; i < UtilisPintar.NUM_MAX_CUENTAS; i++) {
            if (GestionDamBank.cb[i] != null) {
                System.out.println("Cuenta " + (i + 1));
                GestionDamBank.cb[i].mostrarInfoCuenta(true);
            }
        }
        if(!algo) System.out.println("NO HAY NINGUNA CUENTA");
    }
    public static float calcularSaldoTotal(){
        float saldoTotalBanco=0;
        for (int i = 0; i < GestionDamBank.cb.length; i++) {
            if (GestionDamBank.cb[i] != null){
                saldoTotalBanco = saldoTotalBanco + GestionDamBank.cb[i].getSaldo();
            }

        }
        System.out.println("*************************************");
        System.out.println("**  SALDO TOTAL ACTUAL BANCO: " + saldoTotalBanco + " **");
        System.out.println("*************************************");
        return saldoTotalBanco;
    }

}
