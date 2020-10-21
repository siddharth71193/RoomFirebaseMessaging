package com.example.roompushnotification.service;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.example.roompushnotification.DataRespository;
import com.example.roompushnotification.db.entity.Notification;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.List;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "MyFirebaseMessagingServ";
    DataRespository respository;
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.e(TAG,remoteMessage.getNotification().getBody());
        final Notification notification = new Notification(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody(),false);
        insertNotification(notification);
        Toast.makeText(getApplicationContext(),"Message received!",Toast.LENGTH_LONG).show();
    }

    public void insertNotification(Notification notification) {
        respository = new DataRespository(getApplication());
        respository.insertNotification(notification);
    }
}
