package shiro;

import com.tikie.shiro.entity.Authorization;
import com.tikie.shiro.entity.Role;
import com.tikie.shiro.service.AuthorizationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.validation.constraints.AssertTrue;
import java.util.List;

/**
 * @targget     测试UserService类
 *
 * @author      tikie
 * @date        2016-10-09
 * @version     1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/config/test/applicationContext_test.xml"})
public class AuthorizationServiceTest {

    @Autowired
    private AuthorizationService authorizationService;

    @Test
    public void testGetById(){
        Authorization auth = authorizationService.getById("0");

        Assert.assertNotNull(auth);

        System.out.println(auth.getName());
        System.out.println(auth.getRoleRelationList().toString());
        System.out.println(auth.getChildren().toString());
    }

    @Test
    public void testGetByRoleIds(){
        String[] ids = {"0","1"};
        List<Authorization> list = authorizationService.getByRoleIds(ids);
        Assert.assertTrue(list.size() > 0);
        System.out.println("输出内容:"+ list.toString());
    }
}