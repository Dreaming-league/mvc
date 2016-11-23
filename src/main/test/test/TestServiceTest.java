package test;

import com.tikie.generator.entity.TestExample;
import com.tikie.generator.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zcs
 * @desc 目的
 * @date 2016/11/23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/config/test/applicationContext_test.xml"})
public class TestServiceTest {
    @Autowired
    TestService testService;

    @Test
    public void test(){
        TestExample example = new TestExample();
        example.createCriteria().andIdEqualTo(3L);
        int i = testService.deleteByExample(example);
        System.out.println("输出内容:"+ i);
    }
}