package jailer.jdbc.web.sample;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@SpringBootApplication
@MapperScan("jailer.jdbc.web.sample.mapper")
public class ApplicationStarter {
	private static final String TYPE_ALIASES_PACKAGE = "jailer.jdbc.web.sample.model";

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ApplicationStarter.class, args);
	}

	@Bean
	@Autowired
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setTypeAliasesPackage(TYPE_ALIASES_PACKAGE);
		return sqlSessionFactoryBean.getObject();
	}
    
    @Bean
    @Autowired
    public DataSourceTransactionManager transactionManager(DataSource dataSource) throws Exception {
    	return new DataSourceTransactionManager(dataSource);
    }
}
