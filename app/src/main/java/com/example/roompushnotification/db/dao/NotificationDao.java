package com.example.roompushnotification.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roompushnotification.db.entity.Notification;

import java.util.List;

@Dao
public interface NotificationDao {

    @Insert
    public void insertUser(Notification notification);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertNotificationList(Notification... notification);

    @Update
    public void updateNotification(Notification notification);

    @Delete
    public void deleteNotification(Notification notification);

    @Query("SELECT * FROM notification")
    public LiveData<List<Notification>> getAllNotification();

    @Query("SELECT * FROM notification WHERE Id LIKE :id ORDER BY id DESC LIMIT 1")
    public LiveData<Notification> getNotificationsByName(int id);
}