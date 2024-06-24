/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lists;

import java.util.Iterator;

/**
 *
 * @author JAVIER
 */
public class DoublyCircularLinkedList<E> implements List<E>{
    
    private DoublyCircularNodeList last;

    public DoublyCircularLinkedList() {
        this.last = null;
    }

    @Override
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

    @Override
    public boolean addFirst(E e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        if(isEmpty()) return 0;
        int n = 0;
        DoublyCircularNodeList nd = last;
        do{
            n+=1;
            nd= nd.getNext();
        }while(nd != last);
        return n;
    }

    @Override
    public boolean isEmpty() {
        return last == null;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<E> findIntersection(List<E> another) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    public DoublyCircularNodeList getLast() {
        return last;
    }
    
    
}
