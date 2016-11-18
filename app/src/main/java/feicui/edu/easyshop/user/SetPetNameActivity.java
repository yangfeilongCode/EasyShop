package feicui.edu.easyshop.user;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import feicui.edu.easyshop.R;

/**
 * Created by Administrator on 2016/11/18.
 */

public class SetPetNameActivity extends Activity {
    @BindView(R.id.et_set_pet_name)
    EditText etSetPetName;
    @BindView(R.id.btn_ok_name)
    Button btnOkName;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_pet_name);
        unbinder=ButterKnife.bind(this);
    }

    @OnClick({R.id.et_set_pet_name, R.id.btn_ok_name})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.et_set_pet_name:
                break;
            case R.id.btn_ok_name:

                break;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
