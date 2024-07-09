/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lists;

import java.io.Serializable;

/**
 *
 * @author JAVIER
 */
public class DoublyCircularLinkedList<E> implements Serializable {
    
    private DoublyCircularNodeList<E> last;

    public DoublyCircularLinkedList() {
        this.last = null;
    }

    public boolean addLast(E e) {
        if(e == null) return false;
        DoublyCircularNodeList nd = new DoublyCircularNodeList(e);
        if(isEmpty()) {
            last = nd; 
        }
        else{
            last.getNext().setPrevious(nd);
            nd.setNext(last.getNext());
            last.setNext(nd);
            nd.setPrevious(last);
            last = nd;
        }
        return true;          
    }

    public boolean removeElement(E e){
        if(isEmpty()) return false;
        DoublyCircularNodeList<E> nd = last.getNext();
        do{
            if(nd.getcontent().equals(e)){
                nd.getPrevious().setNext(nd.getNext());
                nd.getNext().setPrevious(nd.getPrevious());
                return true;
            }
            nd = nd.getNext();
        }while(nd!=last.getNext());
        return false;
    }
    
    public E removeLast() {
        if(isEmpty()) return null;
        
        E element = last.getcontent();
        last.getPrevious().setNext(last.getNext());
        last.getNext().setPrevious(last.getPrevious());
        return element;
    }

    public int size() {
        if(isEmpty()) return 0;
        int n = 0;
        DoublyCircularNodeList<E> nd = last;
        do{
            n+=1;
            nd= nd.getNext();
        }while(nd != last);
        return n;
    }

    public boolean isEmpty() {
        return last == null;
    }

    @Override
    public String toString() {
        if(isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder();
        DoublyCircularNodeList nd = last.getNext();
        sb.append("[");
        do{
            sb.append(nd.getcontent());
            nd = nd.getNext();
            if(nd!= last.getNext()) sb.append(", ");
        }while(nd!= last.getNext());
        
        sb.append("]");
        return sb.toString();
    }

    public DoublyCircularNodeList<E> getLast() {
        return last;
    }
    
    public Iterator<E> iterator()
    {
        Iterator<E> it = new Iterator<E>()
        {
            DoublyCircularNodeList<E> cursor = getLast();
            
            @Override
            public boolean hasNext()
            {
                return true;
            }
            
            @Override
            public E next() {
                //E e = cursor.getcontent();
                cursor = cursor.getNext();
                return cursor.getcontent();
            }
            
            public E back() 
            {
                //E e = cursor.getcontent();
                cursor = cursor.getPrevious();
                return cursor.getcontent();
            }
        };
        
        return it;
    }
}
