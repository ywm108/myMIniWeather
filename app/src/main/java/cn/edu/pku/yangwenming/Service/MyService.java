package cn.edu.pku.yangwenming.Service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by ywm108 on 2016/11/22.
 */
public class MyService extends Service {

     //SharedPreferences sharedPreferences = getSharedPreferences("config",MODE_PRIVATE);
    // String ServiceUpdateCityCode=sharedPreferences.getString("UpdateCitycode",null);
     String ServiceUpdateCityCode="101010100";
    private int count = 0;
    private boolean threadDisable = false;
    private MyReceiver receiver=null;
    @Override
    public void onCreate() {
        super.onCreate();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!threadDisable) {
                    try {
                        Thread.sleep(1000*60*60);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //发送广播
                    Intent intent = new Intent();
                    intent.putExtra("UpdateCityCode", ServiceUpdateCityCode);
                    intent.setAction("com.ljq.activity.CountService");
                    sendBroadcast(intent);
                }
            }
        }).start();
//注册广播接收器
        receiver=new MyReceiver();
        IntentFilter filter=new IntentFilter();
        filter.addAction("com.ljq.activity.MyService");
        MyService.this.registerReceiver(receiver,filter);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //count = 0;
        threadDisable = true;
        Log.v("CountService", "on destroy");
    }

    /**
     * 获取广播数据
     *
     * @author jiqinlin
     *
     */
    public class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle=intent.getExtras();
             ServiceUpdateCityCode= (String) bundle.get("UpdateCitycode");
            // editText.setText(count+"");
             Log.d("111",ServiceUpdateCityCode);
        }
    }

}