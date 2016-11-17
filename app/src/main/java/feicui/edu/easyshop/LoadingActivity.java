package feicui.edu.easyshop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/11/16.
 */

public class LoadingActivity extends Activity {
    ImageView mIvLog;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        mIvLog = (ImageView) findViewById(R.id.iv_shop_log);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(LoadingActivity.this,MainActivity.class));
                finish();
            }
        },3000);
    }
}
