package com.example.greendaoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.greendaoapp.db.base.BaseDao;
import com.example.greendaoapp.db.entity.Person;
import com.example.greendaoapp.db.entity.School;
import com.example.greendaoapp.db.entity.Student;
import com.example.greendaoapp.db.manager.DaoManager;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private volatile boolean intercept = false;
    private Button btnInsert;
    private TextView tvData;
    private DaoManager daoManager;
    private BaseDao<Person, Long> personLongBaseDao;
    private BaseDao<Student, Long> studentLongBaseDao;
    private BaseDao<School, Long> schoolLongBaseDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        daoManager = DaoManager.getInstance(this);
        personLongBaseDao = new BaseDao<>(daoManager.getDaoSession().getPersonDao());
        studentLongBaseDao = new BaseDao<>(daoManager.getDaoSession().getStudentDao());
        schoolLongBaseDao = new BaseDao<>(daoManager.getDaoSession().getSchoolDao());
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!intercept) {
                    tvData.post(new Runnable() {
                        @Override
                        public void run() {
                            String str = "";
                            List<Student> studentList = studentLongBaseDao.queryAll();
                            List<School> schoolList = schoolLongBaseDao.queryAll();
                            for (int i = 0; i < studentList.size(); i++) {
                                str += studentList.get(i).toString() + "\n";
                            }

                            for (int i = 0; i < schoolList.size(); i++) {
                                str += schoolList.get(i).toString() + "\n";
                            }
                            tvData.setText(str);
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
//                Person person = new Person();
//                person.setAge(11);
//                person.setUserId("uId" + System.currentTimeMillis());//唯一
//                person.setUserName("uName" + System.currentTimeMillis());//非空
//                person.setAge2(12);
//                personLongBaseDao.save(person);

                School school = new School();
                school.setSchoolId(System.currentTimeMillis() + "");
                school.setId(System.currentTimeMillis());
                school.setSchoolName("名校");
                schoolLongBaseDao.save(school);

                Student student = new Student();
                student.setStudentId(System.currentTimeMillis() + "");
                student.setStudentAge(11);
                student.setStudentName("小米");
                student.setStudentName1("小米1");
                studentLongBaseDao.save(student);
                Log.i("-----", "onClick: " + student.toString());
            }
        });
    }

    private void initView() {
        btnInsert = (Button) findViewById(R.id.btnInsert);
        tvData = (TextView) findViewById(R.id.tv_data);
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
