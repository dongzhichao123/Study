import com.bean.SpringConfig;
import com.mybatis.entity.User;
import com.mybatis.mapper.UserMapper;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.impl.client.HttpClients;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @author dong
 * @title: Test
 * @projectName Spring-001
 * @description: TODO
 * @date 2022/2/3 23:45
 **/
public class TestDemo {

    public static void main(String[] args) {

//        System.out.println(StringUtils.cleanPath("\\D:\\bean.xml"));
//        System.out.println(StringUtils.cleanPath("\\D:\\bean.xml").substring(1));
//        ClassPathResource classPathResource = new ClassPathResource("bean.xml");
//        BeanFactory xmlBeanFactory = new XmlBeanFactory(classPathResource);

//        System.out.println(xmlBeanFactory.getBean("person", Person.class));
//
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
//        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            System.out.println(beanDefinitionName);
//        }
//        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
//        SqlSessionFactoryBean sqlSessionFactoryBean = (SqlSessionFactoryBean) applicationContext.getBean("sqlSessionFactoryBean");
//
//        List<User> users = userMapper.selectAllUser();
//        for (User user : users) {
//            System.out.println(user.toString());
//        }

        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod();
    }


}
