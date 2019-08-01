package demo.lazybean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @author zacconding
 * @Date 2018-08-28
 * @GitHub : https://github.com/zacscoding
 */

@Slf4j
@Lazy
@Configuration
public class LazyBeanConfiguration2 {

    public LazyBeanConfiguration2() {
        logger.info("## LazyBeanConfiguration2() is called");
    }

    @Bean
    public LazyBeanService3 lazyBeanService3() {
        logger.info("## lazyBeanService3() is called in LazyBeanConfiguration");
        return new LazyBeanService3();
    }

    @Bean
    public LazyBeanService4 lazyBeanService4() {
        logger.info("## lazyBeanService4() is called in LazyBeanConfiguration");
        return new LazyBeanService4();
    }
}
