package application.models;

public class Materia {

    private Long id;
    private String name;
    private Long id_profesor;

    public Materia() {
    }

    public Materia(Long id, String name, Long id_profesor) {
        this.id = id;
        this.name = name;
        this.id_profesor = id_profesor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(Long id_profesor) {
        this.id_profesor = id_profesor;
    }
}
