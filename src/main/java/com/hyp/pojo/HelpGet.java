package com.hyp.pojo;

/**
 * @author Han
 * @data 2023/4/10
 * @apiNode
 */
public class HelpGet {
    private Integer id;
    private String helpName;
    private String taskName;
    private String issuedName;
    private String helpPhone;
    private String kdid;

    public HelpGet(Integer id, String helpName, String taskName, String issuedName, String helpPhone, String kdid) {
        this.id = id;
        this.helpName = helpName;
        this.taskName = taskName;
        this.issuedName = issuedName;
        this.helpPhone = helpPhone;
        this.kdid = kdid;
    }

    public HelpGet() {
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getIssuedName() {
        return issuedName;
    }

    public void setIssuedName(String issuedName) {
        this.issuedName = issuedName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHelpName() {
        return helpName;
    }

    public void setHelpName(String helpName) {
        this.helpName = helpName;
    }

    public String getHelpPhone() {
        return helpPhone;
    }

    public void setHelpPhone(String helpPhone) {
        this.helpPhone = helpPhone;
    }

    public String getKdid() {
        return kdid;
    }

    public void setKdid(String kdid) {
        this.kdid = kdid;
    }

    @Override
    public String toString() {
        return "HelpGet{" +
                "id=" + id +
                ", helpName='" + helpName + '\'' +
                ", issuedName='" + issuedName + '\'' +
                ", helpPhone='" + helpPhone + '\'' +
                ", kdid='" + kdid + '\'' +
                '}';
    }
}
