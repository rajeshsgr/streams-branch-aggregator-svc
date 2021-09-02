package com.raj.nola.streams.model.salesRecord;

import io.confluent.shaded.com.google.gson.annotations.SerializedName;



public class Payload {


    @SerializedName("FirstName")
    private String firstName;

    @SerializedName("LastName")
    private String lastName;

    @SerializedName("Category")
    private String category;

    @SerializedName("Country")
    private String country;

    @SerializedName("Product")
    private String product;

    @SerializedName("Color")
    private String color;

    @SerializedName("Material")
    private String material;

    @SerializedName("Price")
    private double price;

    @SerializedName("Date")
    private String saleDate;

    @SerializedName("Status")
    private String paymentStatus;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "Payload{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", category='" + category + '\'' +
                ", country='" + country + '\'' +
                ", product='" + product + '\'' +
                ", color='" + color + '\'' +
                ", material='" + material + '\'' +
                ", price=" + price +
                ", saleDate='" + saleDate + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }


}
