public class CircularQueue {
 private int[] arr;
 private int front;
 private int rear;
 private int size;
 private int capacity;
 public CircularQueue(int capacity) {
 this.capacity = capacity;
 this.arr = new int[capacity];
 this.front = 0;
 this.rear = -1;
 this.size = 0;
 }
 public boolean isEmpty() {
 return size == 0;
 }
 public boolean isFull() {
 return size == capacity;
 }
 public boolean enqueue(int value) {
 if (isFull()) {
 System.out.println("Queue is full");
 return false;
 }
 rear = (rear + 1) % capacity;
 arr[rear] = value;
 size++;
 return true;
 }
 public Integer dequeue() {
 if (isEmpty()) {
 System.out.println("Queue is empty");
 return null;
 }
 int value = arr[front];
 front = (front + 1) % capacity;
 size--;
 return value;
 }
 public static void main(String[] args) {
 CircularQueue queue = new CircularQueue(5);
 queue.enqueue(10);
 queue.enqueue(20);
 System.out.println(queue.dequeue());
 queue.enqueue(30);
 queue.enqueue(40);
 queue.enqueue(50);
 queue.enqueue(60);
 while (!queue.isEmpty()) {
 System.out.println(queue.dequeue());
 }
 }
}
