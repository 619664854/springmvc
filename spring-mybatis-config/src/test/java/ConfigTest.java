import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import java.util.List;

/**
 * @ClassName:ConfigTest
 * @Author Mr.guo
 * @Date 2021/4/16 22:55
 */
public class ConfigTest {
    @Test
    public void test3() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("MybatisMapperConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        //设置分页相关参数 当前页 每页数量
        PageHelper.startPage(1,2);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.findAll();
        for (User user :userList){
            System.out.println(user);
        }
        //获取与分页相关参数
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        System.out.println("当前页:"+pageInfo.getPageNum());
        System.out.println("总页数:"+pageInfo.getPages());
        System.out.println("总条数:"+pageInfo.getTotal());
        System.out.println("每页数:"+ pageInfo.getPageSize());
        System.out.println(userList);
    }
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
