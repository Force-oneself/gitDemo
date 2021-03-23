package com.quan.demo.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

/**
 * @Description:
 * @Author heyq
 * @Date 2021-03-03
 **/
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        System.err.println("BeanDefinitionRegistryPostProcessor ==> postProcessBeanDefinitionRegistry,在这里可以增加修改删除bean的定义");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.err.println("BeanFactoryPostProcessor ==> postProcessBeanFactory,在这里可以对beanFactory做一些操作");
    }
}