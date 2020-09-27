import java.util.Scanner;

class Stack {
    public class Node {
        int value = 0;
        Node next;
    }

        private Node head;

    public void push(int y) {
        Node x = new Node();
        x.value = y;
        x.next = head;
        head = x;
    }

    public int pop() {
        Node x = head;
        head = (head.next != null) ? head.next : null;
        return x.value;
    }

    public boolean isEmpty() {
        return head == null;
    }
}

public class normalPolishNotation {
    public static void main(String args[]) {
        Stack stack = new Stack();
        Scanner input = new Scanner(System.in);
        String in = input.nextLine();
        String[] expression = in.split(" ");

        for (int i = expression.length - 1; i >= 0; i--) {
            String thing = expression[i];
            switch (thing) {
            case "+":
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a + b);
                break;

            case "-":
                int c = stack.pop();
                int d = stack.pop();
                stack.push(c - d);
                break;

            case "x":
                int e = stack.pop();
                int f = stack.pop();
                stack.push(e * f);
                break;

            default:
                stack.push(Integer.parseInt(thing));
            }
        }
            
            System.out.println(stack.pop());
        
        }
    }
