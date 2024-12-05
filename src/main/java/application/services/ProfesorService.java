package application.services;

import application.dao.CalificacionDao;
import application.dao.EstudianteDao;
import application.dao.ProfesorDao;
import application.models.Calificacion;
import application.models.CalificacionEstudiante;
import application.models.Estudiante;
import application.models.Profesor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import static application.dao.ProfesorDao.buscarProfesor;

public class ProfesorService implements Crud{

    Scanner sc = new Scanner(System.in);

    public void mostrar() {

        System.out.println("ingresar id profesor: ");
        Long id = sc.nextLong();
        Profesor profesor = buscarProfesor(id);

        if(buscarProfesor(id) != null){
            System.out.println("id del profesor: " + profesor.getId());
            System.out.println("nombre del profesor: " + profesor.getName());
            System.out.println("apellido profesor: " + profesor.getLastName());
            System.out.println("email del profesor: "+ profesor.getEmail());
            System.out.println("especialidad del profesor: "+ profesor.getSpeciality());
        }
    }

    public void guardar() {
        Profesor profesor = new Profesor();
        System.out.println("Ingresar datos del profesor ");
        System.out.println("id:");
        Long id = sc.nextLong();
        profesor.setId(id);
        sc.nextLine();

        System.out.println("Nombre del profesor:");
        String nombre = sc.nextLine();
        profesor.setName(nombre);

        System.out.println("Apellido del profesor:");
        String apellidos = sc.nextLine();
        profesor.setLastName(apellidos);

        System.out.println("email del profesor");
        String email = sc.nextLine();
        profesor.setEmail(email);

        System.out.println("Contraseña del profesor");
        String pass = sc.nextLine();
        profesor.setPassword(pass);

        profesor.setRol("profesor");

        System.out.println("especialidad del profesor");
        String speciality = sc.nextLine();
        profesor.setSpeciality(speciality);

        ProfesorDao.guardarProfesor(profesor);
    }


    public String actualizar() {
        Profesor profesor = new Profesor();

        try{
            System.out.println("ingresar id del profesor: ");
            Long id = sc.nextLong();
            System.out.println("ingrese nuevo nombre: ");
            String name = sc.next();
            System.out.print("ingrese nuevo apellido: ");
            String lastName = sc.next();
            System.out.print("ingrese nuevo email: ");
            String email = sc.next();
            System.out.print("ingrese nuevo apellido: ");
            String speciality = sc.next();

            profesor.setId(id);
            profesor.setName(name);
            profesor.setLastName(lastName);
            profesor.setEmail(email);
            profesor.setSpeciality(speciality);

            ProfesorDao.actualizarProfesor(profesor);
            return "profesor actualizado";
        }catch (Exception e){
            return "algo salio mal " + e;
        }



    }

    public void borrar() {
        System.out.println("ingrese id del profesor: ");
        Long id = sc.nextLong();
        ProfesorDao.eliminarProfesor(id);
    }

    public void ingresarEvaluacion(){
        System.out.println("ingrese id de profesor: ");
        Long id_Profesor = sc.nextLong();
        System.out.println("ingrese id de materia: ");
        Long id_materia = sc.nextLong();
        System.out.println("ingrese descripcion: ");
        String descripcion = sc.next();
        Calificacion calificacion = new Calificacion();
        calificacion.setId_profesor(id_Profesor);
        calificacion.setId_materia(id_materia);
        calificacion.setDescripcion(descripcion);
        CalificacionDao.guardarEvaluacion(calificacion);
        System.out.println("evaluacion guardada");
    }
    public void calificarEstudiante(){
        System.out.println("ingrese id de la evaluacion: ");
        Long id_calificacion = sc.nextLong();
        System.out.println("ingrese id del estudiante: ");
        Long id_estudiante = sc.nextLong();
        System.out.println("ingrese nota: ");
        double nota = sc.nextDouble();
            CalificacionEstudiante calificacionEstudiante = new CalificacionEstudiante();
            calificacionEstudiante.setId_calificacion(id_calificacion);
            calificacionEstudiante.setId_estudiante(id_estudiante);
            calificacionEstudiante.setNota(nota);
            CalificacionDao.asignarCalificacionEstudiante(calificacionEstudiante);
        System.out.println("calificacion guardada");
    }

    public void verCalificacion(){
        System.out.println("ingrese id del estudiante: ");
        Long id = sc.nextLong();
        List<CalificacionEstudiante> calificacion = CalificacionDao.obtenerCalificacionEstudiante(id);

        if(calificacion.isEmpty()){
            System.out.println("lista vacia");
        }
        for(CalificacionEstudiante calificacionEstudiante : calificacion){
            System.out.println(" =============== ===================  ====== ==========================");
            System.out.println("| id_evaluacion | nombre_estudiante | nota | descripcion               |");
            System.out.println(" =============== =================== ====== ===========================");
            System.out.print("|       "+calificacionEstudiante.getId_calificacion()+ "       ");
            System.out.print("|      "+calificacionEstudiante.getEstudiante().getName()+ "    ");
            System.out.print("    |  "+calificacionEstudiante.getNota()+ " ");
            System.out.println("| "+calificacionEstudiante.getCalificacion().getDescripcion()+ "|");
            System.out.println(" =============== =================== ====== ===========================");
            System.out.println();
        }
    }

    public void mostrarEstudiantes(){
        List<Estudiante> estudiantes = EstudianteDao.buscarEstudiantes();
        for (Estudiante estudiante: estudiantes){
            System.out.println("id_estudiante: " + estudiante.getId());
            System.out.println("nombre: " + estudiante.getName());
            System.out.println("apellido: " + estudiante.getLastName());
            System.out.println("email: " + estudiante.getEmail());
        }
    }

    public void mostrarProfesores(){
        List<Profesor> profesores = ProfesorDao.buscarProfesores();
        for (Profesor profesor: profesores){
            System.out.println("id_profesor: " + profesor.getId());
            System.out.println("nombre: " + profesor.getName());
            System.out.println("apellido: " + profesor.getLastName());
            System.out.println("email: " + profesor.getEmail());
        }
    }
    public void actualizarCalificacion(){

    }
}
