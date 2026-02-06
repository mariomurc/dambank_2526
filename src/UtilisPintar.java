import java.util.Scanner;

public class UtilisPintar {
    public static Scanner teclado = new Scanner(System.in);
    public static int NUM_MAX_CUENTAS = 4;

    public static void pintarMenuPrincipal(){
        System.out.println("""
                -- MENÚ PRINCIPAL DAMBANK --
                1. Crear Cuenta Bancaria
                2. Seleccionar Cuenta Bancaria
                3. Información Cuentas Bancarias
                4. Eliminar Cuenta Bancaria
                0. Salir""");
        System.out.println("ELIGE UNA DE LAS OPCIONES ANTERIORES:");
    }


    public static void pintarMenuCuenta() {
        System.out.println("""
                -- MENÚ GESTIÓN CUENTA BANCARIA--
                1. Datos de la cuenta
                2. IBAN
                3. Titular
                4. Saldo
                5. Ingreso
                6. Retirada
                7. Movimientos
                8. Transferencia
                9. Inversion
                0. Salir""");
        System.out.println("ELIGE UNA DE LAS OPCIONES ANTERIORES:");
    }
    public static void pintarMenuInfoBanco() {
        System.out.println("""
                -- MENÚ INFO BANCO --
                1. INFO TODAS LAS CUENTAS
                2. SALDO TOTAL BANCO
                3. SALDO MEDIO CUENTAS BANCO
                4. DATOS CUENTA CON MAYOR SALDO
                5. DATOS CUENTAS NÚMEROS ROJOS
                0. SALIR""");
        System.out.println("ELIGE UNA DE LAS OPCIONES ANTERIORES:");
    }
}
