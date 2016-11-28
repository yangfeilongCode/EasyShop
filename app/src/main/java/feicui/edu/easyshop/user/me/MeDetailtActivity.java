package feicui.edu.easyshop.user.me;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;

import org.hybridsquad.android.library.CropHandler;
import org.hybridsquad.android.library.CropHelper;
import org.hybridsquad.android.library.CropParams;

import java.io.File;
import java.io.PipedReader;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import feicui.edu.easyshop.MainActivity;
import feicui.edu.easyshop.R;
import feicui.edu.easyshop.network.AvatarLoadOptions;
import feicui.edu.easyshop.network.EasyShopApi_Demo;
import feicui.edu.easyshop.network.EasyShopClient;
import feicui.edu.easyshop.user.model.NativeCache;
import feicui.edu.easyshop.user.model.PicWindow;

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

    @BindView(R.id.ll_me_home_top)
    LinearLayout mLLMeHomeTop;
    private Unbinder unbinder;
    private View mView; //展示弹框
    private PopupWindow mPopupWindow; //弹框
    private PicWindow picWindow;//图片弹框
    private Button mBtnPhoto; //相册上传按钮
    private Button mBtnCamera;//相册
    private Button mBtnCancel; //取消

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_home);
        unbinder = ButterKnife.bind(this);
        updataAvatar(NativeCache.getData().getOther());

        mTvUserName.setText(NativeCache.getData().getUsername()); //用户名
        mTvPetName.setText(NativeCache.getData().getNickname()); //昵称
        mTvRingLetter.setText(NativeCache.getData().getName()); //环信
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

    public void updataAvatar(String url) {
        ImageLoader.getInstance()
                .displayImage(EasyShopApi_Demo.IMAGE_URL + url,
                        mCivMeHomeIcon, AvatarLoadOptions.build());
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

            case R.id.ll_user_name: //用户名
                Toast.makeText(this, "不能修改", Toast.LENGTH_SHORT).show();
                break;

            case R.id.ll_pet_name: //昵称
                startActivity(new Intent(MeDetailtActivity.this, SetPetNameActivity.class));
                break;

            case R.id.ll_ring_letter: //环信
                Toast.makeText(this, "不能修改", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_quit: //退出登录
                NativeCache.clearAllData(); //清空数据
                Intent intent=new Intent(this, MainActivity.class);
                //清空之前所有旧的Activity
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent); //跳转主页面
                finish();//结束当前页面
                break;

            case R.id.btn_pop_photo: //相册
                Toast.makeText(this,"相册",Toast.LENGTH_SHORT).show();
                listener.toGallery();
                break;

            case R.id.btn_pop_camera: //相机
                Toast.makeText(this,"相机",Toast.LENGTH_SHORT).show();
                listener.toCamera();
                break;

            case R.id.btn_pop_cancel: //取消弹框
                Toast.makeText(this,"取消",Toast.LENGTH_SHORT).show();
                mPopupWindow.dismiss();
                break;

            default:
                Toast.makeText(this,"点击错误",Toast.LENGTH_SHORT).show();
                break;
        }
    }

   // private  PopupWindow.OnDismissListener listener2=new PopupWindow.OnDismissListener() {
//        @Override
//        public void onDismiss() {
//
//
//        }
//    };

    //图片选择弹窗的自定义监听
    private PicWindow.Listener listener=new PicWindow.Listener() {
        @Override
        public void toGallery() {
            //从相册中选择
            //清空裁剪的缓存
            CropHelper.clearCachedCropFile(cropHandler.getCropParams().uri);
            Intent intent=CropHelper.buildCropFromGalleryIntent(cropHandler.getCropParams());
            startActivityForResult(intent,CropHelper.REQUEST_CROP);
        }

        @Override
        public void toCamera() {
            //从相册中选择
            //清空裁剪的缓存
            CropHelper.clearCachedCropFile(cropHandler.getCropParams().uri);
            Intent intent=CropHelper.buildCropFromUriIntent(cropHandler.getCropParams());
            startActivityForResult(intent,CropHelper.REQUEST_CAMERA);

        }
    };

   /**
    *  图片裁剪
    */
    CropHandler cropHandler=new CropHandler() {
    @Override
    public void onPhotoCropped(Uri uri) {
     //通过Uri 拿到图片路径
        File file=new File(uri.getPath());
        EasyShopClient.getInstance().uploadAvatar(file);
    }

    @Override
    public void onCropCancel() {

    }

    @Override
    public void onCropFailed(String message) {

    }

    @Override
    public CropParams getCropParams() {
        //自定义裁剪大小参数
        CropParams cropParams=new CropParams();
        cropParams.aspectX=400;
        cropParams.aspectY=400;
        return cropParams;
    }

    @Override
    public Activity getContext() {
        return MeDetailtActivity.this;
    }
};

    /**
     * 活动结果
     * @param requestCode  请求码
     * @param resultCode 结果码
     * @param data //数据
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //帮助我们去处理结果（裁剪完的图像）
        CropHelper.handleResult(cropHandler,requestCode,resultCode,data);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

}
