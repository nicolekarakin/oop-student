package model;

public class BiologyStudent extends Student implements Citizen{
    private int identityCardNumber;

    public void setIdentityCardNumber(int identityCardNumber) {
        identityCardNumber = identityCardNumber;
    }

    public BiologyStudent(String name, String id, int identityCardNumber) {
        super(name, id);
        this.identityCardNumber = identityCardNumber;
    }

    public BiologyStudent(String name, String id, Address address, int identityCardNumber) {
        super(name, id, address);
        this.identityCardNumber = identityCardNumber;
    }

    @Override
    public String getSubject() {
        return "Biology";
    }

    public BiologyStudent(String name, String id) {
        super(name, id);
    }


    @Override
    public String toString() {
        return "BiologyStudent{" +
                "student='" + super.toString() + '\'' +
                '}';
    }

    @Override
    public int getIdentityCardNumber() {
        return identityCardNumber;
    }

    @Override
    public Address getAddress() {
        return super.getAddress();
    }

    @Override
    public String getAddressAsString() {
        return new StringBuilder()
                .append(getAddress().getStreetAndNumber())
                .append(", ")
                .append(getAddress().getZip())
                .append(getAddress().getCity())
                .toString();
    }
}
