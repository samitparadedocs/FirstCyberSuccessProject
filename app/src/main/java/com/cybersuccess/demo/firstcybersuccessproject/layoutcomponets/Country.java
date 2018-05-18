package com.cybersuccess.demo.firstcybersuccessproject.layoutcomponets;

/**
 * Created by Samit on 5/18/2018.
 */

public class Country {
  int id;
  String countryName;
  String details;
  int imageId;

    public Country(int id, String countryName, String details, int imageId) {
        this.id = id;
        this.countryName = countryName;
        this.details = details;
        this.imageId = imageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
