package feicui.edu.easyshop.user;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import feicui.edu.easyshop.R;

/**
 * Created by Administrator on 2016/11/17.
 */

public class RegisterActivity extends Activity implements TextWatcher, View.OnClickListener {

    private EditText mETUserName;
    private EditText mETPassword;
    private EditText mETPass;
    private Button mBtnLogin;
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
        mBtnLogin.setEnabled(canLogin);
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
                    Toast.makeText(this,"执行",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this,"输入的格式不正确",Toast.LENGTH_SHORT).show();
                }

        }

    }
}
