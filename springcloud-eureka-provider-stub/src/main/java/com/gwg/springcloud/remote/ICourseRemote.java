package com.gwg.springcloud.remote;

import com.gwg.springcloud.common.Result;
import com.gwg.springcloud.dto.response.CourseDto;
import com.gwg.springcloud.remote.fallback.ICourseFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(value="service-provider", fallbackFactory = ICourseFallback.class)
public interface ICourseRemote {

    @GetMapping(value="/api/courseInfo/{id}")
    public @ResponseBody  Result<CourseDto> courseInfo(@PathVariable("id") Integer id);
}
