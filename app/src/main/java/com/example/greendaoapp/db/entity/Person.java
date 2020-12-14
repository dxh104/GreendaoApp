package com.example.greendaoapp.db.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by XHD on 2020/12/10
 */
@Entity //告诉GreenDao该对象为实体，只有被@Entity注释的Bean类才能被dao类操作
public class Person {
    @Id(autoincrement = true)
    //对象的Id，使用Long类型作为EntityId，否则会报错。(autoincrement = true)表示主键会自增，如果false就会使用旧值
    private Long id;

    @Unique //该属性值必须在数据库中是唯一值
    private String userId;

    @NotNull //属性不能为空
    private String userName;

    @Property //可以自定义字段名，注意外键不能使用该属性
    private int age;
    private int age2;
    private int age3;
    @Transient //使用该注释的属性不会被存入数据库的字段中
    private String transientId;

    @Generated(hash = 112566923)
    public Person(Long id, String userId, @NotNull String userName, int age,
            int age2, int age3) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.age = age;
        this.age2 = age2;
        this.age3 = age3;
    }

    @Generated(hash = 1024547259)
    public Person() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge2() {
        return this.age2;
    }

    public void setAge2(int age2) {
        this.age2 = age2;
    }


    public int getAge3() {
        return this.age3;
    }

    public void setAge3(int age3) {
        this.age3 = age3;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", age2=" + age2 +
                ", age3=" + age3 +
                ", transientId='" + transientId + '\'' +
                '}';
    }
}
