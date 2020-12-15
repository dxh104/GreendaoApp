package com.example.greendaoapp.db.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.DaoException;

/**
 * Created by XHD on 2020/12/11
 * 学生信息表
 */
@Entity
public class Student {
    //    @Id(autoincrement = true)
//    //对象的Id，使用Long类型作为EntityId，否则会报错。(autoincrement = true)表示主键会自增，如果false就会使用旧值
//    private Long id;
    @Id//主键
    private String studentId;//学号
    @NotNull
    private Long studentGradeId;//年级 (外键)
    @ToOne(joinProperty = "studentGradeId")//设置外键关系
    private StudentGrade studentGrade;
    //    @NotNull
//    private int studentClassId;//班级 外键
    //入籍时间,就读方式等等...
    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /**
     * Used for active entity operations.
     */
    @Generated(hash = 1943931642)
    private transient StudentDao myDao;


    @Generated(hash = 757310551)
    public Student(String studentId, @NotNull Long studentGradeId) {
        this.studentId = studentId;
        this.studentGradeId = studentGradeId;
    }


    @Generated(hash = 1556870573)
    public Student() {
    }


    @Generated(hash = 868221750)
    private transient Long studentGrade__resolvedKey;


    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentGradeId=" + studentGradeId +
                ", studentGrade=" + getStudentGrade().toString() +
                '}';
    }


    public String getStudentId() {
        return this.studentId;
    }


    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }


    public Long getStudentGradeId() {
        return this.studentGradeId;
    }


    public void setStudentGradeId(Long studentGradeId) {
        this.studentGradeId = studentGradeId;
    }


    /**
     * To-one relationship, resolved on first access.
     */
    @Generated(hash = 1890825345)
    public StudentGrade getStudentGrade() {
        Long __key = this.studentGradeId;
        if (studentGrade__resolvedKey == null
                || !studentGrade__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            StudentGradeDao targetDao = daoSession.getStudentGradeDao();
            StudentGrade studentGradeNew = targetDao.load(__key);
            synchronized (this) {
                studentGrade = studentGradeNew;
                studentGrade__resolvedKey = __key;
            }
        }
        return studentGrade;
    }


    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 1280769834)
    public void setStudentGrade(@NotNull StudentGrade studentGrade) {
        if (studentGrade == null) {
            throw new DaoException(
                    "To-one property 'studentGradeId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.studentGrade = studentGrade;
            studentGradeId = studentGrade.getStudentGradeId();
            studentGrade__resolvedKey = studentGradeId;
        }
    }


    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }


    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }


    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }


    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1701634981)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getStudentDao() : null;
    }

}
