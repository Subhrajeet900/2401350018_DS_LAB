public class CircularSinglyLinkedList {
 private static class Node {
 int data;
 Node next;
 Node(int data) {
 this.data = data;
 }
 }
 private Node head;
 private Node tail;
 // Insert at head
 public void insertAtHead(int data) {
 Node newNode = new Node(data);
 if (head == null) {
 head = tail = newNode;
 newNode.next = head;
 } else {
 newNode.next = head;
 head = newNode;
 tail.next = head;
 }
 }
 // Insert at tail
 public void insertAtTail(int data) {
 Node newNode = new Node(data);
 if (head == null) {
 head = tail = newNode;
 newNode.next = head;
 } else {
 tail.next = newNode;
 tail = newNode;
 tail.next = head;
 }
 }
 // Delete by value (first occurrence)
 public boolean deleteByValue(int value) {
 if (head == null) return false;
 Node current = head;
 Node prev = tail;
 do {
 if (current.data == value) {
 if (current == head) {
 if (head == tail) {
 head = tail = null;
 } else {
 head = head.next;
 tail.next = head;
 }
 } else if (current == tail) {
 tail = prev;
 tail.next = head;
 } else {
 prev.next = current.next;
 }
 return true;
 }
 prev = current;
 current = current.next;
 } while (current != head);
 return false;
 }
 // Traverse
 public void traverse() {
 if (head == null) {
 System.out.println("List is empty");
 return;
 }
 Node current = head;
 do {
 System.out.print(current.data + " ");
 current = current.next;
 } while (current != head);
 System.out.println();
 }
 public static void main(String[] args) {
 CircularSinglyLinkedList list = new CircularSinglyLinkedList();
 list.insertAtHead(10);
 list.insertAtTail(20);
 list.insertAtTail(30);
 list.traverse();
 list.deleteByValue(20);
 list.traverse();
 }
}
