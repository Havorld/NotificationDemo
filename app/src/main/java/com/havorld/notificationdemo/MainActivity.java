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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.noamal).setOnClickListener(this);
        findViewById(R.id.word).setOnClickListener(this);
        findViewById(R.id.picture).setOnClickListener(this);
    }

    void notification(int type) {
        Notification notification;
        Intent intent = new Intent(this, NotificationDetailsActivity.class);
        //点击通知栏消息跳转页
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        //创建通知消息管理类
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)//创建通知消息实例
                .setContentTitle("我是标题")
                .setContentText("我是内容")
                .setWhen(System.currentTimeMillis())//通知栏显示时间
                .setSmallIcon(R.mipmap.ic_launcher)//通知栏小图标
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.icon))//通知栏下拉是图标
                .setContentIntent(pendingIntent)//关联点击通知栏跳转页面
                .setPriority(NotificationCompat.PRIORITY_MAX)//设置通知消息优先级
                .setAutoCancel(true)//设置点击通知栏消息后，通知消息自动消失
//                .setSound(Uri.fromFile(new File("/system/MP3/music.mp3"))) //通知栏消息提示音
//                .setVibrate(new long[]{0, 1000, 1000, 1000}) //通知栏消息震动
//                .setLights(Color.GREEN, 1000, 2000) //通知栏消息闪灯(亮一秒间隔两秒再亮)
                .setDefaults(NotificationCompat.DEFAULT_ALL); //通知栏提示音、震动、闪灯等都设置为默认

        switch (type) {
            case 1:
                notification = builder.build();
                //id为通知栏消息标识符，每个id都是不同的
                manager.notify(Constant.NOAMAL, notification);
                break;
            case 2:
                notification = builder.setStyle(new NotificationCompat.BigTextStyle().bigText("Learn how to build notifications, send and sync data, and use voice actions. Get the official Android IDE and developer tools to build apps for Android."))
                        .build();
                manager.notify(Constant.WORD, notification);
                break;
            case 3:
                notification = builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(), R.mipmap.big)))
                        .build();
                manager.notify(Constant.PICTURE, notification);
                break;
            default:
                break;
        }

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.noamal:
                notification(1);
                break;
            case R.id.word:
                notification(2);
                break;
            case R.id.picture:
                notification(3);
                break;

        }
    }
}
