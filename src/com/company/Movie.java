package com.company;

public class Movie {
    private String title;
    private int releaseYear;
    private double length;
    private double rating;
    private Actor leadingActor;
    private Director director;

    // Constructor
    public Movie(String title, int releaseYear, double length, double rating, Actor leadingActor, Director director) {
        setTitle(title);
        setReleaseYear(releaseYear);
        setLength(length);
        setRating(rating);
        setLeadingActor(leadingActor);
        setDirector(director);
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseYear(int releaseYear) {
        // Check release year is within range.
        if (releaseYear > 1896 && releaseYear < 9999) {
            this.releaseYear = releaseYear;
        } else {
            System.out.println("Error: release year not reasonable");
        }
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setRating(double rating) {
        // Check release year is within range.
        if (rating >= 0.0 && rating <= 10.0) {
            this.rating = rating;
        } else {
            System.out.println("Error: min 0.0,  max 10.0");
        }
    }

    public void setLeadingActor(Actor leadingActor) {
        this.leadingActor = leadingActor;
    }

    public void setDirector(Director director) {
        this.director = director;
    }


    // Getters
    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public double getLength() {
        return length;
    }

    public double getRating() {
        return rating;
    }

    public Actor getLeadingActor() {
        return leadingActor;
    }

    public Director getDirector() {
        return director;
    }

    @Override
    public String toString() {
        String movieInfo = getTitle()
                + "\n " + getReleaseYear()
                + "\n " + getLength()
                + "\n " + getRating()
                + "\n " + getDirector().toString()
                + "\n " + getLeadingActor().toString();
        return movieInfo;
    }
}
