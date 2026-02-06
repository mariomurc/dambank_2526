public class GestionInfoBanco {

    public static void GestionarInfoBanco(int opc){
        switch (opc){
            case 1:
                mostrarInformacionCuentas();
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 0:
                System.out.println("SALIDA AL MENÚ PRINCIPAL");
                break;

        }
    }

    public static void mostrarInformacionCuentas() {
        System.out.println("---- INFORMACIÓN DE TODAS LAS CUENTAS ----");
        boolean algo = false;
        for (int i = 0; i < UtilisPintar.NUM_MAX_CUENTAS; i++) {
            if (GestionDamBank.cb[i] != null) {
                System.out.println("Cuenta " + (i + 1));
                GestionDamBank.cb[i].mostrarInfoCuenta();
            }
        }
        if(!algo) System.out.println("NO HAY NINGUNA CUENTA");
    }

}
