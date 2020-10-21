package com.example.roompushnotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.roompushnotification.db.entity.Notification;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    MyViewModel myViewModel;
    TextView firstText,secondText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);

        firstText = findViewById(R.id.buttonPanel);
        secondText = findViewById(R.id.text);

        firstText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.getAllNotification().observe(MainActivity.this, new Observer<List<Notification>>() {
                    @Override
                    public void onChanged(List<Notification> notifications) {
                        Log.e("MainActivity",notifications.size()+"");
                    }
                });
            }
        });
    }
}