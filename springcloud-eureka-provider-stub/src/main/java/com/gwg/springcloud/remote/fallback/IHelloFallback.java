package com.gwg.springcloud.remote.fallback;

import com.gwg.springcloud.common.Result;
import com.gwg.springcloud.remote.IHelloRemote;
import com.netflix.hystrix.exception.HystrixTimeoutException;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * 熔断处理
 */
@Component
//@Slf4j
public class IHelloFallback implements FallbackFactory<IHelloRemote> {

    private static final Logger logger = LogManager.getLogger(IHelloFallback.class.getName());

    public IHelloRemote create(Throwable throwable) {
        System.out.println("IHelloFallback create ....");
        final StringBuffer message = new StringBuffer("IHelloRemote fallback");

        //在这里打印出异常，调试用
        //throwable.printStackTrace();

        if(throwable != null && throwable instanceof HystrixTimeoutException){
            message.append(" timeout ");
            logger.error(message.toString(), throwable);

        }
        return new IHelloRemote(){
            private String msg = message.toString();

            public Result<String> printServiceProvider(String name, int age) {
                System.out.println("fallback ....");
                return  Result.error(msg);
            }
        };
    }
}
