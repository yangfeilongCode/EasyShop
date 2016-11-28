package feicui.edu.easyshop.user.model;

/**
 * Created by Administrator on 2016/11/21.
 */
/*
//成功
{
    "code": 1, //结果码
    "msg": "succeed",
    "data": {
        "other": "/images/8A572F08CE874555A80034CDC104CB82/D28584D018.jpg", //头像路径
        "name": "yt6e2ea5da01e846e198d5cc9146a0919b", //环信ID
        "nickname": "翡翠产品",  //昵称
        "uuid": "8A572F08CE874555A80034CDC104CB82",  //用户表中主键
        "username": "feicuicp" //用户名
        "password": "123456"
    }
}
//失败
{
    "code": 2,
    "msg": "failed"
}
 */
public class LoginResults {
    private int code;
    private String msg;
    public Data data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "loginResults{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}

