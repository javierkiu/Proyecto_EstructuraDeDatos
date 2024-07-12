package lists;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;

/**
 *
 * @author JAVIER
 */
public class ArrayList<E> implements List<E>, Serializable{

    private static final long serialVersionUID = 1L;

    private E[] elements = null; //arreglo de elementos genericos
    private int capacity = 100;
    private int effectiveSize;

    public E[] getElements() {
        return elements;
    }
    
    public ArrayList (){
        elements = (E[])(new Object[capacity]); // SI FUNCIONA con Casting permitido con el arrayList
        effectiveSize = 0;
    }
    
    public boolean contains(E element){
        for (int i = 0; i < effectiveSize; i++) {
            if(elements[i].equals(element)){
                return true;
            }
        }
        return false;
    }
    
    private boolean isFull(){
        return effectiveSize == capacity;
    }
   
    @Override
    public boolean addFirst(E e) {
        
        // no se insertan nulos
        if(e==null){
            return false;
        } else if (isEmpty()){
            elements[0] = e;
            effectiveSize++;
            //elements[effectiveSize ++] = e; //otra forma de hacer las 2 lineas anteriores
            return true;
        } else if (isFull()){
            addCapacity();
        }
        
        for (int i=effectiveSize-1; i >=0; i--){
            elements[i+1]=elements[i]; //bit shifting 

        }
        elements[0] = e;
        effectiveSize++;
        return true;
    }

    @Override
    public boolean addLast(E e) {
       if (e == null) {
            return false;
        }
        if (isFull()) {
            addCapacity();
        }
        elements[effectiveSize] = e;
        effectiveSize++;
        return true;
    }

    @Override
    public E removeFirst() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E removeLast() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int size() {
        return effectiveSize;
    }

    @Override
    public boolean isEmpty() {
        return effectiveSize == 0;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(int index, E element) {
        if (index < 0 || index > effectiveSize) {
            // throw new IndexOutOfBoundsException("Invalid index: " + index);
            return false;
        }
        if (isFull()) {
            addCapacity();
        }
        for (int i = effectiveSize; i > index; i--) {
            elements[i] = elements[i - 1];
            // elements[i+1] = elements[i]; MAL
        }
        elements[index] = element;
        effectiveSize++;
        return true;
    }

    @Override
      public E remove(int indice) {
        if(indice < 0 || indice >= effectiveSize) return null;
        E eliminado = elements[indice];
        // Desplazar elementos
        for (int i = indice; i < size() - 1; i++) {
            elements[i] = elements[i + 1];
        }

        // Ajustar tamaño y último elemento
        elements[--effectiveSize] = null;
        return eliminado;
        
    }

    @Override
    public E get(int index) {
        for (int i = 0; i < effectiveSize; i++) {
            if(i == index) return elements[i];
        }
        return null;
    }

    
    public int getIndex(E elemento) {
        for (int i = 0; i < size(); i++) {
            if (elements[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }
    
    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void addCapacity() {
        E[] tmp = (E[]) new Object[capacity * 2];
        for (int i = 0; i < capacity; i++){
            tmp[i] = elements[i];
        }
        elements = tmp;
        capacity = capacity * 2;
    }
    
    public String toString() {
        StringBuilder s= new StringBuilder();
        s.append("[");
        for (int i=0; i<effectiveSize; i++) {
            s.append(elements[i]);
            if(i < effectiveSize -1){
                s.append(",");
            }
        }
        s.append("]");

        return s.toString();
    }
    
    
        // ITERATOR
    
    public Iterator<E> iterator(){
            Iterator<E> it=new Iterator<E>() {
                int cursor = 0;
                @Override
                public boolean hasNext() {
                    return cursor < effectiveSize;
                }

                @Override
                public E next() {
                    E e=elements[cursor];
                    cursor++;
                    return e;
                }
            };
        return it;   
    }


    // FIND 
    public E find(Comparator comp, E elemento){
        for (int i = 0; i < effectiveSize; i++) {
            if(comp.compare(elemento, elements[i])==0){
                return elements[i];
            }
        }
        return null;
    }
    
    //findAll
    public ArrayList<E> findAll(Comparator cmp, E element){
        if(element==null) return null;
        ArrayList<E> result = new ArrayList<>();
        for (int i = 0; i < this.effectiveSize; i++) {
            if(cmp.compare(element, elements[i])==0){
                result.addLast(elements[i]);
            }
        }
        return result;
    }
    
    @Override
    public List<E> findIntersection(List<E> another) {
        return null;
    }
    
    
    
}