import com.spring.domain.Order;
import com.spring.mapper.OrderMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName:MultiTest
 * @Author Mr.guo
 * @Date 2021/4/18 19:19
 */
public class MultiTest {

    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mapperConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orderList = mapper.findAll();
        for (Order order :orderList){
            System.out.println(order);
        }
    }
}
