package com.example.demo.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class User {
    @Id//id作为主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增策略
    private Long id;

    @NotEmpty(message="姓名不能为空")
    @Size(min=2,max=20)
    @Column(nullable=false,length=20)
    private String name;

    @NotEmpty(message="邮箱不能为空")
    @Size(max=50)
    @Email(message="邮箱格式不对")
    @Column(nullable=false,length=50,unique=true)
    private String email;

    @NotEmpty(message="用户名不能为空")
    @Size(min=3,max=20)
    @Column(nullable=false,length=20,unique=true)
    private String username;

    @NotEmpty(message="密码不能为空")
    @Size(max=100)
    @Column(length=100)
    private String password;

    @Column(length=20)
    private String avatar;

    protected User(){ }//防止直接使用
    public User(Long id,String name,String username,String email){
        this.id = id;
        this.name = name;
        this.email = email;
        this.username=username;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return String.format("User[id=%d,name='%s',username='%s',email='%s']",id,name,username,email);
    }
}
