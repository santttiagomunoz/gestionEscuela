package application.view;

import application.services.EstudianteService;

import java.util.Scanner;

public class EstudianteMenuView {
   EstudianteService estudianteService = new EstudianteService();
   Scanner scanner = new Scanner(System.in);
   public void menuEstudiante(){
       int op = 7;
       while(op != 0){
           System.out.println("------menu estudiante");
           System.out.println("1- ver calificaciones");
           System.out.println("2- ver mi informacion");
           System.out.println("0- salir");

           System.out.println("elija una opcion");
           op = scanner.nextInt();

           switch (op){
               case 1: estudianteService.verCalificaciones();
               break;
               case 2: estudianteService.mostrar();
               break;
               case 0:
                   System.out.println("saliendo...");
                   break;
               default:
                   System.out.println("opcion no valida");
           }
       }
   }
}
