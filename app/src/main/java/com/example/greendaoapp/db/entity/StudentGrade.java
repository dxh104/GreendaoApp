package com.example.greendaoapp.db.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by XHD on 2020/12/15
 * 学生年级表
 */
@Entity
public class StudentGrade {
    @Id
    private Long studentGradeId;//年级Id
    @Unique
    private String studentGradeName;//年级名称


    @Generated(hash = 1804257883)
    public StudentGrade(Long studentGradeId, String studentGradeName) {
        this.studentGradeId = studentGradeId;
        this.studentGradeName = studentGradeName;
    }


    @Generated(hash = 779037486)
    public StudentGrade() {
    }


    @Override
    public String toString() {
        return "StudentGrade{" +
                "studentGradeId=" + studentGradeId +
                ", studentGradeName='" + studentGradeName + '\'' +
                '}';
    }


    public Long getStudentGradeId() {
        return this.studentGradeId;
    }


    public void setStudentGradeId(Long studentGradeId) {
        this.studentGradeId = studentGradeId;
    }


    public String getStudentGradeName() {
        return this.studentGradeName;
    }


    public void setStudentGradeName(String studentGradeName) {
        this.studentGradeName = studentGradeName;
    }
}
