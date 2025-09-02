import java.util.Scanner;

interface Stack<T> {
    void push(T item);
    T pop();
    T peek();
    boolean isEmpty();
    int size();
}


class ArrayStack<T> implements Stack<T> {
    private Object[] arr;
    private int top;
    private int capacity;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        arr = new Object[capacity];
        top = -1;
    }

    
    public void push(T item) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow!");
            return;
        }
        arr[++top] = item;
    }

    
    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow!");
            return null;
        }
        return (T) arr[top--];
    }

    public T peek() {
        if (isEmpty()) return null;
        return (T) arr[top];
    }


    public boolean isEmpty() {
        return top == -1;
    }


    public int size() {
        return top + 1;
    }
}

class TextEditor {
    private StringBuilder text;
    private Stack<String> history;

    public TextEditor(Stack<String> stack) {
        text = new StringBuilder();
        history = stack;
    }

    public void type(String newText) {
        history.push(text.toString()); // Save current state
        text.append(newText);
    }

    public void delete(int count) {
        if (count > text.length()) count = text.length();
        history.push(text.toString()); // Save current state
        text.delete(text.length() - count, text.length());
    }

    public void undo() {
        if (!history.isEmpty()) {
            text = new StringBuilder(history.pop());
        } else {
            System.out.println("Nothing to undo!");
        }
    }

    public void display() {
        System.out.println("Current Text: " + text.toString());
    }
}

public class StaAD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditor editor = new TextEditor(new ArrayStack<>(100));

        while (true) {
            System.out.println("\n--- Text Editor Menu ---");
            System.out.println("1. Type Text");
            System.out.println("2. Delete Text");
            System.out.println("3. Undo");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter text to type: ");
                    String text = sc.nextLine();
                    editor.type(text);
                    break;
                case 2:
                    System.out.print("Enter number of characters to delete: ");
                    int count = sc.nextInt();
                    editor.delete(count);
                    break;
                case 3:
                    editor.undo();
                    break;
                case 4:
                    editor.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
