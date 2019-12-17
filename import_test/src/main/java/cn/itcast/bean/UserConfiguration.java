package cn.itcast.bean;

import org.springframework.context.annotation.Bean;


public class UserConfiguration {
    @Bean
    public User getUser(){
        User user = new User();
        user.setAge(12);
        user.setUsername("bailey");
        return user;
    }
}
