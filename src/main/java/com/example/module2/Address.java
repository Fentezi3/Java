package com.example.module2;

public class Address {
    private String country;
    private String city;
    private String postCode;
    private String street;
    private int house;
    private int apartmentNumber;

    public Address(String country, String city, String postcode,
                   String street, int house, int apartmentNumber) {

        this.country = country;
        this.city = city;
        this.postCode = postcode;
        this.street = street;
        this.house = house;
        this.apartmentNumber = apartmentNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", postcode=" + postCode +
                ", street='" + street + '\'' +
                ", house=" + house +
                ", apartmentNumber=" + apartmentNumber +
                '}';
    }
}
