package feicui.edu.easyshop.network;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * 易淘客户端
 * Created by Administrator on 2016/11/19.
 */
public class EasyShopClient {

    private static EasyShopClient easyShopClient;

    private OkHttpClient okHttpClient;

    public EasyShopClient(){
        HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor(); //日志拦截
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);  //拦截等级

        okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(interceptor)//日志拦截
                .build();

    }

    public static EasyShopClient getInstance(){
        if (easyShopClient==null){
            easyShopClient=new EasyShopClient();
        }
        return easyShopClient;
    }

//    /**
//     * 注册
//     * @param userName
//     * @param password
//     * @return
//     */
//    public Call register(String userName,String password){
//
//        RequestBody requestBoy=new FormBody.Builder()
//                .add("username",userName)
//                .add("password",password)
//                .build();
//
//        //构建请求请求
//        Request request=new Request.Builder()
//             //   .url(EasyShopApi.BASE_URL + EasyShopApi.REGISTER)
//                .post(requestBoy)
//                .build();
//
//        return okHttpClient.newCall(request);
//    }

    //注册请求方法
    public Call register_dom(String userName,String password){

//        JSONObject object=new JSONObject();
//        try {
//            object.put("username",userName);
//            object.put("password",password);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

// --     RequestBody body1=FormBody.create(null,object.string);

        //构建请求体
        RequestBody body=new FormBody.Builder()
                .add("username",userName)
                .add("password",password)
                .build();
        //构建请求
        Request request=new Request.Builder()
                .url(EasyShopApi_Demo.REGISTER)
                .post(body)
                .build();

        return okHttpClient.newCall(request);
    }

    //登录
    public Call login_dom(String userName,String password){
//        JSONObject object=new JSONObject();
//        try {
//            object.put("username",userName);
//            object.put("password",password);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        RequestBody body=new FormBody.Builder()
                .add("username",userName)
                .add("password",password)
                .build();
        //构建请求
        Request request=new Request.Builder()
                .url(EasyShopApi_Demo.LOGIN)
                .post(body)
                .build();

        return okHttpClient.newCall(request);
    }
}
