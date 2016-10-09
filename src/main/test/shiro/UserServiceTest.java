package shiro;

import com.tikie.shiro.entity.User;
import com.tikie.shiro.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @targget     测试UserService类
 *
 * @author      tikie
 * @date        2016-09-29
 * @version     1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/config/test/applicationContext_test.xml"})
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testGetById(){
        User user = userService.getById(0);

        System.out.println(user.getId());
        System.out.println(user.getAccount());
        System.out.println(user.getRoleRelationList().toString());
    }
}