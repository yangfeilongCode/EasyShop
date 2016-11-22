package feicui.edu.easyshop.user;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import feicui.edu.easyshop.R;

/**
 * 用户详情界面
 * Created by Administrator on 2016/11/18.
 */
public class MeDetailtActivity extends Activity implements View.OnClickListener {
    @BindView(R.id.civ_me_home_icon)
    ImageView mCivMeHomeIcon;
    @BindView(R.id.tv_uesr_name_a)
    TextView mTvUserName;
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

//    @BindView(R.id.btn_pop_photo)
//    Button mBtnPhoto; //相册上传按钮
//    @BindView(R.id.btn_pop_camera)
//    Button mBtnCamera;//相机
//    @BindView(R.id.btn_pop_cancel)
//    Button mBtnCancel; //取消

    @BindView(R.id.ll_me_home_top)
    LinearLayout mLLMeHomeTop;
    private Unbinder unbinder;
    private View mView; //展示弹框
    private PopupWindow mPopupWindow; //弹框
    private Button mBtnPhoto; //相册上传按钮
    private Button mBtnCamera;//相册
    private Button mBtnCancel; //取消

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_home);
        unbinder = ButterKnife.bind(this);
        init();
    }

    public void init() {
        mView = getLayoutInflater().inflate(R.layout.view_pop, null);
        mPopupWindow = new PopupWindow(mView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mBtnPhoto = (Button) mView.findViewById(R.id.btn_pop_photo);
        mBtnCamera = (Button) mView.findViewById(R.id.btn_pop_camera);
        mBtnCancel = (Button) mView.findViewById(R.id.btn_pop_cancel);
        mBtnPhoto.setOnClickListener(this);
        mBtnCamera.setOnClickListener(this);
        mBtnCancel.setOnClickListener(this);

    }


    @OnClick({R.id.civ_me_home_icon, R.id.ll_user_name, R.id.ll_pet_name, R.id.tv_ring_letter,
            R.id.ll_ring_letter, R.id.btn_quit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.civ_me_home_icon:
                mPopupWindow.setOutsideTouchable(true);
                mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
                mPopupWindow.showAtLocation(mLLMeHomeTop, Gravity.BOTTOM, 0,0);
                break;

            case R.id.ll_user_name:
                Toast.makeText(this, "不能修改", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_pet_name:
                startActivity(new Intent(MeDetailtActivity.this, SetPetNameActivity.class));
                break;
            case R.id.ll_ring_letter:
                Toast.makeText(this, "不能修改", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_quit:
                break;
            case R.id.btn_pop_photo:
                Toast.makeText(this,"相册",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_pop_camera:
                Toast.makeText(this,"相机",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_pop_cancel:
                Toast.makeText(this,"取消",Toast.LENGTH_SHORT).show();
                mPopupWindow.dismiss();
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
