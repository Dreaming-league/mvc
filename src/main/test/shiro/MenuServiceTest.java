package shiro;

import com.tikie.shiro.entity.Menu;
import com.tikie.shiro.service.MenuService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author TiKie
 * @desc 目的
 * @date 2017/10/17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/config/test/applicationContext_test.xml"})
public class MenuServiceTest {
    @Autowired
    public MenuService menuService;
    @Test
    public void testGetById(){
        Menu menu = menuService.getById("0");
        Assert.assertNotNull(menu);
        System.out.println(menu.getName());
        System.out.println(menu.getAuthRelationList().toString());
        System.out.println(menu.getChildren().toString());
    }
}
