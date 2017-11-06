package shiro;

import com.tikie.shiro.entity.Group;
import com.tikie.shiro.service.GroupService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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
        Assert.assertNotNull(group);
        System.out.println(group.getId());
        System.out.println(group.getCreatedTime());
        System.out.println(group.getUserList().toString());
    }

    @Test
    public void testGetByIds(){
        String[] ids = {"0","1"};
        List<Group> list =  groupService.getByIds(ids);
        Assert.assertTrue(list.size()>0);

        System.out.println("输出内容:"+ list.toString());
    }
}
