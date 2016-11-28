package feicui.edu.easyshop.user.me;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import feicui.edu.easyshop.MainActivity;
import feicui.edu.easyshop.R;
import feicui.edu.easyshop.user.login.LoginActivity;
import feicui.edu.easyshop.user.me.MeDetailtActivity;

/**
 * 我的个人界面
 * Created by Administrator on 2016/11/16.
 */

public class MeFragment extends Fragment implements View.OnClickListener {

    private ImageView mIvUserIcon; //用户头像
    private TextView mTvUserInfo; //用户信息
    private TextView mTvShop;  //我的商品
    private TextView mTvGoShop; //上传商品
    private TextView mTvLogin; //登录或注册文字
    private View mView;
    private MainActivity activity;

    public MeFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        activity= (MainActivity) getActivity();
        mView=inflater.inflate(R.layout.fragment_me,container,false);
        mIvUserIcon= (ImageView) mView.findViewById(R.id.civ_me_icon);
        mTvUserInfo= (TextView) mView.findViewById(R.id.tv_user_info);
        mTvShop= (TextView) mView.findViewById(R.id.tv_user_shop);
        mTvGoShop= (TextView) mView.findViewById(R.id.tv_go_shop);
        mTvLogin= (TextView) mView.findViewById(R.id.tv_login_or_register);
        mIvUserIcon.setOnClickListener(this);
        mTvUserInfo.setOnClickListener(this);
        mTvShop.setOnClickListener(this);
        mTvGoShop.setOnClickListener(this);
        mTvLogin.setOnClickListener(this);
        return mView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_login_or_register:
                startActivity(new Intent(activity,LoginActivity.class));
                break;
            case R.id.civ_me_icon:
                startActivity(new Intent(activity,MeDetailtActivity.class));
                break;
            case R.id.tv_user_info:
                startActivity(new Intent(activity,MeDetailtActivity.class));
                break;
            case R.id.tv_user_shop:
                // TODO: 2016/11/24 我的商品待完成
                startActivity(new Intent(activity,LoginActivity.class));
                break;
            case R.id.tv_go_shop:
                // TODO: 2016/11/24 上传商品待完成
                startActivity(new Intent(activity,LoginActivity.class));
                break;
        }
    }
}
