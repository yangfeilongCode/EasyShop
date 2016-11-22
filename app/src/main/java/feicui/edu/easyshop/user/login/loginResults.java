package feicui.edu.easyshop.user.login;

import android.net.Uri;

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
class Data{
    private String other;
    private String name;
    private String nickname;
    private String uuid;
    private String username;

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Data{" +
                "other=" + other +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", uuid='" + uuid + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}


