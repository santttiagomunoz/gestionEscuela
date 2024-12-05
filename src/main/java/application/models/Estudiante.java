package application.models;

import java.util.ArrayList;

public class Estudiante extends Usuario{

    public Estudiante(Long id, String name, String lastName, String email, String password, String rol) {
        super(id, name, lastName, email, password, rol);
    }
    public Estudiante(){

    }

}
