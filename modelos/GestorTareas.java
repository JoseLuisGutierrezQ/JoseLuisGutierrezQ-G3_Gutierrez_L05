package modelos;

import java.util.ArrayList;
import java.util.List;

public class GestorDeTareas<T> {
    private Node<T> head;
    private List<T> tareasCompletadas;
    
    public GestorDeTareas() {
        head = null;
        tareasCompletadas = new ArrayList<>();
    }
    
    // Agrega una tarea al final de la lista
    public void agregarTarea(T tarea) {
        Node<T> newNode = new Node<>(tarea);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    
    // Elimina una tarea si existe
    public boolean eliminarTarea(T tarea) {
        if (head == null) return false;
        
        if (head.data.equals(tarea)) {
            head = head.next;
            return true;
        }
        
        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(tarea)) {
            current = current.next;
        }
        
        if (current.next != null) {
            current.next = current.next.next;
            return true;
        }
        
        return false;
    }
    
    // Busca una tarea
    public boolean contieneTarea(T tarea) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(tarea)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    // Imprime todas las tareas
    public void imprimirTareas() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
    
    // Cuenta el total de tareas
    public int contarTareas() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    // Obtiene la tarea más prioritaria (solo para objetos Tarea)
    @SuppressWarnings("unchecked")
    public T obtenerTareaMasPrioritaria() {
        if (head == null) return null;
        
        T maxPriorityTask = head.data;
        int maxPriority = Integer.MIN_VALUE;
        
        Node<T> current = head;
        while (current != null) {
            if (current.data instanceof Tarea) {
                Tarea t = (Tarea) current.data;
                if (t.getPrioridad() > maxPriority) {
                    maxPriority = t.getPrioridad();
                    maxPriorityTask = current.data;
                }
            }
            current = current.next;
        }
        
        return maxPriorityTask;
    }
    
    // Invierte la lista enlazada
    public void invertirTareas() {
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next = null;
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        head = prev;
    }
    
    // Transfiere una tarea a la lista de completadas
    public void completarTarea(T tarea) {
        if (eliminarTarea(tarea)) {
            tareasCompletadas.add(tarea);
        }
    }
    
    // Muestra ambas listas (pendientes y completadas)
    public void mostrarAmbasListas() {
        System.out.println("Tareas Pendientes:");
        imprimirTareas();
        
        System.out.println("\nTareas Completadas:");
        for (T tarea : tareasCompletadas) {
            System.out.println(tarea);
        }
    }
}