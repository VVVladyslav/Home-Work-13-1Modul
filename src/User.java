//import lombok.Data;
//
//@Data
public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private String addressstreet;
    private String addresssuite;
    private String addresscity;
    private String addresszipcode;
    private String addressgeolat;
    private String addressgeolng;
    private String phone;
    private String website;
    private String companyname;
    private String companycatchPhrase;
    private String companybs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddressstreet() {
        return addressstreet;
    }

    public void setAddressstreet(String addressstreet) {
        this.addressstreet = addressstreet;
    }

    public String getAddresssuite() {
        return addresssuite;
    }

    public void setAddresssuite(String addresssuite) {
        this.addresssuite = addresssuite;
    }

    public String getAddresscity() {
        return addresscity;
    }

    public void setAddresscity(String addresscity) {
        this.addresscity = addresscity;
    }

    public String getAddresszipcode() {
        return addresszipcode;
    }

    public void setAddresszipcode(String addresszipcode) {
        this.addresszipcode = addresszipcode;
    }

    public String getAddressgeolat() {
        return addressgeolat;
    }

    public void setAddressgeolat(String addressgeolat) {
        this.addressgeolat = addressgeolat;
    }

    public String getAddressgeolng() {
        return addressgeolng;
    }

    public void setAddressgeolng(String addressgeolng) {
        this.addressgeolng = addressgeolng;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getCompanycatchPhrase() {
        return companycatchPhrase;
    }

    public void setCompanycatchPhrase(String companycatchPhrase) {
        this.companycatchPhrase = companycatchPhrase;
    }

    public String getCompanybs() {
        return companybs;
    }

    public void setCompanybs(String companybs) {
        this.companybs = companybs;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", addressstreet='" + addressstreet + '\'' +
                ", addresssuite='" + addresssuite + '\'' +
                ", addresscity='" + addresscity + '\'' +
                ", addresszipcode='" + addresszipcode + '\'' +
                ", addressgeolat='" + addressgeolat + '\'' +
                ", addressgeolng='" + addressgeolng + '\'' +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", companyname='" + companyname + '\'' +
                ", companycatchPhrase='" + companycatchPhrase + '\'' +
                ", companybs='" + companybs + '\'' +
                '}';
    }
}
