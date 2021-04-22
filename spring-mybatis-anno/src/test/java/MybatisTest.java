import com.spring.domain.Order;
import com.spring.domain.User;
import com.spring.mapper.OrderMapper;
import com.spring.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName:MybatisTest
 * @Author Mr.guo
 * @Date 2021/4/22 20:50
 */
public class MybatisTest {
    private UserMapper userMapper;
    private OrderMapper orderMapper;
    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//事物自动提交
        userMapper = sqlSession.getMapper(UserMapper.class);
        orderMapper = sqlSession.getMapper(OrderMapper.class);
    }

    @Test
    public void Test1(){
        List<Order> orderList = orderMapper.findAll();
        for (Order order : orderList) {
            System.out.println(order);
        }
    }

    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("埃里克森底就");
        user.setPassword("123456");
        userMapper.save(user);
    }

    @Test
    public void testUpd(){
        User user = new User();
        user.setId(13);
        user.setUsername("埃里就");
        user.setPassword("123456");
        userMapper.update(user);
    }

    @Test
    public void testDel(){
        userMapper.delete(13);
    }

    @Test
    public void testFindById(){
        User user = userMapper.findById(2);
        System.out.println(user);
    }

    @Test
    public void testFindAll(){
        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
