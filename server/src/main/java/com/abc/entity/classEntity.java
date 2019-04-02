package com.abc.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * @program: biu
 * @description: class实体类
 * @author: zzw
 * @create: 2019-04-02 21:46
 **/
@TableName("t_class")
public class classEntity extends Model<classEntity> {
    @TableId(type = IdType.ID_WORKER_STR)
    private String classId;        //班级Id
    private String className;      //班级名称
    private String clasType;       //班级类型
    private String classHeader;   //班主任

    @Override
    protected Serializable pkVal() {return classId;}

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClasType() {
        return clasType;
    }

    public void setClasType(String clasType) {
        this.clasType = clasType;
    }

    public String getClassHeader() {
        return classHeader;
    }

    public void setClassHeader(String classHeader) {
        this.classHeader = classHeader;
    }
}
