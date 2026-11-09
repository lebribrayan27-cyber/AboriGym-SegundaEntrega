package modelo;
public class Pase {
    private int idPase;
    private int idSocio;
    private int cantidadEntradas;
    private java.time.LocalDate fechaInicio;
    private java.time.LocalDate fechaFin;
    private java.math.BigDecimal costo;
    private boolean estado;
    public Pase() {}
    public Pase(int idPase, int idSocio, int cantidadEntradas, java.time.LocalDate fechaInicio, java.time.LocalDate fechaFin, java.math.BigDecimal costo, boolean estado) {
        this.idPase = idPase;
        this.idSocio = idSocio;
        this.cantidadEntradas = cantidadEntradas;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costo = costo;
        this.estado = estado;
    }
    public int getIdPase() { return idPase; }
    public void setIdPase(int idPase) { this.idPase = idPase; }
    public int getIdSocio() { return idSocio; }
    public void setIdSocio(int idSocio) { this.idSocio = idSocio; }
    public int getCantidadEntradas() { return cantidadEntradas; }
    public void setCantidadEntradas(int cantidadEntradas) { this.cantidadEntradas = cantidadEntradas; }
    public java.time.LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(java.time.LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
    public java.time.LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(java.time.LocalDate fechaFin) { this.fechaFin = fechaFin; }
    public java.math.BigDecimal getCosto() { return costo; }
    public void setCosto(java.math.BigDecimal costo) { this.costo = costo; }
    public boolean getEstado() { return estado; }
    public void setEstado(boolean estado) { this.estado = estado; }
}