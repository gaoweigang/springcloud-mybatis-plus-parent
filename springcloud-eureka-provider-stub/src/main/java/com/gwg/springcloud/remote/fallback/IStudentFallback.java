package com.gwg.springcloud.remote.fallback;

import com.gwg.springcloud.common.Result;
import com.gwg.springcloud.dto.response.StudentDto;
import com.gwg.springcloud.remote.IStudentRemote;
import com.netflix.hystrix.exception.HystrixTimeoutException;
import feign.hystrix.FallbackFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;


@Component
//@Slf4j
public class IStudentFallback implements FallbackFactory<IStudentRemote> {
    private static final Logger logger = LogManager.getLogger(IStudentFallback.class.getName());

    @Override
    public IStudentRemote create(Throwable throwable) {
        System.out.println("IStudentFallback create ....");

        final StringBuffer message = new StringBuffer("IHelloRemote fallback");

        //在这里打印出异常，调试用
        //throwable.printStackTrace();

        if (throwable != null && throwable instanceof HystrixTimeoutException) {
            message.append(" timeout ");
            logger.error(message.toString(), throwable);

        }
        return new IStudentRemote() {
            private String msg = message.toString();

            @Override
            public Result<StudentDto> studentInfo(Integer id) {
                System.out.println("fallback ....");
                return  Result.error(msg);
            }
        };
    }
}
