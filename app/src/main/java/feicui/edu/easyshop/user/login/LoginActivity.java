package feicui.edu.easyshop.user.login;

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

import com.google.gson.Gson;

import java.io.IOException;

import feicui.edu.easyshop.R;
import feicui.edu.easyshop.network.EasyShopClient;
import feicui.edu.easyshop.user.register.RegisterActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 登录界面
 * Created by Administrator on 2016/11/17.
 */
public class LoginActivity extends Activity implements View.OnClickListener, TextWatcher {
    private EditText mETUserName; //用户名
    private EditText mETPassword; //密码
    private Button mBtnLogin; //登录按钮
    private TextView mTvGoRegister; //注册跳转文字
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
        mETUserName.addTextChangedListener(this); //文字改变监听
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
        //用户名和密码都不为空则激活按钮
       boolean canLogin=!(mETUserName.length()==0||mETPassword.length()==0);
        mBtnLogin.setEnabled(canLogin); //激活按钮
        mBtnLogin.setSelected(canLogin);  //改变按钮背景色（灰色变为蓝色）
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
                    login();
                    Toast.makeText(this,"可执行",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this,"输入格式不正确",Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.tv_go_register: //注册跳转
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                break;
            default:
                Toast.makeText(this,"点击错误",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    //登录方法
    public void login() {

        Call call = EasyShopClient.getInstance().login_dom(user, password);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("aaaaaaaaaa", "login_e.err==: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
               String json=response.body().string();
                Log.e("aaaaaaaaaa", "login_json== "+json );

                LoginResults results=new Gson().fromJson(json,LoginResults.class);
                if (results.getCode()==1){
                    Log.e("aaaaaaaaaa", "login_results=" + results.toString());
                    Toast.makeText(LoginActivity.this,"登陆成功",Toast.LENGTH_SHORT).show();
                }else {
                    Log.e("aaaaaaaaaa", "login_response.code==: " + response.code());
                }
            }
        });
    }

}
