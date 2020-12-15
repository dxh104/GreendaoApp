package com.example.greendaoapp.db.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.DaoException;

import java.util.List;


/**
 * Created by XHD on 2020/12/15
 * 用户信息表
 */
@Entity
public class User {
    @Property(nameInDb = "userId") //字段别名
    @Id(autoincrement = false)//主键，Long类型可以设置自增
    private String userId;
    @NotNull //属性不能为空
    private String userName;
    @NotNull //属性不能为空
    private int userAge;
    @NotNull //属性不能为空
    private boolean userSex;//true 男
    @NotNull
    @Unique
    private String studentId;//学号 外键
    //    @Index(unique = true)//设置唯一索引
    @Transient //使用该注释的属性不会被存入数据库的字段中
    private String transientId;

    //一对多 实体ID对应外联实体属性 referencedJoinProperty
    @ToMany(referencedJoinProperty = "userId")//userId代表GoodFriend外键
    private List<GoodFriend> goodFriends;

    @ToMany
    //多对多，@JoinEntity注解：entity 中间表；sourceProperty 实体属性；targetProperty 外链实体属性
    @JoinEntity(//如果两个实体是多对多的关系，那么需要第三张表（表示两个实体关系的表）
            entity = GoodFriend.class,
            sourceProperty = "userId",
            targetProperty = "friendUserId"
    )
    private List<User> friendUsers;

    //一对一 定义到另一个实体对象的关系，应在持有目标实体对象的字段上使用该注解
    @ToOne(joinProperty = "studentId")//学号 外键
    private Student student;
    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /**
     * Used for active entity operations.
     */
    @Generated(hash = 1507654846)
    private transient UserDao myDao;


    @Generated(hash = 65735257)
    public User(String userId, @NotNull String userName, int userAge,
                boolean userSex, @NotNull String studentId) {
        this.userId = userId;
        this.userName = userName;
        this.userAge = userAge;
        this.userSex = userSex;
        this.studentId = studentId;
    }


    @Generated(hash = 586692638)
    public User() {
    }


    @Generated(hash = 635690445)
    private transient String student__resolvedKey;


    @Override
    public String toString() {
//        String goodFriends = "";
//        String friendUsers = "";
//        for (int i = 0; i < getGoodFriends().size(); i++) {
//            goodFriends += getGoodFriends().get(i).toString() + "\n";
//        }
//        for (int i = 0; i < getFriendUsers().size(); i++) {
//            friendUsers += getFriendUsers().get(i).toString() + "\n";
//        }
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", userSex=" + userSex +
                ", studentId='" + studentId + '\'' +
                ", transientId='" + transientId + '\'' +
                ", goodFriends=" + goodFriends +
                ", friendUsers=" + friendUsers +
                ", student=" + student.toString() +
                '}';
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


    public int getUserAge() {
        return this.userAge;
    }


    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }


    public boolean getUserSex() {
        return this.userSex;
    }


    public void setUserSex(boolean userSex) {
        this.userSex = userSex;
    }


    public String getStudentId() {
        return this.studentId;
    }


    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }


    /**
     * To-one relationship, resolved on first access.
     */
    @Generated(hash = 1107348382)
    public Student getStudent() {
        String __key = this.studentId;
        if (student__resolvedKey == null || student__resolvedKey != __key) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            StudentDao targetDao = daoSession.getStudentDao();
            Student studentNew = targetDao.load(__key);
            synchronized (this) {
                student = studentNew;
                student__resolvedKey = __key;
            }
        }
        return student;
    }


    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 2139866900)
    public void setStudent(@NotNull Student student) {
        if (student == null) {
            throw new DaoException(
                    "To-one property 'studentId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.student = student;
            studentId = student.getStudentId();
            student__resolvedKey = studentId;
        }
    }


    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 2073816954)
    public List<GoodFriend> getGoodFriends() {
        if (goodFriends == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            GoodFriendDao targetDao = daoSession.getGoodFriendDao();
            List<GoodFriend> goodFriendsNew = targetDao
                    ._queryUser_GoodFriends(userId);
            synchronized (this) {
                if (goodFriends == null) {
                    goodFriends = goodFriendsNew;
                }
            }
        }
        return goodFriends;
    }


    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    @Generated(hash = 574544772)
    public synchronized void resetGoodFriends() {
        goodFriends = null;
    }


    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1403625722)
    public List<User> getFriendUsers() {
        if (friendUsers == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UserDao targetDao = daoSession.getUserDao();
            List<User> friendUsersNew = targetDao._queryUser_FriendUsers(userId);
            synchronized (this) {
                if (friendUsers == null) {
                    friendUsers = friendUsersNew;
                }
            }
        }
        return friendUsers;
    }


    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    @Generated(hash = 2101927086)
    public synchronized void resetFriendUsers() {
        friendUsers = null;
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
    @Generated(hash = 2059241980)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUserDao() : null;
    }


}
