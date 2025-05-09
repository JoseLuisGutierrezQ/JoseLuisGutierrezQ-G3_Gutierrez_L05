package principal;

import modelos.*;

public class main {
    public static void main(String[] args) {
        // 1. Crear una instancia de GestorDeTareas<T>
        GestorDeTareas<Tarea> gestor = new GestorDeTareas<>();
        
        // 2. Agregar tareas
        gestor.agregarTarea(new Tarea("Hacer informe", 2));
        gestor.agregarTarea(new Tarea("Revisar código", 3));
        gestor.agregarTarea(new Tarea("Preparar presentación", 1));
        
        // 3. Eliminar alguna
        Tarea tareaAEliminar = new Tarea("Revisar código", 3);
        gestor.eliminarTarea(tareaAEliminar);
        
        // 4. Imprimir todas las tareas actuales
        System.out.println("Tareas después de eliminar:");
        gestor.imprimirTareas();
        
        // 5. Verificar si cierta tarea existe
        Tarea tareaABuscar = new Tarea("Preparar presentación", 1);
        System.out.println("\n¿Existe la tarea 'Preparar presentación'? " + 
                          gestor.contieneTarea(tareaABuscar));
        
        // 6. Invertir la lista
        gestor.invertirTareas();
        System.out.println("\nTareas después de invertir:");
        gestor.imprimirTareas();
        
        // 7. Transferir una tarea a lista de completadas
        gestor.completarTarea(tareaABuscar);
        
        // 8. Mostrar ambas listas
        System.out.println("\nEstado final:");
        gestor.mostrarAmbasListas();
        
        // Obtener tarea más prioritaria
        System.out.println("\nTarea más prioritaria: " + 
                          gestor.obtenerTareaMasPrioritaria());
    }
}