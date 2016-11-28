package feicui.edu.easyshop.user.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * 对本地信息进行缓存
 * Created by Administrator on 2016/11/21.
 */
public class NativeCache {

    private static final String NAME = NativeCache.class.getSimpleName();
    private static final String KEY_USER_NAME = "userName"; //用户名 userName
    private static final String KEY_USER_PWD = "password"; //密码 userPwd
    private static final String KEY_USER_HX_ID = "name"; //环信id   userHxID
    private static final String KEY_USER_TABLE_ID = "uuid"; //用户主键userUuid
    private static final String KEY_USER_HEAD_IMAGE = "other"; //头像 userHeadImage
    private static final String KEY_USER_NICKNAME = "nickname"; //昵称userNickName

    private static SharedPreferences preferences; //轻量级存储
    private static SharedPreferences.Editor editor; //编辑

    private NativeCache() {

    }

    @SuppressLint("CommitPrefEdits")
    public static void init(Context context) { //初始化
        preferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

   //清空所有数据----退出登录时调用
    public static void clearAllData() {
        editor.clear(); //清除
        editor.apply(); //申请
    }

    public static void setData(Data data) {
        editor.putString(KEY_USER_NAME, data.getUsername());
        editor.putString(KEY_USER_PWD, data.getPassword());
        editor.putString(KEY_USER_HX_ID, data.getName());
        editor.putString(KEY_USER_TABLE_ID, data.getUuid());
        editor.putString(KEY_USER_HEAD_IMAGE, data.getOther());
        editor.putString(KEY_USER_NICKNAME, data.getNickname());

//        editor.putString(KEY_USER_NAME, data.username);
//        //   editor.putString(KEY_USER_PWD, data.));
//        editor.putString(KEY_USER_HX_ID, data.name);
//        editor.putString(KEY_USER_TABLE_ID, data.uuid);
//        editor.putString(KEY_USER_HEAD_IMAGE, data.other);
//        editor.putString(KEY_USER_NICKNAME, data.nickname);
        editor.apply();
    }

    public static Data getData() {
        Data data=new Data();
        data.setName(preferences.getString(KEY_USER_NAME, null));
        data.setPassword(preferences.getString(KEY_USER_PWD, null));
        data.setName(preferences.getString(KEY_USER_HX_ID, null));
        data.setUuid(preferences.getString(KEY_USER_TABLE_ID, null));
        data.setOther(preferences.getString(KEY_USER_HEAD_IMAGE, null));
        data.setNickname(preferences.getString(KEY_USER_NICKNAME, null));
        return data;
    }

}
