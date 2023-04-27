package com.hyp.pojo;

/**
 * @author Han
 * @data 2023/4/8
 * @apiNode
 */
public class KD {
    private Integer no;
    private String name;
    private String kdName;
    private String phone;
    private String KdId;
    private String address;
    public KD(Integer no, String name, String kdName, String phone, String kdId, String address) {
        this.no = no;
        this.name = name;
        this.kdName = kdName;
        this.phone = phone;
        KdId = kdId;
        this.address = address;
    }

    public KD() {
    }

    public String getKdName() {
        return kdName;
    }

    public void setKdName(String kdName) {
        this.kdName = kdName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getKdId() {
        return KdId;
    }

    public void setKdId(String kdId) {
        KdId = kdId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "KD{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", KdId='" + KdId + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
