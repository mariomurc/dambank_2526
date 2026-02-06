public class DamBank {
    public static void main(String[] args) {
        int opc=0, opcCuenta=0, opcInfo=0;
        do{
            UtilisPintar.pintarMenuPrincipal();
            opc = UtilisPintar.teclado.nextInt();
            //limpieza buffer
            UtilisPintar.teclado.nextLine();
            switch (opc){
                case 1: //crear cuenta
                    GestionDamBank.crearCuenta();
                    break;
                case 2: //seleccionar cuenta
                    CuentaBancaria cb = GestionDamBank.seleccionarCuenta();
                    if (cb != null) {
                        do {
                            UtilisPintar.pintarMenuCuenta();
                            opcCuenta = UtilisPintar.teclado.nextInt();
                            GestionCuentaBancaria.gestionCB(cb,opcCuenta);
                        } while (opcCuenta != 0);
                    } else {
                        System.out.println("ERROR, LA CUENTA SELECCIONADA NO EXISTE");
                    }
                    break;
                case 3: //Informacion de las cuentas Bancarias
                    do{
                        UtilisPintar.pintarMenuInfoBanco();
                        opcInfo = UtilisPintar.teclado.nextInt();
                        //limpieza buffer
                        UtilisPintar.teclado.nextLine();
                        GestionInfoBanco.GestionarInfoBanco(opcInfo);
                    }while(opcInfo!=0);

                    //GestionDamBank.mostrarInformacionCuentas();
                    break;
                case 4:
                    GestionDamBank.eliminarCuentaBancaria();
                    break;
                case 0:
                    System.out.println("VAS A SALIR DE LA APLICACIÓN");
                    break;
                default:
                    System.out.println("OPCIÓN NO VÁLIDA");
            }
        } while (opc != 0);
    }
}