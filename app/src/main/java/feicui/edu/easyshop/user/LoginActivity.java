package feicui.edu.easyshop.user;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import feicui.edu.easyshop.R;

/**
 * Created by Administrator on 2016/11/17.
 */

public class LoginActivity extends Activity implements View.OnClickListener {
    private EditText mETUserName;
    private EditText mETPassword;
    private Button mBtnLogin;
    private TextView mTvGoRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }
    public void init(){
        mETUserName= (EditText) findViewById(R.id.et_login_username);
        mETPassword= (EditText) findViewById(R.id.et_login_password);
        mBtnLogin= (Button) findViewById(R.id.btn_login);
        mTvGoRegister= (TextView) findViewById(R.id.tv_go_register);
        mBtnLogin.setOnClickListener(this);
        mTvGoRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                break;
            case R.id.tv_go_register:
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
        }
    }
}
