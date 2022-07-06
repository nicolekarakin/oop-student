package model;

public class ComputerScienceStudent extends Student implements Citizen{
    private int identityCardNumber;
    private String favorieLanguage;

    public void setIdentityCardNumber(int identityCardNumber) {
        identityCardNumber = identityCardNumber;
    }

    public ComputerScienceStudent(String name, String id, int identityCardNumber, String favorieLanguage) {
        super(name, id);
        this.identityCardNumber = identityCardNumber;
        this.favorieLanguage = favorieLanguage;
    }

    public ComputerScienceStudent(String name, String id, Address address, int identityCardNumber, String favorieLanguage) {
        super(name, id, address);
        this.identityCardNumber = identityCardNumber;
        this.favorieLanguage = favorieLanguage;
    }

    @Override
    public String getSubject() {
        return "ComputerScience";
    }

    public ComputerScienceStudent(String name, String id) {
        super(name, id);
    }

    public ComputerScienceStudent(String name, String id, String favorieLanguage) {
        super(name, id);
        this.favorieLanguage = favorieLanguage;
    }

    public String getFavorieLanguage() {
        return favorieLanguage;
    }

    public void setFavorieLanguage(String favorieLanguage) {
        this.favorieLanguage = favorieLanguage;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof ComputerScienceStudent)) return false;
//        if (!super.equals(o)) return false;
//        ComputerScienceStudent that = (ComputerScienceStudent) o;
//        return Objects.equals(favorieLanguage, that.favorieLanguage);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(super.hashCode(), favorieLanguage);
//    }

    @Override
    public String toString() {
        return "ComputerScienceStudent{" +
                "favorieLanguage='" + favorieLanguage + '\'' +
                "student='" + super.toString() + '\'' +
                '}';
    }

    @Override
    public String getAddressAsString() {
        return getAddress().toString();
    }

    @Override
    public int getIdentityCardNumber() {
        return identityCardNumber;
    }
}
