package com.gwg.springcloud.controller;



import com.gwg.springcloud.common.Result;
import com.gwg.springcloud.dto.response.CourseDto;
import com.gwg.springcloud.dto.response.StudentDto;
import com.gwg.springcloud.model.Student;
import com.gwg.springcloud.remote.IStudentRemote;
import com.gwg.springcloud.service.IStudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
//@RequestMapping("/student")
public class StudentController implements IStudentRemote{

    private static Logger logger = LogManager.getLogger(StudentController.class.getName());


    @Autowired
    private IStudentService studentService;

    public @ResponseBody Result<StudentDto> studentInfo(@PathVariable("id") Integer id) {
        logger.info("studentInof start ......");
        Student student = studentService.selectById(id);
        StudentDto studentDto = new StudentDto();
        BeanUtils.copyProperties(student, studentDto);
        return student != null ? Result.success(studentDto) : Result.error("学生信息不存在");
    }

}

