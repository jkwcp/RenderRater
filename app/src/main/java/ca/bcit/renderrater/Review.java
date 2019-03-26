package ca.bcit.renderrater;

public class Review {

    private String reviewId;
    private int buildingID;
    private double rating;
    private String comment;

    public Review() {}

    public Review(String reviewId, int buildingId, double rating, String comment) {
        this.reviewId = reviewId;
        this.buildingID = buildingId;
        this.rating = rating;
        this.comment = comment;
    }

    public String getReviewID() {
        return reviewId;
    }

    public void setReviewID(String reviewID) {
        this.reviewId = reviewId;
    }

    public int getBuildingID() { return buildingID; }

    public void setBuildingID(int buildingId) { this.buildingID = buildingId; }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }



}

