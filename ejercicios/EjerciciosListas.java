package ejercicios;

import modelos.Nodo;

public class EjerciciosListas {
    
    // 1. Buscar un elemento genérico en una lista
    public static <T> boolean buscarElemento(Nodo<T> cabeza, T valor) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            if (actual.dato.equals(valor)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }
    
    // 2. Invertir una lista genérica
    public static <T> Nodo<T> invertirLista(Nodo<T> cabeza) {
        Nodo<T> anterior = null;
        Nodo<T> actual = cabeza;
        Nodo<T> siguiente = null;
        
        while (actual != null) {
            siguiente = actual.siguiente;
            actual.siguiente = anterior;
            anterior = actual;
            actual = siguiente;
        }
        
        return anterior;
    }
    
    // 3. Insertar un nodo al final
    public static <T> void insertarAlFinal(Nodo<T> cabeza, T valor) {
        Nodo<T> nuevoNodo = new Nodo<>(valor);
        
        if (cabeza == null) {
            cabeza = nuevoNodo;
            return;
        }
        
        Nodo<T> actual = cabeza;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        actual.siguiente = nuevoNodo;
    }
    
    // 4. Contar los nodos
    public static <T> int contarNodos(Nodo<T> cabeza) {
        int contador = 0;
        Nodo<T> actual = cabeza;
        
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        
        return contador;
    }
    
    // 5. Comparar dos listas
    public static <T> boolean sonIguales(Nodo<T> lista1, Nodo<T> lista2) {
        Nodo<T> actual1 = lista1;
        Nodo<T> actual2 = lista2;
        
        while (actual1 != null && actual2 != null) {
            if (!actual1.dato.equals(actual2.dato)) {
                return false;
            }
            actual1 = actual1.siguiente;
            actual2 = actual2.siguiente;
        }
        
        return actual1 == null && actual2 == null;
    }
    
    // 6. Concatenar dos listas
    public static <T> Nodo<T> concatenarListas(Nodo<T> lista1, Nodo<T> lista2) {
        if (lista1 == null) return lista2;
        if (lista2 == null) return lista1;
        
        Nodo<T> actual = lista1;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        actual.siguiente = lista2;
        
        return lista1;
    }
}