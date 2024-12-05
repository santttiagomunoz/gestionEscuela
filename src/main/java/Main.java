import application.db.DbConecction;
import application.models.Estudiante;
import application.services.EstudianteService;
import application.view.LoginView;

public class Main {
    public static void main(String[] args){
        LoginView loginView = new LoginView();
        loginView.mostrarLogin();
    }
}
