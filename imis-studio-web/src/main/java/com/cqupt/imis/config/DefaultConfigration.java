package com.cqupt.imis.config;

import com.cqupt.imis.controller.Menu;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zhoujun
 * @date 2018/7/22
 */
@Configuration
public class DefaultConfigration {
    @Bean("menuList")
    @ConfigurationProperties(prefix="menulist.menu")
    public List<Menu> menu() {
        return new ArrayList<>();
    }
}
