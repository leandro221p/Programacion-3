

import java.time.Instant;

public class Tarea {
    private String id;
    private String descripcion;
    private int prioridad; // 1 = Baja, 2 = Media, 3 = Alta
    private long tiempoLlegada;

    public Tarea(String id, String descripcion, int prioridad) {
        this.id = id;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.tiempoLlegada = Instant.now().toEpochMilli();
    }

    public String getId() { return id; }
    public String getDescripcion() { return descripcion; }
    public int getPrioridad() { return prioridad; }
    public long getTiempoLlegada() { return tiempoLlegada; }

    @Override
    public String toString() {
        return "Tarea{" +
                "id='" + id + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", prioridad=" + prioridad +
                ", llegada=" + tiempoLlegada +
                '}';
    }
}



import java.util.*;

public class GestorTareas {
    private Stack<Tarea> pilaPrioritaria;
    private Queue<Tarea> colaEspera;
    private Map<String, String> registro;

    public GestorTareas() {
        pilaPrioritaria = new Stack<>();
        colaEspera = new LinkedList<>();
        registro = new HashMap<>();
    }

    public void agregarTarea(Tarea tarea) {
        if (tarea.getPrioridad() == 3) {
            pilaPrioritaria.push(tarea);
            System.out.println("Tarea de alta prioridad agregada a la pila: " + tarea.getId());
        } else {
            colaEspera.offer(tarea);
            System.out.println("Tarea normal agregada a la cola: " + tarea.getId());
        }
    }

    public Tarea procesarSiguienteTarea() {
        Tarea tareaProcesada = null;
        if (!pilaPrioritaria.isEmpty()) {
            tareaProcesada = pilaPrioritaria.pop();
        } else if (!colaEspera.isEmpty()) {
            tareaProcesada = colaEspera.poll();
        }

        if (tareaProcesada != null) {
            registro.put(tareaProcesada.getId(), "Completada");
            System.out.println("Tarea procesada: " + tareaProcesada.getId());
        } else {
            System.out.println("No hay tareas pendientes.");
        }
        return tareaProcesada;
    }

    public String consultarEstadoTarea(String idTarea) {
        if (registro.containsKey(idTarea)) {
            return "Tarea " + idTarea + " → Completada";
        }
        for (Tarea t : pilaPrioritaria) {
            if (t.getId().equals(idTarea)) {
                return "Tarea " + idTarea + " → Pendiente (Alta prioridad)";
            }
        }
        for (Tarea t : colaEspera) {
            if (t.getId().equals(idTarea)) {
                return "Tarea " + idTarea + " → Pendiente (Normal)";
            }
        }
        return "ID no encontrado";
    }

    public void mostrarEstructuras() {
        System.out.println("\n--- Estado actual del Gestor ---");
        System.out.println("Pila prioritaria: " + pilaPrioritaria);
        System.out.println("Cola de espera: " + colaEspera);
        System.out.println("Registro de tareas completadas: " + registro);
        System.out.println("---------------------------------\n");
    }
}



public class Main {
    public static void main(String[] args) {
        GestorTareas gestor = new GestorTareas();

        Tarea t1 = new Tarea("T001", "Enviar reporte", 2);
        Tarea t2 = new Tarea("T002", "Actualizar base de datos", 3);
        Tarea t3 = new Tarea("T003", "Notificar usuario", 1);
        Tarea t4 = new Tarea("T004", "Reiniciar servidor", 3);

        gestor.agregarTarea(t1);
        gestor.agregarTarea(t2);
        gestor.agregarTarea(t3);
        gestor.agregarTarea(t4);

        gestor.mostrarEstructuras();

        gestor.procesarSiguienteTarea();
        gestor.procesarSiguienteTarea();

        gestor.mostrarEstructuras();

        System.out.println(gestor.consultarEstadoTarea("T001"));
        System.out.println(gestor.consultarEstadoTarea("T004"));
        System.out.println(gestor.consultarEstadoTarea("T999"));
    }
}

