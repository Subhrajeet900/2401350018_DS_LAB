public class ArrayOperations {
 private int[] arr;
 private int size;
 private int capacity;
 public ArrayOperations(int capacity) {
 this.capacity = capacity;
 this.arr = new int[capacity];
 this.size = 0;
 }
 // Insert at the end
 public boolean insert(int value) {
 if (size == capacity) {
 return false; // array is full
 }
 arr[size++] = value;
 return true;
 }
 // Insert at a specific index (0 <= index <= size)
 public boolean insertAt(int index, int value) {
 if (size == capacity || index < 0 || index > size) {
 return false;
 }
 for (int i = size - 1; i >= index; i--) {
 arr[i + 1] = arr[i];
 }
 arr[index] = value;
 size++;
 return true;
 }
 // Delete at a specific index (0 <= index < size)
 public boolean deleteAt(int index) {
 if (index < 0 || index >= size) {
 return false;
 }
 for (int i = index; i < size - 1; i++) {
 arr[i] = arr[i + 1];
 }
 size--;
 return true;
 }
 // Traverse and print elements
 public void traverse() {
 for (int i = 0; i < size; i++) {
 System.out.print(arr[i] + " ");
 }
 System.out.println();
 }
 public static void main(String[] args) {
 ArrayOperations ao = new ArrayOperations(10);
 ao.insert(10);
 ao.insert(20);
 ao.insert(30);
 ao.traverse();
 ao.insertAt(1, 15);
 ao.traverse();
 ao.deleteAt(2);
 ao.traverse();
