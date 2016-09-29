package test;

import com.tikie.test.entity.HelloWorld;
import com.tikie.test.service.HelloWorldService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @targget     测试HelloWorldService类
 *
 * @author      tikie
 * @date        2016-09-29
 * @version     1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/config/test/applicationContext_test.xml"})
public class HelloWorldServiceTest {

    @Autowired
    HelloWorldService helloWorldService;

    @Test
    /**
     * @target  测试mybatis的获取数据能力
     */
    public void testGetById(){
        HelloWorld hello = helloWorldService.getById(0);
        System.out.println(hello.getMessage());
    }
}