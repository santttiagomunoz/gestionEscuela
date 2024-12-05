package application.services;

import application.dao.CalificacionDao;
import application.dao.EstudianteDao;
import application.models.Estudiante;
import application.models.Materia;

import java.util.ArrayList;
import java.util.Scanner;

import static application.dao.EstudianteDao.buscarEstudiante;

public class EstudianteService implements Crud{
    Scanner sc = new Scanner(System.in);

    public void mostrar() {

        System.out.println("ingresar id estudiante: ");
        Long id = sc.nextLong();
        Estudiante estudiante = buscarEstudiante(id);

        if(buscarEstudiante(id) != null){
            System.out.println("id del estudiante: " + estudiante.getId());
            System.out.println("nombre del estudiante: " + estudiante.getName());
            System.out.println("apellido estudiante: " + estudiante.getLastName());
        }
    }


    public void guardar() {
        Estudiante estudiante = new Estudiante();
        System.out.println("Ingresar datos del estudiante ");
        System.out.println("id:");
        Long id = sc.nextLong();
        estudiante.setId(id);
        sc.nextLine();

        System.out.println("Nombre del estudiante:");
        String nombre = sc.nextLine();
        estudiante.setName(nombre);

        System.out.println("Apellido del estudiante:");
        String apellidos = sc.nextLine();
        estudiante.setLastName(apellidos);

        System.out.println("Contraseña del estudiante");
        String pass = sc.nextLine();
        estudiante.setPassword(pass);

        EstudianteDao.guardarEstudiante(estudiante);
    }


    public String actualizar() {
        Estudiante estudiante = new Estudiante();

        try{
            System.out.println("ingresar id del estudiante: ");
            Long id = sc.nextLong();
            System.out.println("ingrese nuevo nombre: ");
            String name = sc.next();
            System.out.print("ingrese nuevo apellido: ");
            String lastName = sc.next();

            estudiante.setId(id);
            estudiante.setName(name);
            estudiante.setLastName(lastName);

            EstudianteDao.actualizarEstudiante(estudiante);
            return "estudiante actualizado";
        }catch (Exception e){
            return "algo salio mal " + e;
        }
    }

    public void borrar() {
        System.out.println("ingrese id del estudiante: ");
        Long id = sc.nextLong();
        EstudianteDao.eliminarEstudiante(id);

    }

    public void verCalificaciones(){
        System.out.println("ingrese su id estudiante: ");
        Long id = sc.nextLong();
        CalificacionDao.obtenerCalificacionEstudiante(id);
    }

}
