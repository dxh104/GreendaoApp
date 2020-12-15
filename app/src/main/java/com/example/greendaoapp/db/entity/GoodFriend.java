package com.example.greendaoapp.db.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.JoinProperty;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.List;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * Created by XHD on 2020/12/15
 * 好友表
 */
@Entity(
        //两个唯一约束，实现联合主键
        indexes = {
                @Index(value = "userId, friendUserId", unique = true),
        }
)
public class GoodFriend {
    @Id(autoincrement = true)
    private Long id;
    @NotNull
    private String userId;
    @NotNull
    private String friendUserId;

    @ToOne(joinProperty = "userId")//设置外键关系
    private User user;//User表中的主键
    @ToOne(joinProperty = "friendUserId")//设置外键关系
    private User friendUser;//User表中的主键

    //一对多 name 实体属性对应外联实体属性
    @ToMany(joinProperties = {
            @JoinProperty(name = "friendUserId", referencedName = "userId") //friendUserId代表GoodFriend中的外键，referencedName代表User中的主键
    })
    private List<User> friendUsers;
    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /**
     * Used for active entity operations.
     */
    @Generated(hash = 314690381)
    private transient GoodFriendDao myDao;

    @Generated(hash = 1458576392)
    public GoodFriend(Long id, @NotNull String userId, @NotNull String friendUserId) {
        this.id = id;
        this.userId = userId;
        this.friendUserId = friendUserId;
    }

    @Generated(hash = 417693941)
    public GoodFriend() {
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

    public String getFriendUserId() {
        return this.friendUserId;
    }

    public void setFriendUserId(String friendUserId) {
        this.friendUserId = friendUserId;
    }

    @Generated(hash = 1867105156)
    private transient String user__resolvedKey;

    /**
     * To-one relationship, resolved on first access.
     */
    @Generated(hash = 538271798)
    public User getUser() {
        String __key = this.userId;
        if (user__resolvedKey == null || user__resolvedKey != __key) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UserDao targetDao = daoSession.getUserDao();
            User userNew = targetDao.load(__key);
            synchronized (this) {
                user = userNew;
                user__resolvedKey = __key;
            }
        }
        return user;
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 1622843587)
    public void setUser(@NotNull User user) {
        if (user == null) {
            throw new DaoException("To-one property 'userId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.user = user;
            userId = user.getUserId();
            user__resolvedKey = userId;
        }
    }

    @Generated(hash = 333500403)
    private transient String friendUser__resolvedKey;

    /**
     * To-one relationship, resolved on first access.
     */
    @Generated(hash = 1294444447)
    public User getFriendUser() {
        String __key = this.friendUserId;
        if (friendUser__resolvedKey == null || friendUser__resolvedKey != __key) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UserDao targetDao = daoSession.getUserDao();
            User friendUserNew = targetDao.load(__key);
            synchronized (this) {
                friendUser = friendUserNew;
                friendUser__resolvedKey = __key;
            }
        }
        return friendUser;
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 871632222)
    public void setFriendUser(@NotNull User friendUser) {
        if (friendUser == null) {
            throw new DaoException("To-one property 'friendUserId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.friendUser = friendUser;
            friendUserId = friendUser.getUserId();
            friendUser__resolvedKey = friendUserId;
        }
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1355222416)
    public List<User> getFriendUsers() {
        if (friendUsers == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UserDao targetDao = daoSession.getUserDao();
            List<User> friendUsersNew = targetDao._queryGoodFriend_FriendUsers(friendUserId);
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

    @Override
    public String toString() {
//        List<User> friendUsers = getFriendUsers();
//        String str_friendUsers="";
//        for (int i = 0; i <friendUsers.size() ; i++) {
//            friendUsers.get(i).__setDaoSession(this.daoSession);
//            str_friendUsers+= friendUsers.get(i).toString()+"\n";
//        }
        return "GoodFriend{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", friendUserId='" + friendUserId + '\'' +
//                ", user=" + getUser().toString() +
//                ", user=" + user.toString() +
//                ", friendUser=" + getFriendUser().toString() +
//                ", friendUser=" + friendUser.toString() +
//                ", friendUsers=" + friendUsers.toString() +
                '}';
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 2074279892)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getGoodFriendDao() : null;
    }


}
