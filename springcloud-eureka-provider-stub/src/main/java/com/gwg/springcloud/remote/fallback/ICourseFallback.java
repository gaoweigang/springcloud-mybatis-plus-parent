package com.gwg.springcloud.remote.fallback;

import com.gwg.springcloud.common.Result;
import com.gwg.springcloud.dto.response.CourseDto;
import com.gwg.springcloud.remote.ICourseRemote;
import com.netflix.hystrix.exception.HystrixTimeoutException;
import feign.hystrix.FallbackFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class ICourseFallback implements FallbackFactory<ICourseRemote> {

    private static final Logger logger = LogManager.getLogger(ICourseFallback.class.getName());

    @Override
    public ICourseRemote create(Throwable throwable) {
        System.out.println("ICourseFallback create  ....");

        final StringBuffer message = new StringBuffer("IHelloRemote fallback");

        //在这里打印出异常，调试用
        //throwable.printStackTrace();

        if(throwable != null && throwable instanceof HystrixTimeoutException){
            message.append(" timeout ");
            logger.error(message.toString(), throwable);

        }
        return new ICourseRemote() {
            private String msg = message.toString();

            @Override
            public Result<CourseDto> courseInfo(Integer id) {
                System.out.println("fallback ....");
                return  Result.error(msg);
            }
        };
    }
}
