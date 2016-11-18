package feicui.edu.easyshop.user;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import feicui.edu.easyshop.R;

/**
 * Created by Administrator on 2016/11/17.
 */

public class LoginActivity extends Activity implements View.OnClickListener, TextWatcher {
    private EditText mETUserName;
    private EditText mETPassword;
    private Button mBtnLogin;
    private TextView mTvGoRegister;
    String user; //接收的用户名
    String password;//接收的密码
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
        mETUserName.addTextChangedListener(this);
        mETPassword.addTextChangedListener(this);
    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
       boolean canLogin=!(mETUserName.length()==0||mETPassword.length()==0);
        mBtnLogin.setEnabled(canLogin);
        mBtnLogin.setSelected(canLogin);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:

                user=mETUserName.getText().toString();
                password=mETPassword.getText().toString();

                if (user.equals("")||password.equals("")){
                    Toast.makeText(this,"用户名或密码不能为空",Toast.LENGTH_SHORT).show();

                }else if ((user.length()>3&&user.length()<10)&& (password.length()<16&&password.length()>5)){
                   Toast.makeText(this,"可执行",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this,"输入格式不正确",Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.tv_go_register:
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                break;
            default:
                Toast.makeText(this,"点击错误",Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
