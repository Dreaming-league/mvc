package test;

import com.tikie.test.entity.HelloWorld;
import com.tikie.test.service.HelloWorldService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @targget     测试HelloWorldService类
 *
 * @author      tikie
 * @date        2016-09-29
 * @version     1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/config/test/applicationContext_test.xml"})
public class HelloWorldServiceTest {

    @Autowired
    HelloWorldService helloWorldService;

//    @Test
//    /**
//     * @target  测试mybatis的获取数据能力
//     */
//    public void testGetById(){
//        HelloWorld hello = helloWorldService.getById(1);
//        System.out.println(hello.getMessage());
//    }

//    @Test
//    public void testInsert(){
//        HelloWorld hello = new HelloWorld();
//        hello.setMessage("你好吗?");
//        System.out.println(helloWorldService.insert(hello));
//        System.out.println(hello.getId());
//    }

//    @Test
//    public void testDelete(){
//        System.out.print(helloWorldService.deleteById(2));
//    }

//    @Test
//    public void testUpdate(){
//        HelloWorld hello = new HelloWorld();
//        hello.setId(3);
//        hello.setMessage("更改信息");
//        System.out.print(helloWorldService.update(hello));
//    }

    @Test
    public void testGetSimilarByMessage(){
        List<HelloWorld> list = helloWorldService.getSimilarByMessage("信息");
        for(HelloWorld hello:list){
            System.out.println(hello.getMessage());
        }
    }

    @Test
    public void testGetAll(){
        List<HelloWorld> list = helloWorldService.getAll();
        for(HelloWorld hello:list){
            System.out.println(hello.getMessage());
        }
    }
}