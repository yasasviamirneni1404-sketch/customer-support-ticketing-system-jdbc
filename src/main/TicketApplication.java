package main;

import dao.TicketDao;
import model.Ticket;

import java.util.Scanner;

public class TicketApplication {

    public static void main(String[] args) {

        TicketDao dao = new TicketDao();
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Create Ticket");
        System.out.println("2. View Tickets");
        System.out.print("Choose option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.print("Customer Name: ");
            String name = scanner.nextLine();

            System.out.print("Issue Description: ");
            String issue = scanner.nextLine();

            System.out.print("Priority: ");
            String priority = scanner.nextLine();

            dao.createTicket(new Ticket(name, issue, priority));

        } else if (choice == 2) {
            dao.getAllTickets().forEach(System.out::println);
        }

        scanner.close();
    }
}
