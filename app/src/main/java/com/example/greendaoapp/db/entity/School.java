package com.example.greendaoapp.db.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by XHD on 2020/12/15
 */
@Entity
public class School {
    @Id(autoincrement = true)
    //对象的Id，使用Long类型作为EntityId，否则会报错。(autoincrement = true)表示主键会自增，如果false就会使用旧值
    private Long id;

    @Unique //该属性值必须在数据库中是唯一值
    private String schoolId;

    private String schoolName;
    private String schoolName1;

    @Generated(hash = 357538628)
    public School(Long id, String schoolId, String schoolName, String schoolName1) {
        this.id = id;
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.schoolName1 = schoolName1;
    }

    @Generated(hash = 1579966795)
    public School() {
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", schoolId='" + schoolId + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", schoolName1='" + schoolName1 + '\'' +
                '}';
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchoolId() {
        return this.schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return this.schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolName1() {
        return this.schoolName1;
    }

    public void setSchoolName1(String schoolName1) {
        this.schoolName1 = schoolName1;
    }
}
