/**
 * @file: PolApplication
 * @author: michael
 * @date: 2019/10/15 16:39
 * @copyright: 南京凯盛
 */
package org.kisen.cloud.mms.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author michael
 * @version 1.0 Created on 2019/10/15 16:39
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@EnableConfigurationProperties
public class ShardingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingApplication.class, args);
    }


}