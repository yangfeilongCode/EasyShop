package feicui.edu.easyshop.user.me;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import feicui.edu.easyshop.R;
import feicui.edu.easyshop.network.EasyShopClient;
import feicui.edu.easyshop.user.model.Data;
import feicui.edu.easyshop.user.model.LoginResults;
import feicui.edu.easyshop.user.model.NativeCache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

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
    private String petName; //接收昵称

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_pet_name);
        unbinder=ButterKnife.bind(this);

    }




    @OnClick( R.id.btn_ok_name)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_ok_name:
                petName=etSetPetName.getText().toString();
                if (petName.equals("")){
                    Toast.makeText(this,"昵称不能为空",Toast.LENGTH_SHORT).show();
                }else if(petName.length()>3&&petName.length()<12){
                    upData();
                }
                break;
        }
    }


    public void upData(){

        Data data= NativeCache.getData();
        Log.e("aaaaaaaaaa", "petName==: "+petName );
        data.setNickname(petName); //存储昵称
        Log.e("aaaaaaaaaa", "setNickname==: "+data );
        Call call= EasyShopClient.getInstance().upData_dom(data);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("aaaaaaaaaa", "请求失败： "+e.getMessage() );
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
               String json=response.body().string();
                Log.e("aaaaaaaaaa", "json== "+json.toString());
                LoginResults results= new Gson().fromJson(json,LoginResults.class);
                Log.e("aaaaaaaaaa", "results==： "+results.toString());
                if (results.getCode()==1){
                    Toast.makeText(SetPetNameActivity.this,"昵称设置成功",Toast.LENGTH_SHORT).show();
                    NativeCache.setData(results.getData()); //存储数据
                    finish();//结束当前页面
                }else {
                    Log.e("aaaaaaaaaa", "results_code=="+results.getCode() );

                }

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
