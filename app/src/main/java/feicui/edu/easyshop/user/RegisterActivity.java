package feicui.edu.easyshop.user;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import feicui.edu.easyshop.R;

/**
 * Created by Administrator on 2016/11/17.
 */

public class RegisterActivity extends Activity {

    private EditText mETUserName;
    private EditText mETPassword;
    private EditText mETPass;
    private Button mBtnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
    }
    public void init(){
        mETUserName= (EditText) findViewById(R.id.et_register_username);
        mETPassword= (EditText) findViewById(R.id.et_register_password);
        mETPass= (EditText) findViewById(R.id.et_register_pass);
        mBtnLogin= (Button) findViewById(R.id.btn_register);
    }
}
