package com.example.greendaoapp.db.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * Created by XHD on 2020/12/10
 * todo-----------------------------不用管这张表
 */
@Entity //告诉GreenDao该对象为实体，只有被@Entity注释的Bean类才能被dao类操作
public class Person {
    @Id(autoincrement = false)
    @Property(nameInDb = "userId") //可以自定义字段名，注意外键不能使用该属性
    private String Id;

    @Property(nameInDb = "userName") //可以自定义字段名，注意外键不能使用该属性
    @NotNull //属性不能为空
    private String name;

    @Property(nameInDb = "userAge") //字段别名
    private int age;

    //学生属于一个学校建立一对一关系
    private String schoolId;//这是与学校关联的外键
    @ToOne(joinProperty = "schoolId")
    private School school;

    @Transient //使用该注释的属性不会被存入数据库的字段中
    private String transientId;

    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /**
     * Used for active entity operations.
     */
    @Generated(hash = 778611619)
    private transient PersonDao myDao;

    @Generated(hash = 1271638163)
    public Person(String Id, @NotNull String name, int age, String schoolId) {
        this.Id = Id;
        this.name = name;
        this.age = age;
        this.schoolId = schoolId;
    }

    @Generated(hash = 1024547259)
    public Person() {
    }

    public String getId() {
        return this.Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSchoolId() {
        return this.schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    @Generated(hash = 2059151203)
    private transient String school__resolvedKey;

    /**
     * To-one relationship, resolved on first access.
     */
    @Generated(hash = 1017877165)
    public School getSchool() {
        String __key = this.schoolId;
        if (school__resolvedKey == null || school__resolvedKey != __key) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            SchoolDao targetDao = daoSession.getSchoolDao();
            School schoolNew = targetDao.load(__key);
            synchronized (this) {
                school = schoolNew;
                school__resolvedKey = __key;
            }
        }
        return school;
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 1788415103)
    public void setSchool(School school) {
        synchronized (this) {
            this.school = school;
            schoolId = school == null ? null : school.getSchoolId();
            school__resolvedKey = schoolId;
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
    @Generated(hash = 2056799268)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getPersonDao() : null;
    }


}
