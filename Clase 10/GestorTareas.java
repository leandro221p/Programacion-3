
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class GestorTareas{

public class tarea {
    private String id;
    private String descripcion;
    private int prioridad;
    private double tiempoLlegada;
    Stack<String> PilaPrioridad= new Stack<>();
    Queue<String> ColaEspera= new LinkedList<>();

    public tarea(String id, String descripcion, int prioridad, double tiempoLlegada) {
        this.id = id;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.tiempoLlegada = tiempoLlegada;
    }

    public void agregartarea(tarea tarea) {
        
        if (tarea.prioridad == 3) {
            System.out.println("Su tarea es de prioridad alta ya fue agregada a la cola de espera");
            PilaPrioridad.push(tarea.id + " - " + tarea.descripcion + " - " + tarea.prioridad + " - " + tarea.tiempoLlegada);

        } else {
            if (tarea.prioridad <= 2) {
                System.out.println("Su tarea fue agregada a la cola de espera");
                ColaEspera.add(tarea.id + " - " + tarea.descripcion + " - " + tarea.prioridad + " - " + tarea.tiempoLlegada);

            }
        }

    } 
    public void procesarSiguienteTarea() {
        if (PilaPrioridad.isEmpty()) {
        
        }
      
        }
    }
}