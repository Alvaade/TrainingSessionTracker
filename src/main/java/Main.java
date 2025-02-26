import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();

        System.out.println("Welcome to the training tracker!");
        do {
            System.out.println("\nEnter the duration of the training session in minutes:");
            long duration = Long.parseLong(scanner.nextLine());
            System.out.println("Enter the date of the training session:");
            String date = scanner.nextLine();
            tracker.addSession(new Session(duration, date));
            System.out.println("Your total training time is " + tracker.getTrainingTime() + " minutes.");
            if (tracker.graduationEligibility()) {
                System.out.println("Congratulations! You are eligible for graduation!");
            }
            System.out.println("\nDo you want to add another session? (yes/no)");
        } while (scanner.nextLine().equals("yes"));
        System.out.println("\nExiting the program...");
    }
}
