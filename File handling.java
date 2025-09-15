import java.io.*;
import java.util.*;

public class FileHandling {
    static final String FILE_NAME = "students.txt";

    // Write records (overwrite file)
    public static void writeFile(String data) throws Exception {
        FileWriter fw = new FileWriter(FILE_NAME);
        fw.write(data);
        fw.close();
        System.out.println("Data written.");
    }

    // Append records
    public static void appendFile(String data) throws Exception {
        FileWriter fw = new FileWriter(FILE_NAME, true);
        fw.write(data);
        fw.close();
        System.out.println("Data appended.");
    }

    // Read file
    public static void readFile() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
        String line;
        System.out.println("Student Records:");
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

    // Update record (by rewriting whole file)
    public static void updateFile(String studentId, String newData) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            if (line.startsWith(studentId + ",")) {
                lines.add(newData);
            } else {
                lines.add(line);
            }
        }
        br.close();

        FileWriter fw = new FileWriter(FILE_NAME);
        for (String l : lines) {
            fw.write(l + "\n");
        }
        fw.close();
        System.out.println("Record updated.");
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Write Records");
            System.out.println("2. Append Record");
            System.out.println("3. Read Records");
            System.out.println("4. Update Record");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter number of students: ");
                    int n = Integer.parseInt(sc.nextLine());
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < n; i++) {
                        System.out.print("ID: ");
                        String id = sc.nextLine();
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Age: ");
                        String age = sc.nextLine();
                        sb.append(id).append(",").append(name).append(",").append(age).append("\n");
                    }
                    writeFile(sb.toString());
                    break;
                case 2:
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Age: ");
                    String age = sc.nextLine();
                    appendFile(id + "," + name + "," + age + "\n");
                    break;
                case 3:
                    readFile();
                    break;
                case 4:
                    System.out.print("Enter ID to update: ");
                    String updateId = sc.nextLine();
                    System.out.print("New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("New Age: ");
                    String newAge = sc.nextLine();
                    updateFile(updateId, updateId + "," + newName + "," + newAge);
                    break;
                case 5:
                    System.out.println("Bye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
