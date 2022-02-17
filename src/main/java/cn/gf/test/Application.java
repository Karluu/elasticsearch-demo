package cn.gf.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Created by GuoFeng
 * Describe :
 * Created on 2022/1/17
 * Modified By :
 */
@SpringBootApplication(scanBasePackages = {"cn.gf.test"}, exclude = DataSourceAutoConfiguration.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
