import application.db.DbConecction;
import application.models.Estudiante;
import application.services.EstudianteService;

public class Main {
    public static void main(String[] args){
        EstudianteService estudianteService = new EstudianteService();
        estudianteService.borrar();
    }
}
