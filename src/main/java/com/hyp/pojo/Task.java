package com.hyp.pojo;

/**
 * @author Han
 * @data 2023/4/9
 * @apiNode
 */
public class Task {
    private Integer id;
    private String LoginName;
    private String taskName;
    /**
     * 收货姓名
     */
    private String SHname;
    private String phone;
    private String kdid;
    private String address;
    public Task(Integer id, String loginName, String taskName, String SHname, String phone, String kdid, String address) {
        this.id = id;
        LoginName = loginName;
        this.taskName = taskName;
        this.SHname = SHname;
        this.phone = phone;
        this.kdid = kdid;
        this.address = address;
    }

    public Task() {
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getKdid() {
        return kdid;
    }

    public void setKdid(String kdid) {
        this.kdid = kdid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return LoginName;
    }

    public void setLoginName(String loginName) {
        LoginName = loginName;
    }

    public String getSHname() {
        return SHname;
    }

    public void setSHname(String SHname) {
        this.SHname = SHname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", LoginName='" + LoginName + '\'' +
                ", phone='" + phone + '\'' +
                ", kdid='" + kdid + '\'' +
                ", SHname='" + SHname + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
