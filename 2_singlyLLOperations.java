public class SinglyLinkedList {
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
 newNode.next = head;
 head = newNode;
 if (tail == null) {
 tail = newNode;
 }
 }
 // Insert at tail
 public void insertAtTail(int data) {
 Node newNode = new Node(data);
 if (head == null) {
 head = tail = newNode;
 return;
 }
 tail.next = newNode;
 tail = newNode;
 }
 // Delete by value (first occurrence)
 public boolean deleteByValue(int value) {
 if (head == null) return false;
 if (head.data == value) {
 head = head.next;
 if (head == null) tail = null;
 return true;
 }
 Node current = head;
 while (current.next != null && current.next.data != value) {
 current = current.next;
 }
 if (current.next == null) return false;
 if (current.next == tail) {
 tail = current;
 }
 current.next = current.next.next;
 return true;
 }
 // Traverse
 public void traverse() {
 Node current = head;
 while (current != null) {
 System.out.print(current.data + " ");
 current = current.next;
 }
 System.out.println();
 }
 public static void main(String[] args) {
 SinglyLinkedList list = new SinglyLinkedList();
 list.insertAtHead(10);
 list.insertAtTail(20);
 list.insertAtTail(30);
 list.traverse();
 list.deleteByValue(20);
 list.traverse();
 }
}
