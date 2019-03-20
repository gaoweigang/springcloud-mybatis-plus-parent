package com.gwg.springcloud.service.impl;

import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gwg.springcloud.mapper.CourseMapper;
import com.gwg.springcloud.model.Course;
import com.gwg.springcloud.service.ICourseService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gaoweigang123
 * @since 2019-03-19
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {

}
