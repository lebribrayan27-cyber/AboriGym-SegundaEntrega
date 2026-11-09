package modelo;
public class ClaseGym {
    private int idClase;
    private String disciplina;
    private int idEntrenador;
    private String horario;
    private int capacidad;
    private boolean estado;
    public ClaseGym() {}
    public ClaseGym(int idClase, String disciplina, int idEntrenador, String horario, int capacidad, boolean estado) {
        this.idClase = idClase;
        this.disciplina = disciplina;
        this.idEntrenador = idEntrenador;
        this.horario = horario;
        this.capacidad = capacidad;
        this.estado = estado;
    }
    public int getIdClase() { return idClase; }
    public void setIdClase(int idClase) { this.idClase = idClase; }
    public String getDisciplina() { return disciplina; }
    public void setDisciplina(String disciplina) { this.disciplina = disciplina; }
    public int getIdEntrenador() { return idEntrenador; }
    public void setIdEntrenador(int idEntrenador) { this.idEntrenador = idEntrenador; }
    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }
    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }
    public boolean getEstado() { return estado; }
    public void setEstado(boolean estado) { this.estado = estado; }
}