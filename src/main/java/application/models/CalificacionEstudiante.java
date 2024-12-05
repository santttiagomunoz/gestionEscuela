package application.models;

public class CalificacionEstudiante {

    private Long id_calificacion;
    private Long id_estudiante;
    private double nota;
    private Calificacion calificacion;
    private Estudiante estudiante;

    public CalificacionEstudiante(Long id_calificacion, Long id_estudiante, double nota) {
        this.id_calificacion = id_calificacion;
        this.id_estudiante = id_estudiante;
        this.nota = nota;
    }

    public CalificacionEstudiante() {
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Long getId_calificacion() {
        return id_calificacion;
    }

    public void setId_calificacion(Long id_calificacion) {
        this.id_calificacion = id_calificacion;
    }

    public Long getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(Long id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

}
