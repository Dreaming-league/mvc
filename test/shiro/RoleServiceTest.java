package shiro;

import com.tikie.shiro.entity.Role;
import com.tikie.shiro.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @targget     测试UserService类
 *
 * @author      tikie
 * @date        2016-10-09
 * @version     1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/config/test/applicationContext_test.xml"})
public class RoleServiceTest {

    @Autowired
    private RoleService roleService;

//    @Test
//    public void testGetById(){
//        Role role = roleService.getById(0L);
//
//        System.out.println(role.getId());
//        System.out.println(role.getName());
//        System.out.println(role.getUserRelationList().toString());
//        System.out.println(role.getPermissionRelationList().toString());
//    }

}