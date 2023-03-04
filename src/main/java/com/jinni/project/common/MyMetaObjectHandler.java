package com.jinni.project.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

import com.sun.prism.impl.BaseContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @ClassName MetaObjectHandler
 * @Description 自定义元数据对象处理器 https://www.cnblogs.com/KizunaAI/p/16262875.html#%E5%85%AC%E5%85%B1%E5%AD%97%E6%AE%B5%E8%87%AA%E5%8A%A8%E5%A1%AB%E5%85%85
 * @Author 林jy
 **/
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * 插入数据时自动填充
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("公共字段自动填充【insert】。。。");
        log.info(metaObject.toString());

        /* 填充的api:metaObject.setValue()*/
        metaObject.setValue("createTime", LocalDateTime.now());
        metaObject.setValue("updateTime", LocalDateTime.now());
        metaObject.setValue("createUser", BaseContext.getCurrentId());
        metaObject.setValue("updateUser", BaseContext.getCurrentId());
    }

    /**
     * 更新数据时自动填充
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("公共字段自动填充【update】。。。");
        log.info(metaObject.toString());

        long id = Thread.currentThread().getId() ;
        log.info("线程id:{}" ,id);

        /* 填充的api:metaObject.setValue()*/
        metaObject.setValue("updateTime",LocalDateTime.now());
        metaObject.setValue("updateUser",BaseContext.getCurrentId());

    }
}
