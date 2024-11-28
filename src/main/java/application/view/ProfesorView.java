package application.view;

import application.services.ProfesorService;

public class ProfesorView {
    public static void main(String[] args){
        ProfesorService profesorService = new ProfesorService();
        profesorService.guardar();
        profesorService.mostrar();
        profesorService.actualizar();
        profesorService.mostrar();
        profesorService.borrar();
    }
}
