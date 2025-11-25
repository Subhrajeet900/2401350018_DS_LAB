import java.util.Stack;
public class InfixToPostfix {
 private static int precedence(char ch) {
 switch (ch) {
 case '+':
 case '-':
 return 1;
 case '*':
 case '/':
 return 2;
 case '^':
 return 3;
 default:
 return -1;
 }
 }
 public static String infixToPostfix(String expression) {
 StringBuilder result = new StringBuilder();
 Stack<Character> stack = new Stack<>();
 for (int i = 0; i < expression.length(); i++) {
 char ch = expression.charAt(i);
 if (Character.isLetterOrDigit(ch)) {
 result.append(ch);
 } else if (ch == '(') {
 stack.push(ch);
 } else if (ch == ')') {
 while (!stack.isEmpty() && stack.peek() != '(') {
 result.append(stack.pop());
 }
 if (!stack.isEmpty() && stack.peek() == '(') {
 stack.pop();
 }
 } else { // operator
 while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
 if (stack.peek() == '(') break;
 result.append(stack.pop());
 }
 stack.push(ch);
 }
 }
 while (!stack.isEmpty()) {
 if (stack.peek() == '(') stack.pop();
 else result.append(stack.pop());
 }
 return result.toString();
 }
 public static void main(String[] args) {
 String infix = "A+(B*C-(D/E^F)*G)*H";
 System.out.println(infixToPostfix(infix));
 }
}
