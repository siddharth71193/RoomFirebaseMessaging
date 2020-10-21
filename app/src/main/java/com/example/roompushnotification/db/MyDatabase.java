package com.example.roompushnotification.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roompushnotification.db.dao.NotificationDao;
import com.example.roompushnotification.db.entity.Notification;

@Database(entities = {Notification.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {

    private static volatile MyDatabase INSTANCE;

    public abstract NotificationDao notificationDao();

    public static MyDatabase getInstance(Context context){
        if(INSTANCE == null){
            synchronized (MyDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MyDatabase.class, "UserDB.db")
                            .fallbackToDestructiveMigration().build();
                }
            }
        }
        return INSTANCE;
    }

}
