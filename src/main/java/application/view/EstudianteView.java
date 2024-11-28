package application.view;

import application.services.EstudianteService;

public class EstudianteView {
    public static void main(String[] args){
        EstudianteService estudianteService = new EstudianteService();
        estudianteService.guardar();
        estudianteService.mostrar();
        estudianteService.actualizar();
        estudianteService.mostrar();
        estudianteService.borrar();
    }
}
