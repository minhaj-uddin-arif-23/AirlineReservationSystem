public class Flight {
    private String flightNumber;
    private String flightName;
    private String source;
    private String departureDate;
    private String departureTime;
    private double flightPrice;
    private int capacity;

    public Flight(String flightNumber, String flightName, String source, String departureDate, String departureTime, double flightPrice, int capacity) {
        this.flightNumber = flightNumber;
        this.flightName = flightName;
        this.source = source;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.flightPrice = flightPrice;
        this.capacity = capacity;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getFlightName() {
        return flightName;
    }

    public String getSource() {
        return source;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public double getFlightPrice() {
        return flightPrice;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber ='" + flightNumber + '\'' +
                ", flightName ='" + flightName + '\'' +
                ", source='" + source + '\'' +
                ", departureDate ='" + departureDate + '\'' +
                ", departureTime ='" + departureTime + '\'' +
                ", flightPrice =" + flightPrice +
                ", capacity =" + capacity +
                '}';
    }
}
