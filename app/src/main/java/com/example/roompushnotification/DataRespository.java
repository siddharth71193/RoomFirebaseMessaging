package com.example.roompushnotification;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.roompushnotification.db.MyDatabase;
import com.example.roompushnotification.db.dao.NotificationDao;
import com.example.roompushnotification.db.entity.Notification;
import com.example.roompushnotification.db.worker.UpdateNotification;

import java.util.List;

public class DataRespository {

    private NotificationDao notificationDao;
    private MyDatabase myDatabase;

    public DataRespository(Application application) {
        myDatabase = MyDatabase.getInstance(application);
        notificationDao = myDatabase.notificationDao();
    }

    public void insertNotification(final Notification user) {
        new UpdateNotification(myDatabase).execute(user);
    }

    public LiveData<Notification> getNotificationByName(int name) {
        return notificationDao.getNotificationsByName(name);
    }

    public LiveData<List<Notification>> getAllNotification() {
        return notificationDao.getAllNotification();
    }
}