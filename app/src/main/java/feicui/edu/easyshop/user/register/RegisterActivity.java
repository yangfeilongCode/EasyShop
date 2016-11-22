package feicui.edu.easyshop.user.register;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import feicui.edu.easyshop.R;
import feicui.edu.easyshop.network.EasyShopClient;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 注册
 * Created by Administrator on 2016/11/17.
 */

public class RegisterActivity extends Activity implements TextWatcher, View.OnClickListener {

    private EditText mETUserName; //用户名
    private EditText mETPassword;//密码
    private EditText mETPass;//确认密码
    private Button mBtnLogin; //注册按钮
    private String user;
    private String password;
    private String pass;
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
        mBtnLogin.setOnClickListener(this);
        mETUserName.addTextChangedListener(this);
        mETPassword.addTextChangedListener(this);
        mETPass.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        boolean canLogin=!(mETUserName.length()==0||mETPassword.length()==0||mETPass.length()==0);
        mBtnLogin.setEnabled(canLogin); //激活按钮
        mBtnLogin.setSelected(canLogin);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_register:
                user=mETUserName.getText().toString();
                password=mETPassword.getText().toString();
                pass=mETPass.getText().toString();

                if ((user.length()>3&&user.length()<10)&&(password.length()>5&&password.length()<15)&&
                        (password.equals(pass))){
                    register();

                }else {
                    Toast.makeText(this,"输入的格式不正确",Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }

    /**
     * 注册方法
     */
    public void register(){

        Call call= EasyShopClient.getInstance().register_dom(user,password);

        call.enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(RegisterActivity.this,"注册失败",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                    //拿到json字符串
                    String json = response.body().string();
                    Log.e("aaaaaaaaaa", "json== "+json );
                    Results results = new Gson().fromJson(json, Results.class);

                    if (results.getCode() == 1) { //判断成功的情况

                        Log.e("aaaaaaaaaa", "results=" + results.toString());
                        Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    } else {
                        Log.e("aaaaaaaaaa", "response.code==: " + response.code());
                        Toast.makeText(RegisterActivity.this, "response.code=: " + response.code(), Toast.LENGTH_SHORT).show();
                    }
                }

        });
    }
}
