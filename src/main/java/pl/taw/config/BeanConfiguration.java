/**
 * Created by tomasz_taw
 * Date: 08.12.2023
 * Time: 20:48
 * Project Name: todoApp
 * Description:
 */
package pl.taw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@Configuration
public class BeanConfiguration {

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }
}
