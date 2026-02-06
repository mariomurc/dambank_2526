import java.time.LocalDateTime;

public class Movimientos {
    private final String tipoMovimiento;
    private final float importeMovimiento;
    private final String conceptoMovimiento;
    private final LocalDateTime fechaMovimiento;

    public Movimientos (String tipoMovimiento,float importeMovimiento,String conceptoMovimiento){
        this.tipoMovimiento = tipoMovimiento;
        this.importeMovimiento=importeMovimiento;
        this.conceptoMovimiento=conceptoMovimiento;
        this.fechaMovimiento = LocalDateTime.now();
    }

    public float getImporteMovimiento() {
        return importeMovimiento;
    }
    public String getConceptoMovimiento() {
        return conceptoMovimiento;
    }
    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public String getFechaMovimiento() {
        String fechaOrganizada;
        fechaOrganizada=fechaMovimiento.getDayOfMonth()+"/"+fechaMovimiento.getMonthValue() +"/"+fechaMovimiento.getYear()
                +" a las "+fechaMovimiento.getHour()+":"+fechaMovimiento.getMinute();
        return fechaOrganizada;
    }
    public void mostrarMovimiento(){
        System.out.println("TIPO: " + this.tipoMovimiento);
        System.out.println("CONCEPTO: " + this.conceptoMovimiento);
        System.out.println("CANTIDAD: " + this.importeMovimiento);
        System.out.println("FECHA: " + this.getFechaMovimiento());
        System.out.println("**********************************");
    }
}
