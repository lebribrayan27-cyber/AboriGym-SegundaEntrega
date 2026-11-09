package modelo;
public class Asistencia {
    private int idAsistencia;
    private int idSocio;
    private int idClase;
    private java.time.LocalDate fechaAsistencia;
    public Asistencia() {}
    public Asistencia(int idAsistencia, int idSocio, int idClase, java.time.LocalDate fechaAsistencia) {
        this.idAsistencia = idAsistencia;
        this.idSocio = idSocio;
        this.idClase = idClase;
        this.fechaAsistencia = fechaAsistencia;
    }
    public int getIdAsistencia() { return idAsistencia; }
    public void setIdAsistencia(int idAsistencia) { this.idAsistencia = idAsistencia; }
    public int getIdSocio() { return idSocio; }
    public void setIdSocio(int idSocio) { this.idSocio = idSocio; }
    public int getIdClase() { return idClase; }
    public void setIdClase(int idClase) { this.idClase = idClase; }
    public java.time.LocalDate getFechaAsistencia() { return fechaAsistencia; }
    public void setFechaAsistencia(java.time.LocalDate fechaAsistencia) { this.fechaAsistencia = fechaAsistencia; }
}