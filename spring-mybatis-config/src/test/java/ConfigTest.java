import com.spring.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import com.spring.mapper.UserMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * @ClassName:ConfigTest
 * @Author Mr.guo
 * @Date 2021/4/16 22:55
 */
public class ConfigTest {

    @Test
    public void test2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("MybatisMapperConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();



        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findById(7);
        System.out.println(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("MybatisMapperConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();

        User user = new User();
        user.setUsername("华会计师的");
        user.setPassword("12345");
        user.setBirthday(new Date());

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.save(user);

        sqlSession.commit();
        sqlSession.close();
    }

}
