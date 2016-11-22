package feicui.edu.easyshop.user.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import feicui.edu.easyshop.user.login.LoginResults;

/**
 * 对本地信息进行缓存
 * Created by Administrator on 2016/11/21.
 */
public class NativeCache {

    private static final String NAME = NativeCache.class.getSimpleName();
    private static final String KEY_USER_NAME = "userName";
    private static final String KEY_USER_PWD = "userPwd";
    private static final String KEY_USER_HX_ID = "userHxID";
    private static final String KEY_USER_TABLE_ID = "userUuid";
    private static final String KEY_USER_HEAD_IMAGE = "userHeadImage";
    private static final String KEY_USER_NICKNAME = "userNickName";

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

//    public static void setUser(LoginResults user) {
//        editor.putString(KEY_USER_NAME, user.getName());
//        editor.putString(KEY_USER_PWD, user.getPassword());
//        editor.putString(KEY_USER_HX_ID, user.getHx_Id());
//        editor.putString(KEY_USER_TABLE_ID, user.getTable_Id());
//        editor.putString(KEY_USER_HEAD_IMAGE, user.getHead_Image());
//        editor.putString(KEY_USER_NICKNAME, user.getNick_name());
//
//        editor.apply();
//    }

//    public static LoginResults getUser() {
//        LoginResults user = new User();
//        user.setName(preferences.getString(KEY_USER_NAME, null));
//        user.setPassword(preferences.getString(KEY_USER_PWD, null));
//        user.setHx_Id(preferences.getString(KEY_USER_HX_ID, null));
//        user.setTable_Id(preferences.getString(KEY_USER_TABLE_ID, null));
//        user.setHead_Image(preferences.getString(KEY_USER_HEAD_IMAGE, null));
//        user.setNick_name(preferences.getString(KEY_USER_NICKNAME, null));
//        return user;
//    }

}
