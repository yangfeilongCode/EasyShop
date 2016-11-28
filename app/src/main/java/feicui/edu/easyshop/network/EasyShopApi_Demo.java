package feicui.edu.easyshop.network;

/**
 * 存放易淘项目的接口类
 * Created by Administrator on 2016/11/19.
 */
public class EasyShopApi_Demo {

    //注册接口
    static String REGISTER="http://wx.feicuiedu.com:9094/yitao/UserWeb?method=register";

    //登录接口
    static String LOGIN="http://wx.feicuiedu.com:9094/yitao/UserWeb?method=login";

    //更新接口（昵称 头像）
    static String UPDATA="http://wx.feicuiedu.com:9094/yitao/UserWeb?method=update";

    //图片的根路径
    public static final String IMAGE_URL = "http://wx.feicuiedu.com:9094/";
}
