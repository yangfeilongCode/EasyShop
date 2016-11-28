package feicui.edu.easyshop.testMode;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import feicui.edu.easyshop.R;

/**
 * 设备检测
 * Created by Administrator on 2016/11/25.
 */
public class EspressoActivity extends Activity {

    @BindView(R.id.tv_text)
    TextView tvText;
    @BindView(R.id.et_text)
    EditText etText;
    @BindView(R.id.btn_show)
    Button btnShow;
     private Unbinder unbinder;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_dome);
        unbinder=ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_show)
    public void onClick() {
        tvText.setText("hello"+etText.getText().toString()+"!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
