package com.havorld.notificationdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class NotificationDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        textView.setText("我是通知详情页");
        setContentView(textView);
//        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //当点击通知消息跳转到详情页时根据通知消息的id关闭通知栏的显示
//                manager.cancel(Constant.NOAMAL);
//                manager.cancel(Constant.WORD);
//                manager.cancel(Constant.PICTURE);

    }

}
