package com.hyp.pojo;

/**
 * @author Han
 * @data 2023/4/16
 * @apiNode
 */
public class Admin {
    private Integer id;
    private String username;
    private String password;
    private String Email;
    private String phone_num;

    public Admin() {
    }

    public Admin(Integer id, String username, String password, String email, String phone_num) {
        this.id = id;
        this.username = username;
        this.password = password;
        Email = email;
        this.phone_num = phone_num;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", Email='" + Email + '\'' +
                ", phone_num='" + phone_num + '\'' +
                '}';
    }
}
