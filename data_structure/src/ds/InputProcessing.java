package ds;

import java.util.Scanner;

public class InputProcessing {

    public static void processInput(Executioner executioner) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        System.out.println("==================================================");
        System.out.println("Exit: 99");
        System.out.println("==================================================");
        while (!exit) {
            System.out.print("Enter i: ");
            try {
                int i = scanner.nextInt();
                if (i == 99) exit = true;
                executioner.execute(i);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        scanner.close();
    }
}
