package shiro;

import com.tikie.shiro.entity.Permission;
import com.tikie.shiro.mapper.PermissionMapper;
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
@ContextConfiguration(locations = { "/config/test/applicationContext_test.xml"})
public class PermissionServiceTest {

    @Autowired
    private PermissionMapper permissionMapper;

    @Test
    public void testGetById(){
        Permission permission = permissionMapper.getById(0);

        System.out.println(permission.getName());
        System.out.println(permission.getRoleRelationList().toString());
    }
}