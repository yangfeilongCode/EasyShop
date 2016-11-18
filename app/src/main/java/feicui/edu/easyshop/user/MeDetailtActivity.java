package feicui.edu.easyshop.user;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import feicui.edu.easyshop.R;

/**
 * Created by Administrator on 2016/11/18.
 */

public class MeDetailtActivity extends Activity {
    @BindView(R.id.civ_me_home_icon)
    ImageView mCivMeHomeIcon;
    @BindView(R.id.tv_uesr_name_a)
    TextView mTvUesrName;
    @BindView(R.id.ll_user_name)
    LinearLayout mLLUserName;
    @BindView(R.id.tv_pet_name_a)
    TextView mTvPetName;
    @BindView(R.id.ll_pet_name)
    LinearLayout mLLPetName;
    @BindView(R.id.tv_ring_letter)
    TextView mTvRingLetter;
    @BindView(R.id.ll_ring_letter)
    LinearLayout mLLRingLetter;
    @BindView(R.id.btn_quit)
    Button mBtnQuit;
   private Unbinder unbinder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_home);
        unbinder=ButterKnife.bind(this);
    }

    @OnClick({R.id.civ_me_home_icon, R.id.tv_uesr_name_a, R.id.ll_user_name, R.id.tv_pet_name_a,
            R.id.ll_pet_name, R.id.tv_ring_letter, R.id.ll_ring_letter, R.id.btn_quit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.civ_me_home_icon:
                break;
            case R.id.tv_uesr_name_a:
                break;
            case R.id.ll_user_name:
                Toast.makeText(this,"不能修改",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_pet_name_a:
                break;
            case R.id.ll_pet_name:
                startActivity(new Intent(MeDetailtActivity.this,SetPetNameActivity.class));
                break;
            case R.id.tv_ring_letter:

                break;
            case R.id.ll_ring_letter:
                Toast.makeText(this,"不能修改",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_quit:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
