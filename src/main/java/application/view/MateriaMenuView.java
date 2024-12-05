package application.view;

import application.services.EstudianteService;
import application.services.MateriaService;

import java.util.Scanner;

public class MateriaMenuView {
    MateriaService materiaService = new MateriaService();
    Scanner scanner = new Scanner(System.in);
    public void menuMateeria(){
        int op = 7;
        while(op != 0){
            System.out.println("------menu materias");
            System.out.println("1- guardar materia");
            System.out.println("2- ver materia");
            System.out.println("3- borrar materia");
            System.out.println("4- ver materias");
            System.out.println("0- salir");

            System.out.println("elija una opcion");
            op = scanner.nextInt();

            switch (op){
                case 1: materiaService.guardar();
                    break;
                case 2: materiaService.mostrar();
                    break;
                case 3: materiaService.borrar();
                break;
                case 4: materiaService.mostrarMaterias();
                case 0:
                    System.out.println("saliendo...");
                default:
                    System.out.println("opcion no valida");
            }
        }
    }
}
