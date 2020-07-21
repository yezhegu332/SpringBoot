package com.listen.springboot.service.impl;

import com.listen.springboot.mapper.StudentMapper;
import com.listen.springboot.service.StudentService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Listen
 * @Date: 2020/7/21
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Integer queryAllStudentCount() {
        //首先去redis缓存中查询
        /*Integer allStudentCount = (Integer) redisTemplate.opsForValue().get("allStudentCount");
        //判断是否有值
        if(null == allStudentCount){
            //没有：去数据库查询，并存放到redis缓存中
        }*/
        /*if(!ObjectUtils.allNotNull(allStudentCount)){
            //没有：去数据库查询，并存放到redis缓存中
            //去数据库查询
            System.out.println("去数据库查询");
            allStudentCount = studentMapper.selectAllStudentCount();
            //存放到redis缓存中
            redisTemplate.opsForValue().set("allStudentCount", allStudentCount,20, TimeUnit.SECONDS);
        }else{
            System.out.println("去redis缓存中查询");
            //有：直接返回
        }*/

        //以上代码在多线程高并发的时候会引发一种现象叫做：缓存穿透
        //使用双重检测+同步代码块的方式来解决"缓存穿透"现象
        //首先去redis缓存中查询
        Integer allStudentCount = (Integer) redisTemplate.opsForValue().get("allStudentCount");
        if (!ObjectUtils.allNotNull(allStudentCount)) {
            synchronized (this) {
                //再次从redis缓存中查询
                allStudentCount = (Integer) redisTemplate.opsForValue().get("allStudentCount");
                if (!ObjectUtils.allNotNull(allStudentCount)) {
                    //去数据库查询
                    allStudentCount = studentMapper.selectAllStudentCount();
                    System.out.println(Thread.currentThread().getName()+"去数据库查询:" + allStudentCount);
                    //并放到redis缓存中
                    redisTemplate.opsForValue().set("allStudentCount", allStudentCount, 10, TimeUnit.MILLISECONDS);
                }
            }
        } else {
            System.out.println(Thread.currentThread().getName()+"去redis缓存中查询" + allStudentCount);
            //有：直接返回
        }
        return allStudentCount;
    }
}
