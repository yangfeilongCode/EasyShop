package feicui.edu.easyshop.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import feicui.edu.easyshop.MainActivity;
import feicui.edu.easyshop.R;

/**
 * Created by Administrator on 2016/11/16.
 */

public class MeFragment extends Fragment implements View.OnClickListener {

    private ImageView mIvUserIcon;
    private TextView mTvUserInfo;
    private TextView mTvShop;
    private TextView mTvGoShop;
    private TextView mTvLogin;
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
                startActivity(new Intent(activity,LoginActivity.class));
                break;
            case R.id.tv_user_shop:
                startActivity(new Intent(activity,LoginActivity.class));
                break;
            case R.id.tv_go_shop:
                startActivity(new Intent(activity,LoginActivity.class));
                break;
        }
    }
}
