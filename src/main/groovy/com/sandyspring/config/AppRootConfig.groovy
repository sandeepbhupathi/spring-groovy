package com.sandyspring.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.core.io.FileSystemResource
import org.springframework.core.io.ResourceLoader

import javax.annotation.Resource

/**
 * Created by sande on 7/1/2017.
 */
@Configuration
@ComponentScan(basePackages = ['com.sandyspring.dao','com.sandyspring.service',
        'com.sandyspring.controller','com.sandyspring.logging'])
@EnableAspectJAutoProxy
class AppRootConfig {
    @Bean
    PropertyPlaceholderConfigurer getPropertyPlaceholder(){
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer()
        propertyPlaceholderConfigurer.setLocation(new FileSystemResource(this.getClass().getClassLoader().getResource("sample.properties").path))

        propertyPlaceholderConfigurer

    }
}
