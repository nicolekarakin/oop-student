package model;

public class Address {
    public Address(String streetAndNumber, String city, String zip) {
        this.streetAndNumber = streetAndNumber;
        this.city = city;
        this.zip = zip;
    }

    private String streetAndNumber;
    private String city;
    private String zip;

    @Override
    public String toString() {
        return "Address{" +
                "streetAndNumber='" + streetAndNumber + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }

    public String getStreetAndNumber() {
        return streetAndNumber;
    }

    public void setStreetAndNumber(String streetAndNumber) {
        this.streetAndNumber = streetAndNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
