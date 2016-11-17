package feicui.edu.easyshop;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.TimerTask;

import feicui.edu.easyshop.mail.MailFragment;
import feicui.edu.easyshop.message.MessageFragment;
import feicui.edu.easyshop.shop.ShopFragment;
import feicui.edu.easyshop.user.MeFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ViewPager mViewPager;  //左右滑动控件
    TextView mTvTitle; //头条目文字
    TextView mTvShop; //市场
    TextView mTvMessage;  //消息
    TextView mTvMail;  //通讯录
    TextView mTvMe;//  我的
    TextView[] textViews; //textView数组
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          init();
    }
public void init(){

    mTvTitle= (TextView) findViewById(R.id.tv_main_title);
    mTvShop= (TextView) findViewById(R.id.tv_main_shop);
    mTvMessage= (TextView) findViewById(R.id.tv_main_message);
    mTvMail= (TextView) findViewById(R.id.tv_main_mail);
    mTvMe= (TextView) findViewById(R.id.tv_main_my);
    mTvShop.setOnClickListener(this);
    mTvMessage.setOnClickListener(this);
    mTvMail.setOnClickListener(this);
    mTvMe.setOnClickListener(this);
     //数组装数据
    textViews=new TextView[]{mTvShop,mTvMessage,mTvMail,mTvMe};
    textViews[0].setSelected(true); //进入第一个textView为true
    mTvTitle.setText(textViews[0].getText()); //默认为第一个碎片的文字
    mViewPager= (ViewPager) findViewById(R.id.vp_main);
    mViewPager.setAdapter(unPagerAdapter);

    mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            for (TextView textView:textViews) { //设置默认的状态
                textView.setSelected(false);
            }
                mTvTitle.setText(textViews[position].getText()); //用对用TextView的文字改变title文字
                textViews[position].setSelected(true); //滑动到那个页面那个页面对用的TextView就为true
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    });
  }

    /**
     * 碎片切换
     */
    private FragmentStatePagerAdapter unPagerAdapter=
        new FragmentStatePagerAdapter(getSupportFragmentManager()) {
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ShopFragment();
            case 1:
                return new MessageFragment();
            case 2:
                return new MailFragment();
            case 3:
                return new MeFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
};


    @Override
    public void onClick(View view) {

        for(int i = 0;i<textViews.length;i++){
            textViews[i].setSelected(false);
            textViews[i].setTag(i);
        }
        mViewPager.setCurrentItem((Integer) view.getTag(),false);
        mTvTitle.setText(textViews[(Integer) view.getTag()].getText());

 //       switch (view.getId()){
//            case R.id.tv_main_shop:
//                break;
//            case R.id.tv_main_message:
//
//                break;
//            case R.id.tv_main_mail:
//
//                break;
//            case R.id.tv_main_my:
//
//                break;
//        }

    }

private boolean isExit=false;  //退出默认值
    /**
     * 点击量次退出
     */
    @Override
    public void onBackPressed() {
        if (!isExit){
            isExit=true;
            Toast.makeText(this,"再摁一次退出",Toast.LENGTH_SHORT).show();
            mViewPager.postDelayed(new TimerTask() {
                @Override
                public void run() {
                    isExit=false;
                }
            },2000);
        }else {
            finish();
        }

    }


}
