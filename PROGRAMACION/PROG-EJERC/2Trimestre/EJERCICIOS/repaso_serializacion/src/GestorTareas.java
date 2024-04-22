import javax.swing.*;
import java.util.ArrayList;

public class GestorTareas {

    Tarea t = new Tarea();


    ArrayList<Tarea> tareas = new ArrayList<>();

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);

    }

    public void completadas() {
        int completada  = JOptionPane.showConfirmDialog(null, "¿La tarea " + t.getDescripcion() + " está completada?");

        if(completada == 0){
            t.setCompletada(false);

        }else{
            t.setCompletada(true);


        }
    }





}
