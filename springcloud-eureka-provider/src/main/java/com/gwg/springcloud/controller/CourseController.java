package com.gwg.springcloud.controller;


import com.gwg.springcloud.common.Result;
import com.gwg.springcloud.dto.response.CourseDto;
import com.gwg.springcloud.model.Course;
import com.gwg.springcloud.remote.ICourseRemote;
import com.gwg.springcloud.service.ICourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gaoweigang123
 * @since 2019-03-19
 */
@RestController
/**
 * 注意：在这里@RequestMapping不要加，否则Eureka服务调用方依赖了springcloud-eureka-provider-stub之后还是无法访问该服务。
 */
//@RequestMapping("/course")
public class CourseController implements ICourseRemote{

    @Autowired
    private ICourseService courseService;

    public @ResponseBody Result<CourseDto> courseInfo(@PathVariable("id") Integer id) {
        Course course = courseService.selectById(id);
        CourseDto courseDto = new CourseDto();
        BeanUtils.copyProperties(course, courseDto);
        return course != null ? Result.success(courseDto) : Result.error("课程信息不存在");
    }



}

