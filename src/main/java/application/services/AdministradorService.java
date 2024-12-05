package application.services;

import java.util.Scanner;

public class AdministradorService {
    Scanner scanner = new Scanner(System.in);

    public void menuProfesores(){
        ProfesorService profesorService = new ProfesorService();
            int op = 6;
            while(op != 0){
                System.out.println("---- opciones de profesor");
                System.out.println("1- agregar profesor");
                System.out.println("2- ver profesor");
                System.out.println("3- modificar profesor");
                System.out.println("4- borrar profesor");
                System.out.println("5- ver profesores");
                System.out.println("0- salir");

                System.out.println("selecciones una opcion: ");
                op = scanner.nextInt();

                switch (op){
                    case 1 :   profesorService.guardar();
                        break;
                    case 2:   profesorService.mostrar();
                        break;
                    case 3:   profesorService.actualizar();
                        break;
                    case 4:   profesorService.borrar();
                        break;
                    case 5: profesorService.mostrarProfesores();
                    break;
                    default:
                        System.out.println("opcion no valida");
                }
        }
    }

    public void menuEstudiantes(){
        EstudianteService estudianteService = new EstudianteService();
        int op = 6;
        while(op != 0){
            System.out.println("---- opciones de estudiante");
            System.out.println("1- agregar estudiante");
            System.out.println("2- ver estudiante");
            System.out.println("3- modificar estudiante");
            System.out.println("4- borrar estudiante");
            System.out.println("0- salir");

            System.out.println("selecciones una opcion: ");
            op = scanner.nextInt();

            switch (op){
                case 1 : estudianteService.guardar();
                    break;
                case 2: estudianteService.mostrar();
                    break;
                case 3: estudianteService.actualizar();
                    break;
                case 4: estudianteService.borrar();
                    break;
                default:
                    System.out.println("opcion no valida");
            }
        }
    }

    public void menuMaterias(){
        MateriaService materiaService = new MateriaService();
        int op = 6;
        while(op != 0){
            System.out.println("---- opciones de materia");
            System.out.println("1- agregar materia");
            System.out.println("2- ver materia");
            System.out.println("3- modificar materia");
            System.out.println("4- borrar materia");
            System.out.println("0- salir");

            System.out.println("selecciones una opcion: ");
            op = scanner.nextInt();

            switch (op){
                case 1 : materiaService.guardar();
                    break;
                case 2: materiaService.mostrar();
                    break;
                case 3: materiaService.actualizar();
                    break;
                case 4: materiaService.borrar();
                    break;
                default:
                    System.out.println("opcion no valida");
            }
        }
    }

}
