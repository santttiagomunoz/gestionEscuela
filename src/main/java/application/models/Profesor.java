package application.models;

public class Profesor extends Usuario{

    private String Speciality;

    public Profesor(Long id, String name, String lastName, String email, String password, String rol, String speciality) {
        super(id, name, lastName, email, password, rol);
        Speciality = speciality;
    }

    public Profesor(){

    }

    public String getSpeciality() {
        return Speciality;
    }

    public void setSpeciality(String speciality) {
        Speciality = speciality;
    }
}
