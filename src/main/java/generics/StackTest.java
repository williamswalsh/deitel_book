package generics;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<Number> stack = new Stack<>();
        stack.push(13L);
        stack.push(1.2345);
        stack.push(12F);
        stack.push(456789);

        while (!stack.isEmpty()) {
            Number element = stack.pop();
            System.out.printf("Popped %6s off stack.\n", element);
        }
    }
}
