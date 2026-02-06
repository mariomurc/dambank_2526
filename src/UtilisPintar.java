import java.util.Scanner;

public class UtilisPintar {
    public static Scanner teclado = new Scanner(System.in);
    public static int NUM_MAX_CUENTAS = 4;

    public static void pintarMenuPrincipal(){
        System.out.println("-- MENÚ PRINCIPAL DAMBANK --\n"
                + "1. Crear Cuenta Bancaria\n"
                + "2. Seleccionar Cuenta Bancaria\n"
                + "3. Información Cuentas Bancarias\n"
                + "4. Eliminar Cuenta Bancaria\n"
                + "0. Salir");
        System.out.println("ELIGE UNA DE LAS OPCIONES ANTERIORES:");
    }


    public static void pintarMenuCuenta() {
        System.out.println("-- MENÚ GESTIÓN CUENTA BANCARIA--\n"
                + "1. Datos de la cuenta\n"
                + "2. IBAN\n"
                + "3. Titular\n"
                + "4. Saldo\n"
                + "5. Ingreso\n"
                + "6. Retirada\n"
                + "7. Movimientos\n"
                + "8. Transferencia\n"
                + "9. Inversion\n"
                + "0. Salir");
        System.out.println("ELIGE UNA DE LAS OPCIONES ANTERIORES:");
    }
    public static void pintarMenuInfoBanco() {
        System.out.println("-- MENÚ INFO BANCO --\n"
                + "1. INFO TODAS LAS CUENTAS\n"
                + "2. SALDO TOTAL BANCO\n"
                + "3. SALDO MEDIO CUENTAS BANCO\n"
                + "4. DATOS CUENTA CON MAYOR SALDO\n"
                + "5. DATOS CUENTAS NÚMEROS ROJOS\n"
                + "0. SALIR");
        System.out.println("ELIGE UNA DE LAS OPCIONES ANTERIORES:");
    }
}
