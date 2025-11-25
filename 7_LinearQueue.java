public class LinearQueue {
 private int[] arr;
 private int front;
 private int rear;
 private int capacity;
 public LinearQueue(int capacity) {
 this.capacity = capacity;
 this.arr = new int[capacity];
 this.front = 0;
 this.rear = -1;
 }
 public boolean isEmpty() {
 return front > rear;
 }
 public boolean isFull() {
 return rear == capacity - 1;
 }
 public boolean enqueue(int value) {
 if (isFull()) {
 System.out.println("Queue is full");
 return false;
 }
 arr[++rear] = value;
 return true;
 }
 public Integer dequeue() {
 if (isEmpty()) {
 System.out.println("Queue is empty");
 return null;
 }
 return arr[front++];
 }
 public static void main(String[] args) {
 LinearQueue queue = new LinearQueue(5);
 queue.enqueue(10);
 queue.enqueue(20);
 System.out.println(queue.dequeue());
 System.out.println(queue.dequeue());
 System.out.println(queue.dequeue());
 }
}
