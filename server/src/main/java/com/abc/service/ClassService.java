package com.abc.service;

import com.abc.entity.classEntity;
import com.baomidou.mybatisplus.plugins.Page;

public interface ClassService {
    Page<classEntity> query(Page pageParam, String item);
}
