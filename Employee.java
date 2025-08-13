import java.util.Scanner;

public class Employee {
    String Emp_name, Emp_id, Address, Mail_id;
    long Mobile_no;
    double BP, DA, HRA, PF, StaffClub, Gross, Net;

    public Employee(String name, String id, String address, String mail, long mobile, double bp) {
        Emp_name = name;
        Emp_id = id;
        Address = address;
        Mail_id = mail;
        Mobile_no = mobile;
        BP = bp;
    }

    void calculateSalary(double daPercent, double hraPercent, double pfPercent, double staffPercent) {
        DA = BP * daPercent / 100;
        HRA = BP * hraPercent / 100;
        PF = BP * pfPercent / 100;
        StaffClub = BP * staffPercent / 100;
        Gross = BP + DA + HRA;
        Net = Gross - (PF + StaffClub);
    }

    void displayPayslip() {
        System.out.println("\n==============================");
        System.out.println(" PAY SLIP");
        System.out.println("==============================");
        System.out.println("Employee ID : " + Emp_id);
        System.out.println("Name : " + Emp_name);
        System.out.println("Address : " + Address);
        System.out.println("Mail ID : " + Mail_id);
        System.out.println("Mobile Number : " + Mobile_no);
        System.out.println("------------------------------");
        System.out.println("Basic Pay (BP) : " + BP);
        System.out.println("DA : " + DA);
        System.out.println("HRA : " + HRA);
        System.out.println("PF : " + PF);
        System.out.println("Staff Club Fund : " + StaffClub);
        System.out.println("Gross Salary : " + Gross);
        System.out.println("Net Salary : " + Net);
        System.out.println("==============================");
    }

    // Subclasses for each designation
    static class Programmer extends Employee {
        Programmer(String name, String id, String address, String mail, long mobile, double bp) {
            super(name, id, address, mail, mobile, bp);
            calculateSalary(97, 10, 12, 1);
        }
    }

    static class AssistantProfessor extends Employee {
        AssistantProfessor(String name, String id, String address, String mail, long mobile, double bp) {
            super(name, id, address, mail, mobile, bp);
            calculateSalary(110, 20, 12, 5);
        }
    }

    static class AssociateProfessor extends Employee {
        AssociateProfessor(String name, String id, String address, String mail, long mobile, double bp) {
            super(name, id, address, mail, mobile, bp);
            calculateSalary(130, 30, 12, 10);
        }
    }

    static class Professor extends Employee {
        Professor(String name, String id, String address, String mail, long mobile, double bp) {
            super(name, id, address, mail, mobile, bp);
            calculateSalary(140, 40, 12, 15);
        }
    }

    // Main method inside Employee class
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Address: ");
        String address = sc.nextLine();
        System.out.print("Enter Mail ID: ");
        String mail = sc.nextLine();
        System.out.print("Enter Mobile Number: ");
        long mobile = sc.nextLong();

        System.out.println("\nSelect Designation:");
        System.out.println("1. Programmer");
        System.out.println("2. Assistant Professor");
        System.out.println("3. Associate Professor");
        System.out.println("4. Professor");
        System.out.print("Choice: ");
        int choice = sc.nextInt();

        System.out.print("Enter Basic Pay: ");
        double bp = sc.nextDouble();

        Employee emp = null;
        switch (choice) {
            case 1:
                emp = new Programmer(name, id, address, mail, mobile, bp);
                break;
            case 2:
                emp = new AssistantProfessor(name, id, address, mail, mobile, bp);
                break;
            case 3:
                emp = new AssociateProfessor(name, id, address, mail, mobile, bp);
                break;
            case 4:
                emp = new Professor(name, id, address, mail, mobile, bp);
                break;
            default:
                System.out.println("Invalid choice!");
                System.exit(0);
        }

        emp.displayPayslip();
        sc.close();
}
}
