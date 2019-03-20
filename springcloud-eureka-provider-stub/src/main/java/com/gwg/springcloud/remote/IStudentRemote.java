package com.gwg.springcloud.remote;

import com.gwg.springcloud.common.Result;
import com.gwg.springcloud.dto.response.StudentDto;
import com.gwg.springcloud.remote.fallback.IStudentFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(value="service-provider", fallbackFactory = IStudentFallback.class)
public interface IStudentRemote {

    @GetMapping("/api/studentInfo/{id}")
    public @ResponseBody Result<StudentDto> studentInfo(@PathVariable("id") Integer id);
}
