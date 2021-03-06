package com.test.test;


import android.test.AndroidTestCase;

import com.miniorm.android.DatabaseExcute;
import com.miniorm.android.impl.QueryImpl;
import com.miniorm.android.impl.ResultParseimpl;
import com.miniorm.android.impl.TableImpl;
import com.miniorm.dao.builder.QueryBuilder;

import junit.framework.TestCase;


public class test extends AndroidTestCase {

    /**
     */
    public void main() {
        // TODO Auto-generated method stub
        long timestart = System.currentTimeMillis();


        for (int i = 0; i < 1; i++) {
            Teacher user = new Teacher();


            user.setUserName("admin");
            user.setPwd("123");

            Student student = new Student();
            student.setAge(10);
            student.setId(10);
            student.setStuName("xiaoming");

            StuDao stuDao = new StuDao();
            //	stuDao.save(student);
            stuDao.setTableInterface(new TableImpl());

            user.setStudent(student);

            TeacherDao baseDao = new TeacherDao();
            baseDao.setTableInterface(new TableImpl());
            baseDao.setResultParse(new ResultParseimpl());
            baseDao.setDatabaseexcute(new DatabaseExcute());
            baseDao.setQueryInterface(new QueryImpl());
            baseDao.createTable();

            user.setId(1);
            baseDao.update(user);
            //	baseDao.QueryById(1);

            baseDao.save(user);
            baseDao.delete(user);
            baseDao.queryAll();
            //	baseDao.createTable();
            baseDao.queryByEntity(user);


            QueryBuilder<Teacher> queryBuilder = new QueryBuilder<Teacher>(Teacher.class);
            //	queryBuilder.CallQueryWorker().select("pwd","username").where().eq("pwd","123sd").and().eq("username", "1232213").excute();

        }
        System.out.println(System.currentTimeMillis() - timestart);
    }

}
