package com.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

//标志该类是spring的核心配置类
@Configuration
//  <context:component-scan base-package="com"></context:component-scan>
@ComponentScan("com")
//<import resource=""></import>
@Import({DataSourceConfiguration.class})
public class SpringConfiguration {


}
