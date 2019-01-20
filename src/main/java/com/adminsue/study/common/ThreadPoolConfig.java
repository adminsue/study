package com.adminsue.study.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Config some thread pools
 *
 * @author adminsue[ceo@adminsue.com]
 * @since 2019-01-20.
 */
@EnableAsync
@Configuration
public class ThreadPoolConfig {

    @Bean(name = "firstTaskExecutor")
    public Executor firstTaskExecutor() {
        //SpringFrameWork 的 ThreadPoolTaskExecutor 是辅助 JDK 的 ThreadPoolExecutor 的工具类，
        // 它将属性通过 JavaBeans 的命名规则提供出来，方便进行配置。
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);
        executor.setMaxPoolSize(4);
        executor.setThreadNamePrefix("firstTaskExecutor-");
        executor.initialize();
        return executor;
    }

    @Bean(name = "secondTaskExecutor")
    public Executor secondTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);
        executor.setMaxPoolSize(4);
        executor.setThreadNamePrefix("secondTaskExecutor-");
        executor.initialize();
        return executor;
    }

}
