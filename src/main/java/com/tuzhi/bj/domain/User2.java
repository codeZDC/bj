package com.tuzhi.bj.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tuzhi.bj.base.BaseDomain;


/**
 * @ClassName:User2
 * @Description:员工表的实体类
 * @author codeZ
 * @CreateDate 2018-05-11 11:56:40
 */
@Table(name = "tt_user2")
public class User2 extends BaseDomain {
	
    /**ID**/
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**姓名**/
    private String name;

    /**年龄**/
    private Integer age;

    /**职位**/
    private String job;

    /**ID**/
    public Integer getId(){
        return id;
    }
    /**ID**/
    public void setId(Integer id){
        this.id= id;
    }
    /**姓名**/
    public String getName(){
        return name;
    }
    /**姓名**/
    public void setName(String name){
        this.name= name;
    }
    /**年龄**/
    public Integer getAge(){
        return age;
    }
    /**年龄**/
    public void setAge(Integer age){
        this.age= age;
    }
    /**职位**/
    public String getJob(){
        return job;
    }
    /**职位**/
    public void setJob(String job){
        this.job= job;
    }

	
}
