package com.example.greendaoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.greendaoapp.db.base.BaseDao;
import com.example.greendaoapp.db.entity.GoodFriend;
import com.example.greendaoapp.db.entity.Student;
import com.example.greendaoapp.db.entity.StudentGrade;
import com.example.greendaoapp.db.entity.User;
import com.example.greendaoapp.db.manager.DaoManager;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private volatile boolean intercept = false;
    private Button btnInsert;
    private TextView tvData;
    private DaoManager daoManager;
    private BaseDao<Student, Long> studentLongBaseDao;
    private BaseDao<GoodFriend, Long> goodFriendLongBaseDao;
    private BaseDao<User, String> userStringBaseDao;
    private BaseDao<StudentGrade, Long> studentGradeStringBaseDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!intercept) {
                    tvData.post(new Runnable() {
                        @Override
                        public void run() {

                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<StudentGrade> studentGrades = studentGradeStringBaseDao.queryAll();
                String str="";
                for (int i = 0; i < studentGrades.size(); i++) {
                    str+=studentGrades.get(i).toString();
                }
                Log.i("----------", "studentGrades: "+str);
                str="";

                List<GoodFriend> goodFriends = goodFriendLongBaseDao.queryAll();
                for (int i = 0; i < goodFriends.size(); i++) {
                    goodFriends.get(i).__setDaoSession(daoManager.getDaoSession());
                    str+=goodFriends.get(i).toString();
                }
                Log.i("----------", "goodFriends: "+str);
                str="";

                List<Student> students = studentLongBaseDao.queryAll();
                for (int i = 0; i < students.size(); i++) {
                    students.get(i).__setDaoSession(daoManager.getDaoSession());
                    str+=students.get(i).toString();
                }
                Log.i("----------", "students: "+str);
                str="";

                List<User> users = userStringBaseDao.queryAll();
                for (int i = 0; i < users.size(); i++) {
                    users.get(i).__setDaoSession(daoManager.getDaoSession());
                    str+=users.get(i).toString();
                }
                Log.i("----------", "users: "+str);
            }
        });
        for (int i = 0; i < 6; i++) {//设置   年级表
            StudentGrade studentGrade = new StudentGrade();
            studentGrade.setStudentGradeId((long) i);
            studentGrade.setStudentGradeName(i + "年级");
            studentGradeStringBaseDao.saveOrUpdate(studentGrade);
        }
        for (int i = 0; i <10 ; i++) {
            Student student = new Student();
            student.setStudentId("sid_"+i);
            student.setStudentGrade(studentGradeStringBaseDao.query((long) (i%6)));
            student.setStudentGradeId(studentGradeStringBaseDao.query((long) (i%6)).getStudentGradeId());
            student.__setDaoSession(daoManager.getDaoSession());
            studentLongBaseDao.saveOrUpdate(student);//设置学生表
            User user = new User();
            user.setUserId("uId_"+i);
            user.setUserName("小米"+i);
            user.setUserAge(i);
            user.setUserSex(true);
            user.setStudent(student);
            user.setStudentId(student.getStudentId());
            user.__setDaoSession(daoManager.getDaoSession());
            userStringBaseDao.saveOrUpdate(user);//设置用户表
        }
        //设置好友表
        GoodFriend goodFriend = new GoodFriend();
        goodFriend.setUserId("uId_0");
        goodFriend.setFriendUserId("uId_1");
        goodFriendLongBaseDao.saveOrUpdate(goodFriend);
        goodFriend = new GoodFriend();
        goodFriend.setUserId("uId_1");
        goodFriend.setFriendUserId("uId_0");
        goodFriendLongBaseDao.saveOrUpdate(goodFriend);

    }

    private void initView() {
        btnInsert = (Button) findViewById(R.id.btnInsert);
        tvData = (TextView) findViewById(R.id.tv_data);

        daoManager = DaoManager.getInstance(this);
        studentLongBaseDao = new BaseDao<>(daoManager.getDaoSession().getStudentDao());//学生表
        goodFriendLongBaseDao = new BaseDao<>(daoManager.getDaoSession().getGoodFriendDao());//好友表
        userStringBaseDao = new BaseDao<>(daoManager.getDaoSession().getUserDao());//用户表
        studentGradeStringBaseDao = new BaseDao<>(daoManager.getDaoSession().getStudentGradeDao());//年级表
    }

    @Override
    protected void onDestroy() {
        daoManager.closeDataBase();
        intercept = true;
        super.onDestroy();
    }

    //总结:
    // 1.Greedao数据库新建表，字段变化，版本必须升级(不能降级，除非删除数据库.db文件)----通常情况数据库变化必须升级
    // 2.升级数据库版本后调用 newSession 会删除原数据库数据
    // 3.这时如果想要保留上个版本数据，可以再Application检查有没有数据库版本有没有变化，
    // 变化了:原数据库数据复制到新文件中或者改原数据库名称，等新数据库文件生成后，添加需要的数据到新数据库中
    //简单来说 就是先备份，再还原
    //4.建议每个app版本如果有数据库变化就升级一个版本，不用多升
}
