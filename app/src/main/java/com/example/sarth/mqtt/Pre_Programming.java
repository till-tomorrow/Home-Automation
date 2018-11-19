package com.example.sarth.mqtt;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class Pre_Programming extends AppCompatActivity {


    int hours;
    int minutes;
    Calendar cal;
    TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre__programming);

        timePicker = findViewById(R.id.simpleTimePicker);


        cal = Calendar.getInstance();
        Date time = cal.getTime();
        Toast.makeText(this,time.toString(),Toast.LENGTH_LONG).show();
        hours = time.getHours();
        minutes = time.getMinutes();



    }

    public void set (View v){
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent notificationIntent = new Intent("android.media.action.DISPLAY_NOTIFICATION");
        notificationIntent.addCategory("android.intent.category.DEFAULT");

        PendingIntent broadcast = PendingIntent.getBroadcast(this, 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        int new_hours = timePicker.getHour()-hours;
        int new_minutes = timePicker.getMinute()-minutes;
//        Toast.makeText(this, new_hours+ "    hours    "+new_minutes+"           minutes   ",Toast.LENGTH_LONG).show();
        cal.add(Calendar.HOUR, new_hours);
        cal.add(Calendar.MINUTE, new_minutes);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), broadcast);
        Toast.makeText(this, "Toggle after "+minutes+" minute",Toast.LENGTH_LONG).show();

    }
}
