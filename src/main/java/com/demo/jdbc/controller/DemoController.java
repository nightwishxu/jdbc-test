package com.demo.jdbc.controller;

import com.demo.jdbc.dao.StudentDao;
import com.demo.jdbc.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

/**
 * @param
 * @Auther: xuwenwei
 * @Date: 2018/8/9 10:04
 * @Description:
 */
@RestController
@RequestMapping("student")
public class DemoController{

    @Autowired
    private StudentDao studentDao;

    @GetMapping("/get")
    public Object get(String name) throws Exception{
        List<Student> list= studentDao.selectByName(name);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(Objects.equals(null,1));
    }

}
