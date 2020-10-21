package com.example.roompushnotification.db.worker;

import android.os.AsyncTask;

import com.example.roompushnotification.db.MyDatabase;
import com.example.roompushnotification.db.dao.NotificationDao;
import com.example.roompushnotification.db.entity.Notification;

public class UpdateNotification extends AsyncTask<Notification,Void,Void> {
    private MyDatabase db;
    private NotificationDao userDao;

    public UpdateNotification(MyDatabase db){
        this.db = db;
        userDao = db.notificationDao();
    }
    @Override
    protected Void doInBackground(Notification... users) {
        userDao.insertUser(users[0]);
        return null;
    }
}
