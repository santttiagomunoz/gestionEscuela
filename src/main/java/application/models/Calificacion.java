package application.models;

public class Calificacion {

    private Long id_calificacion;
    private Long id_profesor;
    private Long id_materia;
    private String descripcion;

    public Calificacion(Long id_calificacion, Long id_profesor, Long id_materia, String descripcion) {
        this.id_calificacion = id_calificacion;
        this.id_profesor = id_profesor;
        this.id_materia = id_materia;
        this.descripcion = descripcion;
    }

    public Calificacion() {
    }

    public Long getId_calificacion() {
        return id_calificacion;
    }

    public void setId_calificacion(Long id_calificacion) {
        this.id_calificacion = id_calificacion;
    }

    public Long getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(Long id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getId_materia() {
        return id_materia;
    }

    public void setId_materia(Long id_materia) {
        this.id_materia = id_materia;
    }
}
