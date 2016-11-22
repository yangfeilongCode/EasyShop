package feicui.edu.easyshop.user.register;

/**
 * Created by Administrator on 2016/11/20.
 */

/**
 * //成功
 {
 "code": 1, //结果码
 "msg": "succeed",
 "data": {
 "name": "ytd70aa402693e4333a6318933226d0276", //环信ID
 "uuid": "939913BF5BEB46A29047BE66399BC1A0",   //用户表中主键
 "username": "android"  //用户名
 }
 }
 //失败
 {
 "code": 2,
 "msg": "failed"
 }
 */
public class Results {

    private int code;
    private String msg;
    private Data data;

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
        return "Results{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
 class Data{
    private String name;
     private String uuid;
     private String username;

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
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
                 "name='" + name + '\'' +
                 ", uuid='" + uuid + '\'' +
                 ", username='" + username + '\'' +
                 '}';
     }
 }

