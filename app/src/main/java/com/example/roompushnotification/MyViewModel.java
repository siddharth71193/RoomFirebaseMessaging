package com.example.roompushnotification;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.roompushnotification.db.entity.Notification;

import java.util.List;

/**
 * Created by vahid on 1/20/18.
 */

public class MyViewModel extends AndroidViewModel {

    private DataRespository repository;

    public MyViewModel(Application application) {
        super(application);
        repository = new DataRespository(application);
    }

    public LiveData<Notification> getNotificationById(int id){
        return repository.getNotificationByName(id);
    }

    public LiveData<List<Notification>> getAllNotification(){
        return repository.getAllNotification();
    }

    public void insertNotification(Notification notification) {
        repository.insertNotification(notification);
    }
}
