package feicui.edu.easyshop.user.model;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import butterknife.ButterKnife;
import butterknife.OnClick;
import feicui.edu.easyshop.R;


/**
 * 自定义PopupWindow,用于图片的选择
 */
public class PicWindow extends PopupWindow {

    public interface Listener {
        /**
         * 来自相册
         */
        void toGallery();

        /**
         * 来自相机
         */
        void toCamera();
    }

    private final Activity activity;

    private final Listener listener;

    @SuppressWarnings("all")
    public PicWindow(Activity activity, Listener listener) {

        super(activity.getLayoutInflater().inflate(R.layout.view_pop, null),
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        ButterKnife.bind(this, getContentView());
        this.activity = activity;
        this.listener = listener;

        setFocusable(true);
        setBackgroundDrawable(new BitmapDrawable());
    }

    public void show() {
        showAtLocation(activity.getWindow().getDecorView(), Gravity.BOTTOM, 0, 0);
    }

    @OnClick({R.id.btn_pop_photo, R.id.btn_pop_camera, R.id.btn_pop_cancel})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_pop_photo:
                listener.toGallery();
                break;
            case R.id.btn_pop_camera:
                listener.toCamera();
                break;
            case R.id.btn_pop_cancel:
                break;
        }
        dismiss();
    }

}