import java.util.*;
/*
 * public class LinkedList
 * {
 * public Node head;
 * public Node tail;
 * 
 * public LinkedList()
 * {
 * head = null;
 * tail = null;
 * }
 * 
 * public void addInTail(Node item) {
 * if (this.head == null)
 * this.head = item;
 * else
 * this.tail.next = item;
 * this.tail = item;
 * }
 * 
 * public Node find(int value) {
 * Node node = this.head;
 * while (node != null) {
 * if (node.value == value)
 * return node;
 * node = node.next;
 * }
 * return null;
 * }
 * 
 * public ArrayList<Node> findAll(int _value) {
 * ArrayList<Node> nodes = new ArrayList<Node>();
 * Node currentNode = this.head;
 * while(currentNode != null) {
 * if (currentNode.value == _value) {
 * nodes.add(new Node(currentNode.value));
 * }
 * currentNode = currentNode.next;
 * }
 * return nodes;
 * }
 * 
 * public boolean remove(int _value)
 * {
 * if (this.head == null) return false;
 * 
 * if (this.head.value == _value) {
 * this.head = this.head.next;
 * if (this.head == null) {
 * this.tail = null;
 * }
 * return true;
 * }
 * Node currentNode = this.head;
 * while(currentNode.next != null && currentNode.next.value != _value) {
 * currentNode = currentNode.next;
 * }
 * 
 * if (currentNode.next != null && currentNode.next.value == _value) {
 * currentNode.next = currentNode.next.next;
 * if (currentNode.next == null) {
 * this.tail = currentNode;
 * }
 * }
 * 
 * return true;
 * }
 * 
 * public void removeAll(int _value)
 * {
 * while (head != null && head.value == _value) {
 * head = head.next;
 * }
 * 
 * if (head == null) {
 * tail = null;
 * return;
 * }
 * 
 * Node current = head;
 * while (current.next != null) {
 * if (current.next.value == _value) {
 * current.next = current.next.next;
 * 
 * if (current.next == null) {
 * tail = current;
 * }
 * } else {
 * current = current.next;
 * }
 * }
 * }
 * 
 * public void clear()
 * {
 * this.head = null;
 * this.tail = null;
 * }
 * 
 * public int count()
 * {
 * Node currentNode = this.head;
 * int count = 0;
 * while(currentNode != null) {
 * count++;
 * currentNode = currentNode.next;
 * }
 * return count;
 * }
 * 
 * public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
 * {
 * if (this.head == null || _nodeAfter == null) {
 * _nodeToInsert.next = head;
 * this.head = _nodeToInsert;
 * if (this.tail == null) {
 * this.tail = _nodeToInsert;
 * }
 * return;
 * }
 * Node currentNode = head;
 * while (currentNode != null && !currentNode.equals(_nodeAfter)) {
 * currentNode = currentNode.next;
 * }
 * if (currentNode == null) {
 * return;
 * }
 * _nodeToInsert.next = currentNode.next;
 * currentNode.next = _nodeToInsert;
 * if (currentNode.equals(tail)) {
 * tail = _nodeToInsert;
 * }
 * }
 * 
 * public static LinkedList sumLinkedList(LinkedList firstList, LinkedList
 * secondList) {
 * LinkedList result = new LinkedList();
 * if (firstList.count() != secondList.count()) {
 * return result;
 * }
 * Node firstListNode = firstList.head;
 * Node secondListNode = secondList.head;
 * while (firstListNode != null) {
 * result.addInTail(new Node(firstListNode.value + secondListNode.value));
 * firstListNode = firstListNode.next;
 * secondListNode = secondListNode.next;
 * }
 * return result;
 * }
 * 
 * }
 * 
 * class Node
 * {
 * public int value;
 * public Node next;
 * public Node(int _value)
 * {
 * value = _value;
 * next = null;
 * }
 * }
 * 
 */