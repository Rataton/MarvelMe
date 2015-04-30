package com.petitemasrata.marvelme.model;

import android.net.Uri;

public class Character {

    int id;
    String name;
    String description;
    Uri urlImage;
    int availableComics;
    int availableSeries;
    int availableStories;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Uri getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(Uri urlImage) {
        this.urlImage = urlImage;
    }

    public int getAvailableComics() {
        return availableComics;
    }

    public void setAvailableComics(int availableComics) {
        this.availableComics = availableComics;
    }

    public int getAvailableSeries() {
        return availableSeries;
    }

    public void setAvailableSeries(int availableSeries) {
        this.availableSeries = availableSeries;
    }

    public int getAvailableStories() {
        return availableStories;
    }

    public void setAvailableStories(int availableStories) {
        this.availableStories = availableStories;
    }

    @Override
    public String toString() {
        String character = name +
                "\n Description:" + description +
                "\n img:"+ urlImage +
                "\n available comics:"+ availableComics +
                "\n available series:"+ availableSeries +
                "\n available stories:"+ availableStories;

        return character;
    }
}