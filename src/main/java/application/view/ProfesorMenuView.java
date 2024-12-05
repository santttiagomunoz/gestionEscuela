package application.view;

import application.services.ProfesorService;

import java.util.Scanner;

public class ProfesorMenuView {
    Scanner scanner = new Scanner(System.in);
    private final ProfesorService profesorService = new ProfesorService();

    public void mostrarMenuProfesor(){
        int op = 6;
        while(op != 0){
            System.out.println("---- opciones de profesor");
            System.out.println("1- agregar momento evaluativo");
            System.out.println("2- calificar estudiante");
            System.out.println("3- ver calificacion");
            System.out.println("4- ver estudiantes");
            System.out.println("0- salir");

            System.out.println("selecciones una oopcion: ");
            op = scanner.nextInt();

            switch (op){
                case 1: profesorService.ingresarEvaluacion();
                break;
                case 2: profesorService.calificarEstudiante();
                break;
                case 3: profesorService.verCalificacion();
                break;
                case 4: profesorService.mostrarEstudiantes();
                break;
                default:
                    System.out.println("opcion no valida");
            }
        }
    }
}
