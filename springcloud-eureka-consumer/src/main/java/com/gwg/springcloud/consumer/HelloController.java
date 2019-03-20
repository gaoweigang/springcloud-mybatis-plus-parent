package com.gwg.springcloud.consumer;

import com.gwg.springcloud.common.Result;
import com.gwg.springcloud.dto.response.StudentDto;
import com.gwg.springcloud.remote.IHelloRemote;
import com.gwg.springcloud.remote.IStudentRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @Value("${name:unknown}")
    private String name;

    @Autowired
    private IHelloRemote helloRemote;

    @Autowired
    private IStudentRemote studentRemote;


    /**
     * 应用Consumer调用应用Provider的服务printServiceProvider
     * @return
     */
    @RequestMapping("/hello")
    public @ResponseBody Result hello() {
        System.out.println("调用开始 hello start ****************");
        Result<String> result = helloRemote.printServiceProvider("gaoweigang", 11);
        System.out.println("获取结果 "+result.getMessage());
        return result;
    }

    @RequestMapping("/studentInfo")
    public @ResponseBody Result studentInfo(){
        System.out.println("调用开始 studentInfo start ****************");
        Result<StudentDto> result = studentRemote.studentInfo(1);
        System.out.println("获取结果 "+result.getMessage());
        return result;
    }
}