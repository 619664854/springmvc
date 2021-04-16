import com.spring.domain.User;
import com.spring.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:MapperTest
 * @Author Mr.guo
 * @Date 2021/4/16 21:19
 */
public class MapperTest {

    @Test
    public void test1() throws IOException {
        SqlSession session = getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        //if条件使用
        User condition = new User();
        condition.setId(1);
//        condition.setUsername("郭亚可");
        condition.setPassword("123456");
        List<User> userList = mapper.findByCondition(condition);
        System.out.println(userList);

        //foreach使用
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        List<User> byId = mapper.findById(ids);
        System.out.println(byId);
    }

    public static SqlSession getSession() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("MybatisMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }
}
