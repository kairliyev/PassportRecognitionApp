package kz.alibi.hday;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Listz {


    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("surname")
    @Expose
    private String surname;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("team")
    @Expose
    private String team;
    @SerializedName("org")
    @Expose
    private String org;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("section")
    @Expose
    private String section;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Listz(String name, String surname, String email, String phone, String team, String org, String city, String section) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.team = team;
        this.org = org;
        this.city = city;
        this.section = section;
    }
}