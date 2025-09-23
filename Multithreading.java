import java.util.Scanner;

class OddThread extends Thread {
    private int n;

    public OddThread(int n) {
        this.n = n;
    }

    
    public void run() {
        System.out.println("Odd numbers from 1 to " + n + ":");
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                System.out.println("T1 (Odd): " + i);
            }
        }
    }
}

class EvenThread extends Thread {
    private int n;
    public EvenThread(int n) {
        this.n = n;
    }

   
    public void run() {
        System.out.println("Even numbers from 1 to " + n + ":");
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                System.out.println("T2 (Even): " + i);
            }
        }
    }
}
public class MultiThreading {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt(); 

        OddThread t1 = new OddThread(n);
        EvenThread t2 = new EvenThread(n);
        t1.start(); 
        t2.start(); 

        sc.close(); 
    }
}
