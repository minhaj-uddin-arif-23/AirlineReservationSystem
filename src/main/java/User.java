public class User {
    private String username;
    private String password;
    private String gender;
    private String address;
    private String nid;
    private String region;

    public User(String username, String password, String gender, String address, String nid, String region) {
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.address = address;
        this.nid = nid;
        this.region = region;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getNid() {
        return nid;
    }

    public String getRegion() {
        return region;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", nid='" + nid + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
