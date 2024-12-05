package application.view;

import application.services.AdministradorService;

import java.util.Scanner;

public class AdministradorMenuView {
    private final AdministradorService adminService = new AdministradorService();
    Scanner scanner = new Scanner(System.in);

    public void menuAdministrador(){
        int op = 6;
        while(op != 0 ){
            System.out.println("------menu administrador");
            System.out.println("1- gestion de profesores");
            System.out.println("2- gestion de estudiantes");
            System.out.println("3- gestion de materias");
            System.out.println("0- salir");

            System.out.println("elijja una opcion: ");
            op = scanner.nextInt();

            switch (op){
                case 1: adminService.menuProfesores();
                break;
                case 2: adminService.menuEstudiantes();
                break;
                case 3: adminService.menuMaterias();
                break;
                case 0:
                    System.out.println("salir");
                    break;
                default:
                    System.out.println("opcion no valida");
            }
        }
    }

}
