package principal;

import ejercicios.EjerciciosListas;
import modelos.Nodo;

public class PruebasEjercicios {
    public static void main(String[] args) {
        // Crear lista de prueba: 1 -> 2 -> 3
        Nodo<Integer> lista = new Nodo<>(1);
        lista.siguiente = new Nodo<>(2);
        lista.siguiente.siguiente = new Nodo<>(3);
        
        // 1. Probar buscarElemento
        System.out.println("¿Está el 2 en la lista? " + 
            EjerciciosListas.buscarElemento(lista, 2)); // true
        System.out.println("¿Está el 5 en la lista? " + 
            EjerciciosListas.buscarElemento(lista, 5)); // false
        
        // 2. Probar contarNodos
        System.out.println("Número de nodos: " + 
            EjerciciosListas.contarNodos(lista)); // 3
            
        // 3. Probar insertarAlFinal
        EjerciciosListas.insertarAlFinal(lista, 4);
        System.out.println("Lista después de insertar 4 al final:");
        imprimirLista(lista); // 1 2 3 4
        
        // 4. Probar invertirLista
        Nodo<Integer> invertida = EjerciciosListas.invertirLista(lista);
        System.out.println("Lista invertida:");
        imprimirLista(invertida); // 4 3 2 1
        
        // 5. Probar sonIguales
        Nodo<Integer> listaA = new Nodo<>(1);
        listaA.siguiente = new Nodo<>(2);
        
        Nodo<Integer> listaB = new Nodo<>(1);
        listaB.siguiente = new Nodo<>(2);
        
        System.out.println("¿Las listas son iguales? " + 
            EjerciciosListas.sonIguales(listaA, listaB)); // true
            
        // 6. Probar concatenarListas
        Nodo<Integer> listaC = new Nodo<>(3);
        listaC.siguiente = new Nodo<>(4);
        
        Nodo<Integer> concatenada = EjerciciosListas.concatenarListas(listaA, listaC);
        System.out.println("Listas concatenadas:");
        imprimirLista(concatenada); // 1 2 3 4
    }
    
    // Método auxiliar para imprimir listas
    public static <T> void imprimirLista(Nodo<T> cabeza) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
}