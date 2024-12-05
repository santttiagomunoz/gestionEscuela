package application.view;

import application.models.Usuario;
import application.services.LoginService;

import java.util.Scanner;

public class LoginView {

    private final LoginService loginService = new LoginService();
    Scanner scanner = new Scanner(System.in);
    AdministradorMenuView administradorMenuView = new AdministradorMenuView();
    ProfesorMenuView profesorMenuView = new ProfesorMenuView();
    EstudianteMenuView estudianteMenuView = new EstudianteMenuView();

    public void mostrarLogin(){
        Usuario usuario;
        String op;
        do{
            System.out.println("-------LOGIN");
            System.out.println("email :");
            String email = scanner.next();
            System.out.println("password: ");
            String password = scanner.next();

            usuario = loginService.autenticar(email, password);

            if (usuario != null){

                switch (usuario.getRol().toLowerCase()){
                    case "administrador":
                        System.out.println("bienvenido administrador");
                        administradorMenuView.menuAdministrador();
                        break;
                    case "profesor" :
                        System.out.println("bienvenido profesor");
                        profesorMenuView.mostrarMenuProfesor();
                        break;
                    case  "estudiante":
                        System.out.println("bienvenido estudiante");
                        estudianteMenuView.menuEstudiante();
                        break;
                    default:
                        System.out.println("rol no encontrado");
                        break;
                }
            }else{
                System.out.println("usuario o contraseña incorrectos");
            }
            System.out.println("desea volver a ingresar? s/n");
            op = scanner.next();
        }while(op.equals("s"));

    }
}
