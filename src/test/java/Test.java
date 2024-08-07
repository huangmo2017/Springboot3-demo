import com.hdm.Application;
import com.hdm.service.DroolsService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description
 * @Author HDM
 * @Date 2024-08-07 下午8:47
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class Test {

    @Autowired
    private DroolsService droolsService;

    @org.junit.Test
    public void testServiceMethod() {
        // 调用服务方法
        droolsService.executeRules();
    }

}
