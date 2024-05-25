public class Booking {
    private Flight flight;
    private User user;

    public Booking(Flight flight, User user) {
        this.flight = flight;
        this.user = user;
    }

    public Flight getFlight() {
        return flight;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "flight=" + flight +
                ", user=" + user.getUsername() +
                '}';
    }
}
