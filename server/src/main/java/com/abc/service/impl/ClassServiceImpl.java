package com.abc.service.impl;

import com.abc.entity.classEntity;
import com.abc.service.ClassService;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.stereotype.Service;

/**
 * @program: biu
 * @description: 班级信息 实现类
 * @author: zzw
 * @create: 2019-04-02 22:33
 **/
@Service
public class ClassServiceImpl implements ClassService {
    @Override
    public Page<classEntity> query(Page pageParam, String item) {
        return null;
    }
}
