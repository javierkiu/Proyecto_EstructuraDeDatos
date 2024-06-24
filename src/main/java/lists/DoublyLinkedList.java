package lists;

import java.util.Comparator;
import java.util.Iterator;

/**
 * @author JAVIER
 * Lista doblemente enlazada
 */
public class DoublyLinkedList<E> implements List<E> {
    
    private DoublyNodeList<E> header;
    private DoublyNodeList<E> last;
    
    public DoublyLinkedList(){
        this.header = null;
        this.last = null;
    }

    public boolean isEmpty(){
        return header == null && last == null;
    }
    
    public int size() {
        if(isEmpty()) return 0;
        int num = 1;
        for (DoublyNodeList node = header; node != last; node = node.getNext()) {
            num+=1;
        }
        
        return num;
    }
    
    public DoublyNodeList<E> getHeader() {
        return header;
    }

    public void setHeader(DoublyNodeList<E> header) {
        this.header = header;
    }

    public DoublyNodeList<E> getLast() {
        return last;
    }

    public void setLast(DoublyNodeList<E> last) {
        this.last = last;
    }
    
    public NodeList<E> getPrevious(NodeList<E> node){
        return null;
    }
//   
//    private void recorrerHaciaAtras(){
//        DoublyNodeList<E> n;
//        for (n = last ; n != header; n = n.getPrevious()){
//        }
//    }
    
    public boolean addFirst(E e)
    {
        if (e != null){
            DoublyNodeList<E> newNode = new DoublyNodeList<>(e);
            newNode.setNext(header);
            header.setPrevious(newNode);
            this.setHeader(newNode);
            return true;
        }
        return false;
    }
    
    public boolean addLast(E e)
    {
        if (e == null){return false;}
        DoublyNodeList<E> newNode = new DoublyNodeList<>(e);
        if(header==null) {
            this.setHeader(newNode);
        }
        else if(last == null){
            this.setLast(newNode);
            last.setPrevious(header);
            header.setNext(last);
        }
        else{
            last.setNext(newNode);
            newNode.setPrevious(last);
            this.setLast(newNode);
        }
        return true;
    }
    
    public boolean addAt(E e, int pos)
    {
        if (e != null && pos >= 0 && pos < this.size()) {
            DoublyNodeList<E> newNode = new DoublyNodeList<>(e);
            
            DoublyNodeList<E> p = header;
            
            for(int i=0; i < pos ; i ++){
                p = p.getNext();
            }
            newNode.setNext(p.getNext());
            p.setNext(newNode);
            
            newNode.setPrevious(p);
            newNode.getNext().setPrevious(newNode);
           
        }
        return false;
    }

    @Override
    public String toString() {
        if(isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        DoublyNodeList node = header;
        
        while(node!=null){
            sb.append(node.getContent());
            node = node.getNext();
            if (node!=null) {
                sb.append(", ");
            }
        }
        
        return sb.toString();
    }
    
        // ITERATOR
    public Iterator<E> iterator(){
        return new Iterator(){
            DoublyNodeList node = header;
            @Override
            public boolean hasNext() {
                return node!=null ;
            }

            @Override
            public E next() {
                E value = (E) node.getContent();
                node = node.getNext();
                return value;
            }
        };
    }
    
    // FIND
    public E find(Comparator comp, E element){
        for (DoublyNodeList node = header; node!= null; node = node.getNext()) {
            if(comp.compare(element,node.getContent())==0){
                return (E) node.getContent();
            }
        }
        return null;
    }
    
    public DoublyLinkedList<E> findAll(Comparator cmp, E element){
        if(element==null) return null;
        DoublyLinkedList<E> result = new DoublyLinkedList<>();
        for (DoublyNodeList node = header; node!=null; node=node.getNext()) {
            if(cmp.compare(node.getContent(), element)== 0){
                result.addLast(element);
            }
        }
        return result;
    }
    
    
    
//    public E removeElement (int pos){
//        DoublyNodeList<E> p = header;
//        
//        for(int i=0; i < pos; i++){
//            p = p.getNext();
//        }
//        
//        p.getPrevious().setNext(p.getNext());
//        p.getNext().setPrevious(p.getPrevious());
//        
//        p.setNext(null);
//        p.setPrevious(null);
//        
//        return p.getContent();
//        }

    @Override
    public E removeFirst() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E removeLast() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    


}
