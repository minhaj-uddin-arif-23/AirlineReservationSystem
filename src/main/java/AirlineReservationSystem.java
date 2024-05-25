import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirlineReservationSystem {
    private List<Flight> flights;
    private List<Booking> bookings;
    private List<User> users;
    private User loggedInUser;

    public AirlineReservationSystem() {
        this.flights = new ArrayList<>();
        this.bookings = new ArrayList<>();
        this.users = new ArrayList<>();
        this.loggedInUser = null;
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void makeBooking(Booking booking) {
        bookings.add(booking);
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                loggedInUser = user;
                return user;
            }
        }
        return null;
    }

    public void logout() {
        loggedInUser = null;
    }

    public static void main(String[] args) {
        AirlineReservationSystem system = new AirlineReservationSystem();

        Flight flight1 = new Flight("A001", "Flight 101", "Dhaka", "2024-06-01", "10:00 AM", 500.0, 150);
        Flight flight2 = new Flight("B002", "Flight 202", "Chicago", "2024-06-02", "2:00 PM", 300.0, 100);

        system.addFlight(flight1);
        system.addFlight(flight2);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (system.loggedInUser == null) {
                System.out.println("1. Login");
                System.out.println("2. Register");
                System.out.println("3. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Enter Username:");
                        String username = scanner.nextLine();
                        System.out.println("Enter Password:");
                        String password = scanner.nextLine();
                        User user = system.login(username, password);
                        if (user != null) {
                            System.out.println("Login Successful. Welcome " + user.getUsername());
                        } else {
                            System.out.println("Invalid Credentials.");
                        }
                        break;
                    case 2:
                        System.out.println("Enter New Username:");
                        String newUsername = scanner.nextLine();
                        System.out.println("Enter New Password:");
                        String newPassword = scanner.nextLine();
                        System.out.println("Enter Gender:");
                        String gender = scanner.nextLine();
                        System.out.println("Enter Address:");
                        String address = scanner.nextLine();
                        System.out.println("Enter NID:");
                        String nid = scanner.nextLine();
                        System.out.println("Enter Region:");
                        String region = scanner.nextLine();
                        User newUser = new User(newUsername, newPassword, gender, address, nid, region);
                        system.addUser(newUser);
                        System.out.println("Registration Successful. Please Login.");
                        break;
                    case 3:
                        System.exit(0);
                }
            } else {
                System.out.println("1. Add Flight");
                System.out.println("2. View Flights");
                System.out.println("3. Book a Flight");
                System.out.println("4. View Bookings");
                System.out.println("5. Cancel Booking");
                System.out.println("6. Make Payment");
                System.out.println("7. Logout");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Enter Flight Number:");
                        String flightNumber = scanner.nextLine();
                        System.out.println("Enter Flight Name:");
                        String flightName = scanner.nextLine();
                        System.out.println("Enter Source:");
                        String source = scanner.nextLine();
                        System.out.println("Enter Departure Date (YYYY-MM-DD):");
                        String departureDate = scanner.nextLine();
                        System.out.println("Enter Departure Time:");
                        String departureTime = scanner.nextLine();
                        System.out.println("Enter Flight Price:");
                        double flightPrice = scanner.nextDouble();
                        System.out.println("Enter Capacity:");
                        int capacity = scanner.nextInt();
                        scanner.nextLine();
                        Flight newFlight = new Flight(flightNumber, flightName, source, departureDate, departureTime, flightPrice, capacity);
                        system.addFlight(newFlight);
                        System.out.println("Flight Added Successfully.");
                        break;
                    case 2:
                        System.out.println("Available Flights:");
                        for (Flight flight : system.getFlights()) {
                            System.out.println(flight);
                        }
                        break;
                    case 3:
                        System.out.println("Enter Flight Number:");
                        String flightNum = scanner.nextLine();
                        Flight selectedFlight = null;
                        for (Flight flight : system.getFlights()) {
                            if (flight.getFlightNumber().equals(flightNum)) {
                                selectedFlight = flight;
                                break;
                            }
                        }
                        if (selectedFlight == null) {
                            System.out.println("Flight not found.");
                            break;
                        }
                        Booking booking = new Booking(selectedFlight, system.loggedInUser);
                        system.makeBooking(booking);
                        System.out.println("Booking Successful.");
                        break;
                    case 4:
                        System.out.println("Your Bookings:");
                        for (Booking b : system.getBookings()) {
                            if (b.getUser().equals(system.loggedInUser)) {
                                System.out.println(b);
                            }
                        }
                        break;
                    case 5:
                        System.out.println("Enter Flight Number to Cancel Booking:");
                        String cancelFlightNum = scanner.nextLine();
                        Booking bookingToCancel = null;
                        for (Booking b : system.getBookings()) {
                            if (b.getFlight().getFlightNumber().equals(cancelFlightNum) && b.getUser().equals(system.loggedInUser)) {
                                bookingToCancel = b;
                                break;
                            }
                        }
                        if (bookingToCancel != null) {
                            system.getBookings().remove(bookingToCancel);
                            System.out.println("Booking Cancelled Successfully.");
                        } else {
                            System.out.println("Booking Not Found.");
                        }
                        break;
                    case 6:
                        System.out.println("Enter Amount to Pay:");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();
                        Payment payment = new Payment(system.loggedInUser.getUsername() + System.currentTimeMillis(), amount);
                        System.out.println("Payment Successful. Details: " + payment);
                        break;
                    case 7:
                        system.logout();
                        System.out.println("Logged Out Successfully.");
                        break;
                }
            }
        }
    }
}
