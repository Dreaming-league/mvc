package shiro;

import com.tikie.common.util.response.ResponseJson;
import com.tikie.shiro.entity.User;
import com.tikie.shiro.service.UserService;
import org.apache.shiro.util.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @targget     测试UserService类
 *
 * @author      tikie
 * @date        2016-09-29
 * @version     1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/config/test/applicationContext_test.xml"})
public class UserServiceTest {
    @Resource
    private UserService userService;

//    @Test
//    public void testAdd(){
//        User user = new User();
//        user.setAccount("123@qq.com");
//        user.setCompany("kk");
//        user.setCreatedBy(new Date().toString());
//        user.setNickName("tikie");
//        Boolean id = userService.add(user);
//
//        System.out.println("输出内容:"+ id);
//        System.out.println("输出内容:"+ user.toString());
//    }

//    @Test
//    public void testGetById(){
//        User user = userService.getById(0);
//
//        System.out.println(user.getId());
//        System.out.println(user.getAccount());
//        System.out.println(user.getRoleRelationList().toString());
//    }

//    @Test
//    public void testDeleteByIds(){
//        Integer[] ids = {1,2,3};
//        System.out.println("输出内容:"+ userService.deleteByIds(ids));
//    }

//    @Test
//    public void testUpdate(){
//        User user = new User();
//        user.setAccount("123");
//        user.setId(10L);
//        user.setIsDelete("0");
//        user.setUpdatedTime(new Date());
//        Boolean t = userService.update(user);
//
//        System.out.println("输出内容:"+ t);
//        System.out.println("输出内容:"+ user);
//
//    }

//    @Test
//    public void testGetByAccount(){
//        User user = userService.getByAccount("290315636@qq.com");
//        System.out.println(user.getId());
//        System.out.println(user.getAccount());
//        System.out.println(user.getRoleRelationList().toString());
//    }

    @Test
    public void testGetAll(){
        ResponseJson.getInstance().setSize(5);
        List<User> list = userService.getAll();

        Assert.notEmpty(list);

        for(User user:list){
            System.out.println("输出内容:"+ user.getAccount());
            System.out.println("输出内容:"+ user.getNickName());
        }
    }
}