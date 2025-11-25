public class ArrayStack {
 private int[] arr;
 private int top;
 private int capacity;
 public ArrayStack(int capacity) {
 this.capacity = capacity;
 this.arr = new int[capacity];
 this.top = -1;
 }
 public boolean push(int value) {
 if (top == capacity - 1) {
 System.out.println("Stack overflow");
 return false;
 }
 arr[++top] = value;
 return true;
 }
 public Integer pop() {
 if (top == -1) {
 System.out.println("Stack underflow");
 return null;
 }
 return arr[top--];
 }
 public Integer peek() {
 if (top == -1) {
 System.out.println("Stack is empty");
 return null;
 }
 return arr[top];
 }
 public boolean isEmpty() {
 return top == -1;
 }
 public static void main(String[] args) {
 ArrayStack stack = new ArrayStack(5);
 stack.push(10);
 stack.push(20);
 System.out.println(stack.peek());
 System.out.println(stack.pop());
 System.out.println(stack.pop());
 System.out.println(stack.pop());
 }
}
