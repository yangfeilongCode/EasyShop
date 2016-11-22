package feicui.edu.easyshop.user;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import feicui.edu.easyshop.R;

/**
 * 设置昵称界面
 * Created by Administrator on 2016/11/18.
 */

public class SetPetNameActivity extends Activity {
    @BindView(R.id.et_set_pet_name)
    EditText etSetPetName;
    @BindView(R.id.btn_ok_name)
    Button btnOkName;
    private Unbinder unbinder;
    private String petName; //昵称

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_pet_name);
        unbinder=ButterKnife.bind(this);
    }

    @OnClick({R.id.et_set_pet_name, R.id.btn_ok_name})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_ok_name:
                petName=etSetPetName.getText().toString();
                if (petName.equals("")){
                    Toast.makeText(this,"昵称不能为空",Toast.LENGTH_SHORT).show();
                }else if(petName.length()>5&&petName.length()<12){
                    Toast.makeText(this,"执行",Toast.LENGTH_SHORT).show();

                }
                break;
            default:
                Toast.makeText(this,"点击错误",Toast.LENGTH_SHORT).show();
                break;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
