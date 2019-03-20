package com.gwg.springcloud.service.impl;

import com.gwg.springcloud.model.Student;
import com.gwg.springcloud.mapper.StudentMapper;
import com.gwg.springcloud.service.StudentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
