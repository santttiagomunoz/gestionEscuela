package application.view;

import application.services.MateriaService;

public class MateriaView {
    public static void main(String[] args){
        MateriaService materiaService = new MateriaService();
        materiaService.guardar();
        materiaService.mostrar();
        materiaService.actualizar();
        materiaService.mostrar();
        materiaService.borrar();
    }
}
