package Task2;

class Worker {
    private String lastName;
    private String firstName;
    private String middleName;
    private String postalCode;
    private String country;
    private String region;
    private String district;
    private String city;
    private String street;
    private String house;
    private String apartment;
    private String nationality;
    private String dateOfBirth;
    private String department;
    private String employeeId;
    private String education;
    private String hireDate;

    public Worker(String lastName, String firstName, String middleName, String postalCode, String country,
                  String region, String district, String city, String street, String house, String apartment,
                  String nationality, String dateOfBirth, String department, String employeeId, String education,
                  String hireDate) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.postalCode = postalCode;
        this.country = country;
        this.region = region;
        this.district = district;
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
        this.department = department;
        this.employeeId = employeeId;
        this.education = education;
        this.hireDate = hireDate;
    }

    public String toString() {
        return lastName + " " + firstName + " " + middleName + ", " + postalCode + ", " + country + ", " + region
                + ", " + district + ", " + city + ", " + street + ", " + house + ", " + apartment + ", " + nationality
                + ",\n " + dateOfBirth + ", " + department + ", " + employeeId + ", " + education + ", " + hireDate;
    }

    public String getHireDate() {
        return hireDate;
    }

    public String getHireYear() {
        return hireDate.split("/")[2];
    }
}
