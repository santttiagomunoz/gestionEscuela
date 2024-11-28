package application.services;

import application.dao.ProfesorDao;
import application.models.Profesor;

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

        System.out.println("Contraseña del profesor");
        String pass = sc.nextLine();
        profesor.setPassword(pass);

        System.out.println("email del profesor");
        String email = sc.nextLine();
        profesor.setEmail(email);

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

            profesor.setId(id);
            profesor.setName(name);
            profesor.setLastName(lastName);

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
}
