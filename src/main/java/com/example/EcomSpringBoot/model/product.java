package com.example.EcomSpringBoot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

@Entity
public class product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private String category;
    private Date releaseDate;
    private boolean productAvailable;
    private int stockQuantity;
    private String imageName;
    private String imageType;
    @Lob
    private byte[] imagedata;

    public byte[] getImagedata() {
        return imagedata;
    }

    public void setImagedata(byte[] imagedata) {
        this.imagedata = imagedata;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public product(String imageName, byte[] imagedata, String imageType, int stockQuantity, boolean productAvailable, Date releaseDate, String category, BigDecimal price, String brand, String description, String name, int id) {
        this.imageName = imageName;
        this.imagedata = imagedata;
        this.imageType = imageType;
        this.stockQuantity = stockQuantity;
        this.productAvailable = productAvailable;
        this.releaseDate = releaseDate;
        this.category = category;
        this.price = price;
        this.brand = brand;
        this.description = description;
        this.name = name;
        this.id = id;
    }

    public product(){

    }

    public product(int i) {
        this.id = i;
    }

    @Override
    public String toString() {
        return "product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", releaseDate=" + releaseDate +
                ", productAvailable=" + productAvailable +
                ", stockQuantity=" + stockQuantity +
                ", imageName='" + imageName + '\'' +
                ", imageType='" + imageType + '\'' +
                ", imagedata=" + Arrays.toString(imagedata) +
                '}';
    }

    public boolean isProductAvailable() {
        return productAvailable;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public String getCategory() {
        return category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
