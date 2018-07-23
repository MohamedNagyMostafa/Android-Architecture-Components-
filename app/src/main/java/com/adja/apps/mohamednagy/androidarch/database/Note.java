package com.adja.apps.mohamednagy.androidarch.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

/**
 * Created by Mohamed Nagy on 7/23/2018 .
 * Project android_project
 * Time    12:51 PM
 */
@Entity(tableName = "notes")
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String author;
    private String head;
    private String body;
    @ColumnInfo(name = "update_at")
    private Date updatedAt;
    private int priority;

    @Ignore
    public Note(String author, String head, String body, Date updatedAt, int priority){
        this.author = author;
        this.head = head;
        this.body = body;
        this.updatedAt = updatedAt;
        this.priority = priority;
    }

    public Note(int id, String author, String head, String body, Date updatedAt,int priority){
        this.id = id;
        this.author = author;
        this.head = head;
        this.body = body;
        this.updatedAt = updatedAt;
        this.priority = priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getHead() {
        return head;
    }

    public String getBody() {
        return body;
    }

    public String getAuthor() {
        return author;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public int getPriority() {
        return priority;
    }
}
