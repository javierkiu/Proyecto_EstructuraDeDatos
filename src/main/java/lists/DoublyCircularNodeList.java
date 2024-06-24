/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lists;

/**
 *
 * @author JAVIER
 */
public class DoublyCircularNodeList<E> {
    private E content;
    private DoublyCircularNodeList next;
    private DoublyCircularNodeList previous;

    public DoublyCircularNodeList(E content) {
        this.content = content;
        this.next = this;
        this.previous = this;
    }

    
    
    public E getcontent() {
        return content;
    }

    public void setcontent(E content) {
        this.content = content;
    }

    public DoublyCircularNodeList getNext() {
        return next;
    }

    public void setNext(DoublyCircularNodeList next) {
        this.next = next;
    }

    public DoublyCircularNodeList getPrevious() {
        return previous;
    }

    public void setPrevious(DoublyCircularNodeList previous) {
        this.previous = previous;
    }

    

    
}
