package application.services;

import application.dao.MateriaDao;
import application.models.Materia;

import java.util.Scanner;

import static application.dao.MateriaDao.buscarMateria;

public class MateriaService implements Crud{

    Scanner sc = new Scanner(System.in);

    public void mostrar() {

        System.out.println("ingresar id materia: ");
        Long id = sc.nextLong();
        Materia materia = buscarMateria(id);

        if(buscarMateria(id) != null){
            System.out.println("id del materia: " + materia.getId());
            System.out.println("nombre del materia: " + materia.getName());
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

        MateriaDao.guardarMateria(materia);
    }


    public String actualizar() {
        Materia materia = new Materia();

        try{
            System.out.println("ingresar id de la materia: ");
            Long id = sc.nextLong();
            System.out.println("ingrese nuevo nombre: ");
            String name = sc.next();

            materia.setId(id);
            materia.setName(name);

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
