package com.example.roompushnotification.db.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notification")
public class Notification {
    @PrimaryKey(autoGenerate = true)
    private int Id;
    private String title;
    private String subTitle;
    private Boolean read;

    public Notification(String title, String subTitle, Boolean read) {
        this.title = title;
        this.subTitle = subTitle;
        this.read = read;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }
}