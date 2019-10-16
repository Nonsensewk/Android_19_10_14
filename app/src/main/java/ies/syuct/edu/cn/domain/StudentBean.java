package ies.syuct.edu.cn.domain;


import java.io.Serializable;

/**
 * 学生bean，存储学生登录信息
 */
public class StudentBean implements Serializable {
    private int id;//学生学号
    private String name;//姓名
    private String password;//密码
    private String timeStamp;//时间戳
    private String  position;//位置信息

    public StudentBean() {
    }

    public StudentBean(int id, String name, String password, String timeStamp, String position) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.timeStamp = timeStamp;
        this.position = position;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public void setPosition(String position) {
        this.position = position;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getPosition() {
        return position;
    }
}
