public class CircularDoublyLinkedList {
 private static class Node {
 int data;
 Node next;
 Node prev;
 Node(int data) {
 this.data = data;
 }
 }
 private Node head;
 // Insert at head
 public void insertAtHead(int data) {
 Node newNode = new Node(data);
 if (head == null) {
 head = newNode;
 head.next = head.prev = head;
 } else {
 Node tail = head.prev;
 newNode.next = head;
 newNode.prev = tail;
 tail.next = newNode;
 head.prev = newNode;
 head = newNode;
 }
 }
 // Insert at tail
 public void insertAtTail(int data) {
 if (head == null) {
 insertAtHead(data);
 return;
 }
 Node newNode = new Node(data);
 Node tail = head.prev;
 newNode.next = head;
 newNode.prev = tail;
 tail.next = newNode;
 head.prev = newNode;
 }
 // Delete by value (first occurrence)
 public boolean deleteByValue(int value) {
 if (head == null) return false;
 Node current = head;
 do {
 if (current.data == value) {
 if (current.next == current) {
 head = null;
 } else {
 Node prev = current.prev;
 Node next = current.next;
 prev.next = next;
 next.prev = prev;
 if (current == head) {
 head = next;
 }
 }
 return true;
 }
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
 CircularDoublyLinkedList list = new CircularDoublyLinkedList();
 list.insertAtHead(10);
 list.insertAtTail(20);
 list.insertAtTail(30);
 list.traverse();
 list.deleteByValue(20);
 list.traverse();
 }
}
