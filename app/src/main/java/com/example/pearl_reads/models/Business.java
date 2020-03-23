
package com.example.pearl_reads.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Business {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("alias")
    @Expose
    public String alias;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("image_url")
    @Expose
    public String image_url;
    @SerializedName("is_closed")
    @Expose
    public Boolean isClosed;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("review_count")
    @Expose
    public Integer reviewCount;
    @SerializedName("categories")
    @Expose
    public List<Category> categories = null;
    @SerializedName("rating")
    @Expose
    public Double rating;
    @SerializedName("coordinates")
    @Expose
    public Coordinates coordinates;
//    @SerializedName("transactions")
//    @Expose
//    public List<Object> transactions = null;
    @SerializedName("price")
    @Expose
    public String price;
    @SerializedName("location")
    @Expose
    public Location location;
    @SerializedName("phone")
    @Expose
    public String phone;
    @SerializedName("display_phone")
    @Expose
    public String displayPhone;
    @SerializedName("distance")
    @Expose
    public Double distance;
    @SerializedName("website")
    @Expose
    public String website;
    @SerializedName("latitude")
    @Expose
    public Double latitude;
    @SerializedName("longitude")
    @Expose
    public Double longitude;
    @SerializedName("pushId")
    @Expose
    private String pushId;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Business() {
    }

    /**
     * 
     * @param displayPhone
     * @param distance
     * @param rating
     * @param coordinates
//     * @param transactions
     * @param url
     * @param isClosed
     * @param reviewCount
     * @param phone
     * @param price
     * @param image_url
     * @param name
     * @param alias
     * @param location
     * @param id
     * @param categories
//     * @param website
//     * @param categories
//     * @param categories
     */
    public Business(String id, String alias, String name, String image_url, Boolean isClosed, String url, Integer reviewCount, List<Category> categories, Double rating, Coordinates coordinates, String price, Location location, String phone, String displayPhone, Double distance, String website, Double latitude, Double longitude) {
        super();
        this.id = id;
        this.alias = alias;
        this.name = name;
        this.image_url = image_url;
        this.isClosed = isClosed;
        this.url = url;
        this.reviewCount = reviewCount;
        this.categories = categories;
        this.rating = rating;
        this.coordinates = coordinates;
//        this.transactions = transactions;
        this.price = price;
        this.location = location;
        this.phone = phone;
        this.displayPhone = displayPhone;
        this.distance = distance;
        this.website=website;
        this.latitude=latitude;
        this.longitude= longitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return image_url;
    }

    public void setImageUrl(String imageUrl) {
        this.image_url = imageUrl;
    }

    public Boolean getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(Boolean isClosed) {
        this.isClosed = isClosed;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

//    public List<Object> getTransactions() {
//        return transactions;
//    }

//    public void setTransactions(List<Object> transactions) {
//        this.transactions = transactions;
//    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDisplayPhone() {
        return displayPhone;
    }

    public void setDisplayPhone(String displayPhone) {
        this.displayPhone = displayPhone;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getPushId(){
        return pushId;
    }

    public void setPushId(String pushId){
        this.pushId = pushId;
    }

}
