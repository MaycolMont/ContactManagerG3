/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util.DataStructures;

/**
 *
 * @author elmay
 */
public class DoubleLinkedNode<T> {
    T data;
    DoubleLinkedNode<T> next;
    DoubleLinkedNode<T> prev;

    DoubleLinkedNode(T data) {
        this.data = data;
        next = this;
        prev = this;
    }
}
