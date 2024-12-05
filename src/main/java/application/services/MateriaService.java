package application.services;

import application.dao.MateriaDao;
import application.dao.ProfesorDao;
import application.models.Materia;
import application.models.Profesor;

import java.util.List;
import java.util.Scanner;

import static application.dao.MateriaDao.buscarMateria;

public class MateriaService implements Crud{

    Scanner sc = new Scanner(System.in);

    public void mostrar() {

        System.out.println("ingresar id materia: ");
        Long id = sc.nextLong();
        Materia materia = buscarMateria(id);

        if(buscarMateria(id) != null){
            Profesor profesor;
            System.out.println("id de la materia: " + materia.getId());
            System.out.println("nombre del materia: " + materia.getName());
            profesor = ProfesorDao.buscarProfesor(materia.getId_profesor());
            System.out.println("profesor asignado: " + profesor.getName());
        }
    }

    public void mostrarMaterias(){
        List<Materia> materias = MateriaDao.buscarMaterias();
        for (Materia materia: materias){
            System.out.println("id_profesor: " + materia.getId());
            System.out.println("nombre: " + materia.getName());
            System.out.println("apellido: " + materia.getId_profesor());
        }
    }

    public void guardar() {
        Materia materia = new Materia();
        System.out.println("Ingresar datos del materia ");
        System.out.println("id:");
        Long id = sc.nextLong();
        materia.setId(id);
        sc.nextLine();

        System.out.println("Nombre del materia:");
        String nombre = sc.nextLine();
        materia.setName(nombre);

        System.out.println("id del profesor:");
        Long id_profesor = sc.nextLong();
        materia.setId_profesor(id_profesor);

        MateriaDao.guardarMateria(materia);
    }


    public String actualizar() {
        Materia materia = new Materia();

        try{
            System.out.println("ingresar id de la materia: ");
            Long id = sc.nextLong();
            System.out.println("ingrese nuevo nombre: ");
            String name = sc.next();
            System.out.println("ingrese nuevo id profesor: ");
            Long id_profesor = sc.nextLong();
            materia.setId(id);
            materia.setName(name);
            materia.setId_profesor(id_profesor);

            MateriaDao.actualizarMateria(materia);
            return "materia actualizado";
        }catch (Exception e){
            return "algo salio mal " + e;
        }
    }

    public void borrar() {
        System.out.println("ingrese id del materia: ");
        Long id = sc.nextLong();
        MateriaDao.eliminarMateria(id);

    }
}
