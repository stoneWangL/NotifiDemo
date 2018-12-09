package com.stone.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.widget.RemoteViews;

public class Main2Activity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    private RemoteViews remoteViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //showNotification();
        showNot2();

    }
    private void showNotification() {
        Log.d(TAG, "showNotification");
        NotificationManager notificationManager =
                (NotificationManager) (this.getSystemService(Context.NOTIFICATION_SERVICE));
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setLargeIcon(BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_launcher_background));
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setContentTitle(this.getText(R.string.app_name));
        String strProgress = this.getResources().getString(R.string.app_name);
        builder.setContentText(strProgress);
        Notification notification = builder.build();
        notification.flags = Notification.FLAG_ONGOING_EVENT;
        notificationManager.notify(1, notification);
    }

    private void showNot2(){
        NotificationManager mNotificationManager =
                (NotificationManager) (this.getSystemService(Context.NOTIFICATION_SERVICE));
        remoteViews = new RemoteViews(getPackageName(),
                R.layout.view_remote);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setSmallIcon(R.drawable.ic_log); // 设置顶部图标
        mBuilder.setOngoing(true);


        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //构建通知
        final Notification notify = mBuilder.build();
        notify.contentView = remoteViews; // 设置下拉图标
        notify.bigContentView = remoteViews; // 防止显示不完全,需要添加apisupport
        notify.flags = Notification.FLAG_ONGOING_EVENT;
        notify.icon = R.drawable.anim_log;

        //显示通知
        mNotificationManager.notify(123, notify);
        //启动为前台服务
//        startForeground(123, notify);
    }

}
