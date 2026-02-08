public class DamBank {
    public static void main(String[] args) {
        int opc, opcCuenta, opcInfo;
        do{
            UtilisPintar.pintarMenuPrincipal();
            opc = UtilisPintar.teclado.nextInt();
            //limpieza buffer
            UtilisPintar.teclado.nextLine();
            switch (opc) {
                case 1 -> //crear cuenta
                        GestionDamBank.crearCuenta();
                case 2 -> { //seleccionar cuenta
                    CuentaBancaria cb = GestionDamBank.seleccionarCuenta();
                    if (cb != null) {
                        do {
                            UtilisPintar.pintarMenuCuenta();
                            opcCuenta = UtilisPintar.teclado.nextInt();
                            GestionCuentaBancaria.gestionCB(cb, opcCuenta);
                        } while (opcCuenta != 0);
                    } else {
                        System.out.println("ERROR, LA CUENTA SELECCIONADA NO EXISTE");
                    }
                }
                case 3 -> { //Informacion de las cuentas Bancarias

                    do {
                        UtilisPintar.pintarMenuInfoBanco();
                        opcInfo = UtilisPintar.teclado.nextInt();
                        //limpieza buffer
                        UtilisPintar.teclado.nextLine();
                        GestionInfoBanco.GestionarInfoBanco(opcInfo);
                    } while (opcInfo != 0);
                }

                //GestionDamBank.mostrarInformacionCuentas();
                case 4 -> GestionDamBank.eliminarCuentaBancaria();
                case 0 -> System.out.println("VAS A SALIR DE LA APLICACIÓN");
                default -> System.out.println("OPCIÓN NO VÁLIDA");
            }
        } while (opc != 0);
    }
}