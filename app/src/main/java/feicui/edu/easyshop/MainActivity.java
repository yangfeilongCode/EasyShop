package feicui.edu.easyshop;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.TimerTask;

import feicui.edu.easyshop.mail.MailFragment;
import feicui.edu.easyshop.message.MessageFragment;
import feicui.edu.easyshop.shop.ShopFragment;
import feicui.edu.easyshop.user.me.MeFragment;
import feicui.edu.easyshop.user.model.NativeCache;

/**
 * 应用展示界面
 */
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

    mTvTitle= (TextView) findViewById(R.id.tv_main_title);  //头条目文字
    mTvShop= (TextView) findViewById(R.id.tv_main_shop);  //市场
    mTvMessage= (TextView) findViewById(R.id.tv_main_message);  //详细
    mTvMail= (TextView) findViewById(R.id.tv_main_mail); //通讯录
    mTvMe= (TextView) findViewById(R.id.tv_main_my);  //我的
    mTvShop.setOnClickListener(this);  //点击监听事件
    mTvMessage.setOnClickListener(this);
    mTvMail.setOnClickListener(this);
    mTvMe.setOnClickListener(this);
     //TextView数组 装数据
    textViews=new TextView[]{mTvShop,mTvMessage,mTvMail,mTvMe};
    textViews[0].setSelected(true); //进入默认第一个textView为true
    mTvTitle.setText(textViews[0].getText()); //头条目文字默认为第一个碎片的文字
    mViewPager= (ViewPager) findViewById(R.id.vp_main);

    Log.e("aaaaaaaaaa", "init: ===="+ NativeCache.getData());
    Log.e("aaaaaaaaaa", "init: ===="+ NativeCache.getData().getUsername());
     //判断用户是否登录，从而选择不同的适配器
    if (NativeCache.getData().getName()==null) {
        mViewPager.setAdapter(unPagerAdapter);  //绑定适配器
    }else { //登录过
        mViewPager.setAdapter(PagerAdapter);  //绑定适配器
    }

    //添加页面改变监听
    mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) { //页面选中

            for (TextView textView:textViews) { //遍历数组
                textView.setSelected(false); //设置默认的状态 (false)
            }
                mTvTitle.setText(textViews[position].getText()); //用对用TextView的文字改变title文字
                textViews[position].setSelected(true); //滑动到那个页面那个页面对应的TextView就为true
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    });
  }

    /**
     * 碎片切换  未登录的
     */
    private FragmentStatePagerAdapter unPagerAdapter=
        new FragmentStatePagerAdapter(getSupportFragmentManager()) {
    @Override
    public Fragment getItem(int position) { //通过角标获取子条目
        switch (position){
            case 0:
                return new ShopFragment(); //市场
            case 1:
                return new UnLoginFragment(); //消息(未登录)
            case 2:
                return new UnLoginFragment(); //通讯录(未登录)
            case 3:
                return new MeFragment(); //我的
        }
        return null; //？？？？
    }

    @Override
    public int getCount() { //获取碎片数目
        return 4;
    }
};

    /**
     * 已登录的碎片切换
     */
    private FragmentStatePagerAdapter PagerAdapter=
            new FragmentStatePagerAdapter(getSupportFragmentManager()) {
                @Override
                public Fragment getItem(int position) { //通过角标获取子条目
                    switch (position){
                        case 0:
                            return new ShopFragment(); //市场
                        case 1:
                            return new MessageFragment(); //消息（登录过）
                        case 2:
                            return new MailFragment(); //通讯录（登录过）
                        case 3:
                            return new MeFragment(); //我的
                    }
                    return null; //？？？？
                }

                @Override
                public int getCount() { //获取碎片数目
                    return 4;
                }
            };


    @Override
    public void onClick(View view) { //点击事件

        for(int i = 0;i<textViews.length;i++){ //设置默认值
            textViews[i].setSelected(false);
            textViews[i].setTag(i);  //设置标签
        }
        //设置当前选中的页面。true:顺利滚动到新的项目,false:立即转变
        mViewPager.setCurrentItem((Integer) view.getTag(),false);
        mTvTitle.setText(textViews[(Integer) view.getTag()].getText()); //设置头条文字

    }

    private boolean isExit=false;  //退出默认值
    /**
     * 点击两次退出  两秒内无操作 isExit设为false 再点击不会退出
     */
    @Override
    public void onBackPressed() {
        if (!isExit){
            isExit=true; //点击可退出
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
