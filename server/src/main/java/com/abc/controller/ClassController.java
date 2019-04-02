package com.abc.controller;

import com.abc.annotation.PermInfo;
import com.abc.entity.classEntity;
import com.abc.service.ClassService;
import com.abc.util.PageUtils;
import com.abc.vo.Json;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @program: biu
 * @description: 班级信息controller
 * @author: zzw
 * @create: 2019-04-02 21:19
 **/
@PermInfo(value = "选项模块", pval = "a:option")
@RestController
@RequestMapping("/class")
public class ClassController {
    private static final Logger log = LoggerFactory.getLogger(ClassController.class);

    @Autowired
    private ClassService classService;

    @GetMapping("/query")
    public Json query(@RequestBody String body) {
        String oper ="query class";
        log.info("{}, body: {}", oper, body);
        JSONObject json = JSON.parseObject(body);
        String item = json.getString("rname");
        Page<classEntity>page = classService.query(PageUtils.getPageParam(json), item);
        return null;
    }



}
