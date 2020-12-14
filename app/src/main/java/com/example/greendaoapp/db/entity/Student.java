package com.example.greendaoapp.db.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by XHD on 2020/12/11
 */
@Entity
public class Student {
    @Id
    private String studentId;
    private int studentAge;
    private String studentName;
    private String studentName1;


    @Generated(hash = 1509919683)
    public Student(String studentId, int studentAge, String studentName,
            String studentName1) {
        this.studentId = studentId;
        this.studentAge = studentAge;
        this.studentName = studentName;
        this.studentName1 = studentName1;
    }


    @Generated(hash = 1556870573)
    public Student() {
    }


    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentAge=" + studentAge +
                ", studentName='" + studentName + '\'' +
                ", studentName1='" + studentName1 + '\'' +
                '}';
    }


    public String getStudentId() {
        return this.studentId;
    }


    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }


    public int getStudentAge() {
        return this.studentAge;
    }


    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }


    public String getStudentName() {
        return this.studentName;
    }


    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


    public String getStudentName1() {
        return this.studentName1;
    }


    public void setStudentName1(String studentName1) {
        this.studentName1 = studentName1;
    }
}
