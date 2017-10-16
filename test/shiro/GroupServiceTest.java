package shiro;

import com.tikie.shiro.entity.Group;
import com.tikie.shiro.service.GroupService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author TiKie
 * @desc 目的
 * @date 2017/10/16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/config/test/applicationContext_test.xml"})
public class GroupServiceTest {

    @Autowired
    private GroupService groupService;

    @Test
    public void testGetById(){
        Group group = groupService.getById("0");

        System.out.println(group.getId());
        System.out.println(group.getName());
        System.out.println(group.getUserList().toString());
    }
}
