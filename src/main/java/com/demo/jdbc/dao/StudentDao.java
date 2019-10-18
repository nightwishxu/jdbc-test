package com.demo.jdbc.dao;

import com.demo.jdbc.entity.Student;
import core.common.jdbc.BaseDaoSupport;
import core.common.jdbc.QueryRule;
import core.common.jdbc.datasource.DynamicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

/**
 * @param
 * @Auther: xuwenwei
 * @Date: 2018/8/9 10:05
 * @Description:
 */

@Repository
public class StudentDao extends BaseDaoSupport<Student,String> {

    private JdbcTemplate template;

    private DynamicDataSource dataSource;

    @Override
    protected String getPKColumn() {
        return "id";
    }

    @Override
    @Resource(name="dynamicDataSource")
    protected void setDataSource(DataSource dataSource) {
        this.dataSource = (DynamicDataSource)dataSource;
        this.setDataSourceReadOnly(dataSource);
        this.setDataSourceWrite(dataSource);
        this.dataSource.getDataSourceEntry().set("db_two");

    }

    public List<Student> selectByName(String name) throws Exception{
        //构建一个QureyRule 查询规则
        this.dataSource.getDataSourceEntry().set("db_two");
        QueryRule queryRule = QueryRule.getInstance();
        queryRule.andLike("name",name);
        return super.select(queryRule);
    }


}
